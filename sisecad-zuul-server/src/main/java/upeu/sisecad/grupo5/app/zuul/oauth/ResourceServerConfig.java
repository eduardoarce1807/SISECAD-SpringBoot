package upeu.sisecad.grupo5.app.zuul.oauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@RefreshScope
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Value("${config.security.oauth.jwt.key}")
	private String jwtKey;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(
				"/api/security/oauth/**",
				"/api/file/**",
				"/api/docente/swagger-ui.html",
				"/api/cronograma/swagger-ui.html",
				"/api/legajo/swagger-ui.html",
				"/api/entrevista/swagger-ui.html",
				"/api/nomina/swagger-ui.html",
				"/api/valor/swagger-ui.html",
				"/api/usuario/swagger-ui.html"
				).permitAll()
		.antMatchers(HttpMethod.GET,
				"/api/docente/",
				"/api/cronograma/",
				"/api/legajo/",
				"/api/entrevista/",
				"/api/nomina/",
				"/api/valor/",
				"/api/usuario/usuario"
				).permitAll()
		.antMatchers(HttpMethod.GET,
				"/api/docente/{id}",
				"/api/cronograma/{id}",
				"/api/legajo/{id}",
				"/api/entrevista/{id}",
				"/api/nomina/{id}",
				"/api/valor/{id}",
				"/api/usuario/usuario/{id}"
				).hasAnyRole("COMISION", "DOCENTE")
		.antMatchers(
				"/api/docente/**",
				"/api/cronograma/**",
				"/api/legajo/**",
				"/api/entrevista/**",
				"/api/nomina/**",
				"/api/valor/**",
				"/api/usuario/**"
				).hasRole("COMISION")
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("*"));
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedHeaders(Arrays.asList("*"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtKey);
		return tokenConverter;
	}

}

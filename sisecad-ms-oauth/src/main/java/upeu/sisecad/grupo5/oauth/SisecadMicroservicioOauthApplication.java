package upeu.sisecad.grupo5.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ms-oauth", version = "2.0"))
public class SisecadMicroservicioOauthApplication implements CommandLineRunner{
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SisecadMicroservicioOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String password = "123";
		
		for (int i = 0; i < 3; i++) {
			String passwordBCrypt = passwordEncode.encode(password);
			System.out.println(passwordBCrypt);
		}
	
	}

}

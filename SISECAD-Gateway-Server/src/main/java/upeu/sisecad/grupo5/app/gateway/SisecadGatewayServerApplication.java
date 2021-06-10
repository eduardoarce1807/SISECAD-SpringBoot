package upeu.sisecad.grupo5.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SisecadGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisecadGatewayServerApplication.class, args);
	}

}

package upeu.sisecad.grupo5.app.entrevista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ms-entrevista", version = "2.0"))
public class SisecadMicroservicioEntrevistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisecadMicroservicioEntrevistaApplication.class, args);
	}

}

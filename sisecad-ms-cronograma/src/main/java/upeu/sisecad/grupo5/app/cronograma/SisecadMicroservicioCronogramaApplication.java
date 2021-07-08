package upeu.sisecad.grupo5.app.cronograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ms-cronograma", version = "2.0"))
public class SisecadMicroservicioCronogramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisecadMicroservicioCronogramaApplication.class, args);
	}

}

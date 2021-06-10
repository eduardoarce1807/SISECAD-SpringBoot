package upeu.sisecad.grupo5.app.nomina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SisecadMicroservicioNominaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisecadMicroservicioNominaApplication.class, args);
	}

}

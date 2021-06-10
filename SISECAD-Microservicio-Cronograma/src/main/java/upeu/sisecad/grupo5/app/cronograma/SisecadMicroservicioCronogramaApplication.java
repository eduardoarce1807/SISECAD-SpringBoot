package upeu.sisecad.grupo5.app.cronograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SisecadMicroservicioCronogramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisecadMicroservicioCronogramaApplication.class, args);
	}

}

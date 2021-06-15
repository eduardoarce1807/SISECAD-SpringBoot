package upeu.sisecad.grupo5.app.valor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SisecadMicroservicioValorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisecadMicroservicioValorApplication.class, args);
	}

}

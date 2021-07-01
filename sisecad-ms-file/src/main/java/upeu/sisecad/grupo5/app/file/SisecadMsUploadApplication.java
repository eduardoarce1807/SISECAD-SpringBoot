package upeu.sisecad.grupo5.app.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SisecadMsUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisecadMsUploadApplication.class, args);
	}

}

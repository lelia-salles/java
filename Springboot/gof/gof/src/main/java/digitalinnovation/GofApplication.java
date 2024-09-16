package one.digitalinnovation.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GofApplication {

	@EnableFeignClients
	@EnableSpringBootApplication;
	public static void main(String[] args) {
		SpringApplication.run(GofApplication.class, args);
	}

}

package it.contrader;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;

/**
 * 
 * Da qui parte l'applicazione SpringBoot.
 * 
 * @author SpringBoot
 *
 */
@SpringBootApplication
public class SpringWebApplication {
	@Bean
	public RestTemplate getRestTemplate () {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
	
}

package com.beerdrum;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BeerDrumApplication {

	public static void main(String[] args) {
		System.out.println("Starting BeerDrumApplication Main");
		//System.setProperty("server.servlet.context-path");
		SpringApplication.run(BeerDrumApplication.class, args);
		//, "/inmo"
		
	}
}

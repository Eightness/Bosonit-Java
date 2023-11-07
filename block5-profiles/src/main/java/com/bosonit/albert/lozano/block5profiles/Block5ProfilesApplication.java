package com.bosonit.albert.lozano.block5profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Block5ProfilesApplication implements CommandLineRunner {

	@Value("${bd.url}")
	private String bdUrl;

	@Value("${spring.profiles.active}")
	private String activeProfile;

	private final Environment environment;

	public Block5ProfilesApplication(Environment environment) {
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Active Profile: " + activeProfile);
		System.out.println("Database URL: " + bdUrl);

		// Acceder a las propiedades directamente desde el entorno
		System.out.println("Active Profile (from Environment): " + environment.getProperty("spring.profiles.active"));
		System.out.println("Database URL (from Environment): " + environment.getProperty("bd.url"));
	}
}

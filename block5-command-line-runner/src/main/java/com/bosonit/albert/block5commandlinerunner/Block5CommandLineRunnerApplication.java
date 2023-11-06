package com.bosonit.albert.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Block5CommandLineRunnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("Hola desde clase inicial.");
	}

	@Bean
	CommandLineRunner secondClass() {
		return p -> {
			System.out.println("Hola desde clase secundaria.");
		};
	}

	@Bean
	CommandLineRunner thirdClass() {
		return p -> {
			System.out.println("Soy la tercera clase.");
		};
	}

}

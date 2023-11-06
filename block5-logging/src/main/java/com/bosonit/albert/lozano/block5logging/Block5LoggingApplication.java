package com.bosonit.albert.lozano.block5logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5LoggingApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Block5LoggingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Block5LoggingApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.error("Este es un registro de error.");
		logger.warn("Este es un registro de advertencia.");
		logger.info("Este es un registro de información.");
		logger.debug("Este es un registro de depuración.");
		logger.trace("Este es un registro de traza.");
	}
}

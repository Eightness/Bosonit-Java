/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Block10DockerizeAppApplication class. Runs this Spring Boot App.
 */
@SpringBootApplication
public class Block10DockerizeAppApplication {
	// Use /v3/api-docs to see this project's docs
	// Use /swagger-ui/index.html to see this project's docs and HTTP methods
	// User /h2-console to access the embedded database and ~/springdatademo to connect
	public static void main(String[] args) {
		SpringApplication.run(Block10DockerizeAppApplication.class, args);
	}

}

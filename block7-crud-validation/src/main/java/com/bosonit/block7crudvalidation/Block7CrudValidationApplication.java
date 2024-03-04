/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Block7CrudValidationApplication class. Contains main method to run the Spring boot application.
 */
@SpringBootApplication
public class Block7CrudValidationApplication {
	// To see this project's docs you can use these:
	// v3/api-docs
	// swagger-ui/index.html

	// /h2-console to access the embedded database. And ~/springadatademo to connect.

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudValidationApplication.class, args);
	}

}

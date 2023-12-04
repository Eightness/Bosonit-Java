/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */


package com.bosonit.albert.lozano.block6pathvariableheaders.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.bosonit.albert.lozano.block6pathvariableheaders.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class GreetingController.
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}

package com.bosonit.albert.lozano.block5profiles;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * Class ProfileConfiguration. Implements CommandLineRunner.
 * Its job is to set, show and verify current profile configuration.
 */
@Data
@Component
@Configuration
public class ProfileConfiguration implements CommandLineRunner {
    //Attributes.
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${bd.url}")
    private String bdUrl;

    private final ConfigurableEnvironment environment;

    //Constructor to set the environment.
    public ProfileConfiguration(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    //Methods.
    /**
     * run method. Contracted by CommandLineRunner interface.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        //Show current properties (Profile and database url).
        System.out.println("Active Profile: " + activeProfile);
        System.out.println("Database URL: " + bdUrl);

        //Access properties values directly from the environment (Profile and database url).
        System.out.println("Active Profile (from Environment): " + environment.getProperty("spring.profiles.active"));
        System.out.println("Database URL (from Environment): " + environment.getProperty("bd.url"));
    }
}

package com.bosonit.albert.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

/**
 * Class ConfigurationClass. Sets all necessary Beans for the app.
 */
@Configuration
public class ConfigurationClass {
    /**
     * postConstruct method. Runs before Beans are initialized.
     * Prints a message.
     */
    @PostConstruct
    private void postConstruct() {
        String message = "Hola desde clase inicial.";
        System.out.println(message);
    }

    /**
     * Bean secondClass.
     * @return an instance of SecondClass.
     */
    @Bean
    CommandLineRunner secondClass() {
        return args -> {
            System.out.println("Hola desde clase secundaria.");
        };
    }

    /**
     * Bean thirdClass.
     * @return an instance of ThirdClass.
     */
    @Bean
    CommandLineRunner thirdClass() {
        return args -> {
            String param1 = "Soy la tercera clase.";
            System.out.println(param1);
            //Second part of the exercise:
            if (args.length >= 2) {
                String param2 = args[0];
                String param3 = args[1];
                System.out.println(param2);
                System.out.println(param3);
            }
        };
    }

}

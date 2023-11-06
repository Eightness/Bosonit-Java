package com.bosonit.albert.lozano.block5properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Class EnvironmentVariableReader. Its job is to read environment variables (from OS).
 * Implements CommandLineRunner interface.
 */
@Component
public class EnvironmentVariableReader implements CommandLineRunner {
    //Attributes
    private final Environment environment;

    //Constructor
    public EnvironmentVariableReader(Environment environment) {
        this.environment = environment;
    }

    /**
     * run method. Contracted by CommandLineRunner interface. Runs once the app is initialized.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        //Exercise 3
//        String myUrl = environment.getProperty("MYURL");
//        if (myUrl != null) {
//            System.out.println("Valor de MYURL: " + myUrl);
//        } else {
//            System.out.println("MYURL no tiene valor.");
//        }
        //Exercise 4
        String myUrl2 = environment.getProperty("MYURL2", "NO_tengo_valor");    //Second parameter is defaultValue.
        System.out.println("Valor de MYURL2: " + myUrl2);
    }
}

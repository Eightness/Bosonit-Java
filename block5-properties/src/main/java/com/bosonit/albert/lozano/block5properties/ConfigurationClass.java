package com.bosonit.albert.lozano.block5properties;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Class ConfigurationClass. Sets all necessary property Values for the app.
 */
@Configuration
public class ConfigurationClass {
    //Attributes
    @Value("${greeting}")
    private String greeting;
    @Value("${my.number}")
    private int myNumber;
    //@Value("${new.property:new.property no tiene valor}") //Placeholder for new property.
    @Value("${new.property:Default value}")   //Takes system variable. "Default value" just in case there's no system variable.
    private String newProperty;

    /**
     * postConstruct method. Runs before any Beans are initialized.
     * Prints properties.
     */
    @PostConstruct
    private void printProperties() {
        System.out.println(greeting);
        System.out.println(myNumber);
        System.out.println(newProperty);
    }
}

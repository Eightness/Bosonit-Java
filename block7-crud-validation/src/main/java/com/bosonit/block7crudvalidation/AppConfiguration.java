/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation;

import com.bosonit.block7crudvalidation.application.PersonService;
import com.bosonit.block7crudvalidation.application.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class AppConfiguration. Defines all Beans for the project to run.
 */
@Configuration
public class AppConfiguration {
    //Bean for PersonService interface (returns the only class that implements it).
    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }
}

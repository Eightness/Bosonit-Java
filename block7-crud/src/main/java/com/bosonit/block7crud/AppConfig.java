package com.bosonit.block7crud;

import com.bosonit.block7crud.application.PersonService;
import com.bosonit.block7crud.application.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //Bean for PersonService interface (returns the only class that implements it).
    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

}

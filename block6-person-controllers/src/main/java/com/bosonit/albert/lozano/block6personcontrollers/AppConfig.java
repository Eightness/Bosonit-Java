/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6personcontrollers;

import com.bosonit.albert.lozano.block6personcontrollers.model.Person;
import com.bosonit.albert.lozano.block6personcontrollers.service.CityService;
import com.bosonit.albert.lozano.block6personcontrollers.service.CityServiceInterface;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonService;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class AppConfig. SpringBoot configuration to manage @beans.
 */
@Configuration
public class AppConfig {

    //For CityService (using CityServiceInterface).
    @Bean
    public CityServiceInterface cityServiceInterface() {
        return new CityService();
    }

    //For PersonService (using PersonServiceInterface).
    @Bean
    public PersonServiceInterface personServiceInterface() {
        return new PersonService();
    }

    //Person's beans.

    //Person1.
    @Bean()
    @Qualifier("Albert")
    public Person bean1() {
        return new Person("Albert", "Valencia", 26);
    }

    //Person2.
    @Bean
    @Qualifier("Thomas")
    public Person bean2() {
        return new Person("Thomas", "Valencia", 26);
    }

    //Person3.
    @Bean
    @Qualifier("Sergi")
    public Person bean3() {
        return new Person("Sergi", "Valencia", 23);
    }
}

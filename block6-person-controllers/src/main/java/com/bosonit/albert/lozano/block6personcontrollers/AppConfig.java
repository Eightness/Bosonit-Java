/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6personcontrollers;

import com.bosonit.albert.lozano.block6personcontrollers.service.CityService;
import com.bosonit.albert.lozano.block6personcontrollers.service.CityServiceInterface;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonService;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonServiceInterface;
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

    //Add more beans if needed.
}

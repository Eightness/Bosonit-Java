/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp;

import com.bosonit.block10dockerizeapp.application.implementations.CarServiceImpl;
import com.bosonit.block10dockerizeapp.application.services.IGenericService;
import com.bosonit.block10dockerizeapp.controller.dto.inputDto.CarInputDTO;
import com.bosonit.block10dockerizeapp.controller.dto.mappers.IGenericDTOMapper;
import com.bosonit.block10dockerizeapp.controller.dto.outputDto.CarOutputDTO;
import com.bosonit.block10dockerizeapp.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class AppConfiguration. Defines all Beans for the project to run.
 */
@Configuration
public class AppConfiguration {
    // Beans
    @Bean
    public IGenericService<CarInputDTO, CarOutputDTO, Long> carService() {
        return new CarServiceImpl();
    }
}

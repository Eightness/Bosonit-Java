/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.controller.dto.mappers;

import com.bosonit.block10dockerizeapp.controller.dto.inputDto.CarInputDTO;
import com.bosonit.block10dockerizeapp.controller.dto.outputDto.CarOutputDTO;
import com.bosonit.block10dockerizeapp.domain.Car;
import org.mapstruct.Mapper;

/**
 * CarMapper interface. It's a mapper from MapStruct. Automatically maps DTOs. Extends from IGenericDTOMapper, previously implemented.
 */
@Mapper(componentModel = "spring")
public interface CarMapper extends IGenericDTOMapper<CarInputDTO, Car, CarOutputDTO> {
    // We'll work with this mapper in CarServiceImpl
    // We could add some custom methods in here (related to mapping logic)
}

/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.GenericDTOMapper;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.bosonit.block7crudvalidation.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Interface PersonMapper. It's a mapper from MapStruct. Automatically maps DTOs.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper extends GenericDTOMapper<PersonInputDto, Person, PersonOutputDto> {
    //Logic: PersonInputDto -> Person -> PersonOutputDto
    //We'll work with this mapper in PersonServiceImpl.
}

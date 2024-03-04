/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.bosonit.block7crudvalidation.domain.Person;
import org.mapstruct.Mapper;

/**
 * PersonMapper interface. It's a mapper from MapStruct. Automatically maps DTOs. Extends from GenericDTOMapper, previously implemented.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper extends GenericDTOMapper<PersonInputDto, Person, PersonOutputDto> {
    // We'll work with this mapper in PersonServiceImpl
    // We could add some custom methods in here (related to mapping logic)
}

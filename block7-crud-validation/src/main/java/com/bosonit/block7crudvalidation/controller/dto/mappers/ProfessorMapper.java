/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.inputDto.ProfessorInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.ProfessorOutputDto;
import com.bosonit.block7crudvalidation.domain.Professor;
import org.mapstruct.Mapper;

/**
 * ProfessorMapper interface. It's a mapper from MapStruct. Automatically maps DTOs. Extends from GenericDTOMapper, previously implemented.
 */
@Mapper(componentModel = "spring")
public interface ProfessorMapper extends GenericDTOMapper<ProfessorInputDto, Professor, ProfessorOutputDto> {
    // We'll work with this mapper in ProfessorServiceImpl
    // We could add some custom methods in here (related to mapping logic)
}

package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.inputDto.ProfessorInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.ProfessorOutputDto;
import com.bosonit.block7crudvalidation.domain.Professor;
import org.mapstruct.Mapper;

/**
 * Interface ProfessorMapper. It's a mapper from MapStruct. Automatically maps DTOs.
 */
@Mapper(componentModel = "spring")
public interface ProfessorMapper extends GenericDTOMapper<ProfessorInputDto, Professor, ProfessorOutputDto> {
    //Logic: ProfessorInputDto -> Professor -> ProfessorOutputDto
    //We'll work with this mapper in ProfessorServiceImpl.
}

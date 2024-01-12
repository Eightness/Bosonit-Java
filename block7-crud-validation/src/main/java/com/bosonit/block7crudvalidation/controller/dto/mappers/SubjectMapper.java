package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.GenericDTOMapper;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.SubjectInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.SubjectOutputDto;
import com.bosonit.block7crudvalidation.domain.Subject;
import org.mapstruct.Mapper;

/**
 * Interface SubjectMapper. It's a mapper from MapStruct. Automatically maps DTOs.
 */
@Mapper(componentModel = "spring")
public interface SubjectMapper extends GenericDTOMapper<SubjectInputDto, Subject, SubjectOutputDto> {
    //Logic: SubjectInputDto -> Subject -> SubjectOutputDto
    //We'll work with this mapper in SubjectServiceImpl.
}

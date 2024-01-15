package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.inputDto.StudentInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.StudentOutputDto;
import com.bosonit.block7crudvalidation.domain.Student;
import org.mapstruct.Mapper;

/**
 * Interface StudentMapper. It's a mapper from MapStruct. Automatically maps DTOs.
 */
@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericDTOMapper<StudentInputDto, Student, StudentOutputDto> {
    //Logic: StudentInputDto -> Student -> StudentOutputDto
    //We'll work with this mapper in StudentServiceImpl.
}

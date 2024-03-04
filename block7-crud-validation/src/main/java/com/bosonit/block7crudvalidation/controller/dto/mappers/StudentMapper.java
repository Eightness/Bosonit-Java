/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.inputDto.StudentInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.StudentOutputDto;
import com.bosonit.block7crudvalidation.domain.Student;
import org.mapstruct.Mapper;

/**
 * StudentMapper interface. It's a mapper from MapStruct. Automatically maps DTOs. Extends from GenericDTOMapper, previously implemented.
 */
@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericDTOMapper<StudentInputDto, Student, StudentOutputDto> {
    // We'll work with this mapper in StudentServiceImpl
    // We could add some custom methods in here (related to mapping logic)
}

/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.mappers;

import com.bosonit.block7crudvalidation.controller.dto.inputDto.SubjectInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.SubjectOutputDto;
import com.bosonit.block7crudvalidation.domain.Subject;
import org.mapstruct.Mapper;

/**
 * SubjectMapper interface . It's a mapper from MapStruct. Automatically maps DTOs. Extends from GenericDTOMapper, previously implemented.
 */
@Mapper(componentModel = "spring")
public interface SubjectMapper extends GenericDTOMapper<SubjectInputDto, Subject, SubjectOutputDto> {
    // We'll work with this mapper in SubjectServiceImpl
    // We could add some custom methods in here (related to mapping logic)
}

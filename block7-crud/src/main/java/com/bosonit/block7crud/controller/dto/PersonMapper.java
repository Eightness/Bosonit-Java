/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller.dto;

import com.bosonit.block7crud.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * PersonMapper interface. It's a mapper from MapStruct. Automatically maps DTOs.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    //Logic: PersonInputDto -> Person -> PersonOutputDto.
    //We'll work with this mapper in PersonServiceImpl.

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //Mapping PersonInputDto -> Person.
    @Mapping(target = "name", source = "inputName")
    @Mapping(target = "age", source = "inputAge")
    @Mapping(target = "town", source = "inputTown")
    Person toPerson(PersonInputDto personInputDto);

    //Mapping Person -> PersonOutputDto.
    @Mapping(target = "outputName", source = "name")
    @Mapping(target = "outputAge", source = "age")
    @Mapping(target = "outputTown", source = "town")
    PersonOutputDto toPersonOutputDto(Person person);

    //Mapping List<Person> -> List<PersonOutputDto>.
    List<PersonOutputDto> toPersonOutputDtoList(List<Person> personList);
}

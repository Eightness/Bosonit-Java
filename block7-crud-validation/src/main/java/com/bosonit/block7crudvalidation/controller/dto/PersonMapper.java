/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.controller.dto;

import com.bosonit.block7crudvalidation.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Interface PersonMapper. It's a mapper from MapStruct. Automatically maps DTOs.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    //Logic: PersonInputDto -> Person -> PersonOutputDto
    //We'll work with this mapper in PersonServiceImpl.

    //Singleton
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //Mapping PersonInputDto -> Person
    Person toPerson(PersonInputDto personInputDto);

    //Mapping Person -> PersonOutputDto
    PersonOutputDto toPersonOutputDto(Person person);

    //Mapping PersonOutputDto -> Person
    Person toPerson(PersonOutputDto personOutputDto);

    //Mapping List<PersonInputDto> -> List<Person>
    List<Person> toPersonList(List<PersonInputDto> personInputDtoList);

    //Mapping List<Person> -> List<PersonOutputDto>
    List<PersonOutputDto> toPersonOutputDtoList(List<Person> personList);
}

/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.controller.dto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.PersonOutputDto;

import java.util.List;

/**
 * Interface PersonService. Contains methods that define business' logic.
 */
public interface PersonService {
    //REMEMBER: Service layer gets and returns DTOs, not Person's instances. (Business).
    //Get methods.
    PersonOutputDto getPersonById(int id);
    List<PersonOutputDto> getPersonByName(String name);
    List<PersonOutputDto> getAllPersons(int pageNumber, int pageSize);
    //Post methods.
    PersonOutputDto addPerson(PersonInputDto personInputDto);
    List<PersonOutputDto> addPersons(List<PersonInputDto> personInputDtoList);
    //Put methods.
    PersonOutputDto updatePersonById(int id, PersonInputDto personInputDto);
    List<PersonOutputDto> updatePersonsByIds(List<Integer> ids, List<PersonInputDto> personInputDtoList);
    //Patch methods.
    PersonOutputDto modifyPersonById(int id, PersonInputDto personInputDto);
    List<PersonOutputDto> modifyPersonsByIds(List<Integer> ids, List<PersonInputDto> personInputDtoList);
    //Delete methods.
    void deletePersonById(int id);
    void deletePersonsById(List<Integer> ids);
}

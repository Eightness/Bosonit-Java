/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.application;

import com.bosonit.block7crud.controller.dto.PersonInputDto;
import com.bosonit.block7crud.controller.dto.PersonOutputDto;

import java.util.List;

/**
 * Interface PersonService. Contains methods that define business' logic.
 */
public interface PersonService {
    //REMEMBER: Service layer gets and returns DTOs, not Person's instances.
    PersonOutputDto addPerson(PersonInputDto person);
    PersonOutputDto updatePerson(int id, PersonInputDto person);
    void deletePersonById(int id);
    PersonOutputDto getPersonById(int id);
    List<PersonOutputDto> getPersonByName(String name);
    List<PersonOutputDto> getAllPersons(int pageNumber, int pageSize);
}

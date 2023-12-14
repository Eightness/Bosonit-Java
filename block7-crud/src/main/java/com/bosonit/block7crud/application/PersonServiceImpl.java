/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.application;

import com.bosonit.block7crud.controller.dto.PersonInputDto;
import com.bosonit.block7crud.controller.dto.PersonMapper;
import com.bosonit.block7crud.controller.dto.PersonOutputDto;
import com.bosonit.block7crud.domain.Person;
import com.bosonit.block7crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Class PersonServiceImpl. Implements PersonService interface. Applies all methods related to business' logic.
 */
public class PersonServiceImpl implements PersonService{
    //Dependencies injection.
    @Autowired
    PersonRepository personRepository;  //We'll have access to CRUD methods thanks to extending from JpaRepository in our personRepository interface.
    @Autowired
    PersonMapper personMapper;  //We'll map our DTOs here.

    //Override methods from PersonService.
    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        Person person = personMapper.toPerson(personInputDto);
        personRepository.save(person);
        return personMapper.toPersonOutputDto(person);
    }

    @Override
    public PersonOutputDto updatePerson(int id, PersonInputDto personInputDto) {
        //To do:
        // Control if a field is null.
        // Return 404 if there's not a person with the provided id.
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
        return personMapper.toPersonOutputDto(personRepository.save(personMapper.toPerson(personInputDto)));
    }

    @Override
    public void deletePersonById(int id) {
        //To do:
        // Return 404 if there's not a person with the provided id.
    }

    @Override
    public PersonOutputDto getPersonById(int id) {
        return personMapper.toPersonOutputDto(personRepository.findById(id).orElseThrow());
    }

    @Override
    public List<PersonOutputDto> getPersonByName(String name) {
        return null;
    }

    @Override
    public List<PersonOutputDto> getAllPersons(int pageNumber, int pageSize) {
        return null;
    }

}

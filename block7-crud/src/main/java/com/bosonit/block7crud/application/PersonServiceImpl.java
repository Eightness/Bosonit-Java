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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
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
        return personMapper.toPersonOutputDto(personRepository.save(new Person(personInputDto)));
    }

    @Override
    public PersonOutputDto updatePerson(int id, PersonInputDto personInputDto) {
        personRepository.findById(personInputDto.getId()).orElseThrow();
        return personMapper.toPersonOutputDto(personRepository.save(new Person(personInputDto)));   //Doubt.
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }

    @Override
    public PersonOutputDto getPersonById(int id) {
        return personMapper.toPersonOutputDto(personRepository.findById(id).orElseThrow());
    }

    @Override
    public List<PersonOutputDto> getPersonByName(String name) {
        List<Person> persons = personRepository.findByName(name);
        List<PersonOutputDto> personsOutputDto = new ArrayList<>();
        for (Person person : persons) {
            if (person != null) {
                personsOutputDto.add(personMapper.toPersonOutputDto(person));
            }
        }
        return personsOutputDto;
    }

    @Override
    public List<PersonOutputDto> getAllPersons(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Person> personPage = personRepository.findAll(pageRequest);
        return null; //Doubt.
    }

}

/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.PersonService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.PersonMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Class PersonServiceImpl. Implements PersonService interface and contains all methods related to Person's CRUD.
 */
public class PersonServiceImpl implements PersonService {
    //Attributes.
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    //Methods.
    @Override
    public PersonOutputDto getPersonById(int id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.domainToOutput(person);
    }

    @Override
    public List<PersonOutputDto> getPersonByName(String name) {
        List<Person> persons = personRepository.findByName(name);
        return personMapper.domainToOutput(persons);
    }

    @Override
    public List<PersonOutputDto> getAllPersons(int pageNumber, int pageSize) {
        List<Person> persons = personRepository.findAll();
        return personMapper.domainToOutput(persons);
    }

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        return null;
    }

    @Override
    public List<PersonOutputDto> addPersons(List<PersonInputDto> personInputDtoList) {
        return null;
    }

    @Override
    public PersonOutputDto updatePersonById(int id, PersonInputDto personInputDto) {
        return null;
    }

    @Override
    public List<PersonOutputDto> updatePersonsByIds(List<Integer> ids, List<PersonInputDto> personInputDtoList) {
        return null;
    }

    @Override
    public PersonOutputDto modifyPersonById(int id, PersonInputDto personInputDto) {
        return null;
    }

    @Override
    public List<PersonOutputDto> modifyPersonsByIds(List<Integer> ids, List<PersonInputDto> personInputDtoList) {
        return null;
    }

    @Override
    public void deletePersonById(int id) {

    }

    @Override
    public void deletePersonsById(List<Integer> ids) {

    }
}

/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
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
public class PersonServiceImpl implements GenericService<PersonInputDto, PersonOutputDto> {
    //Attributes.
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    //Methods.
    @Override
    public PersonOutputDto getEntityById(int id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.domainToOutput(person);
    }

    @Override
    public List<PersonOutputDto> getEntitiesByName(String name) {
        List<Person> persons = personRepository.findByName(name);
        return personMapper.domainToOutput(persons);
    }

    @Override
    public List<PersonOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Person> persons = personRepository.findAll();
        return personMapper.domainToOutput(persons);
    }

    @Override
    public PersonOutputDto addEntity(PersonInputDto inputEntity) {
        return null;
    }

    @Override
    public List<PersonOutputDto> addEntities(List<PersonInputDto> inputEntities) {
        return null;
    }

    @Override
    public PersonOutputDto updateEntityById(int id, PersonInputDto inputEntity) {
        return null;
    }

    @Override
    public List<PersonOutputDto> updateEntitiesByIds(List<Integer> ids, List<PersonInputDto> inputEntities) {
        return null;
    }

    @Override
    public PersonOutputDto modifyEntityById(int id, PersonInputDto inputEntity) {
        return null;
    }

    @Override
    public List<PersonOutputDto> modifyEntitiesByIds(List<Integer> ids, List<PersonInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(int id) {

    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {

    }
}

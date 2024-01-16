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
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class PersonServiceImpl. Implements PersonService interface and contains all methods related to Person's CRUD.
 */
@Service
public class PersonServiceImpl implements GenericService<PersonInputDto, PersonOutputDto> {
    //Attributes.
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

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
        Person person = personMapper.inputToDomain(inputEntity);
        person = personRepository.save(person);
        return personMapper.domainToOutput(person);
    }

    @Override
    public List<PersonOutputDto> addEntities(List<PersonInputDto> inputEntities) {
        List<Person> persons = personMapper.inputToDomain(inputEntities);
        persons = personRepository.saveAll(persons);
        return personMapper.domainToOutput(persons);
    }

    @Override
    public PersonOutputDto updateEntityById(int id, PersonInputDto inputEntity) {
        personRepository.findById(id).orElseThrow();
        Person updatedPerson = personMapper.inputToDomain(inputEntity);
        updatedPerson = personRepository.save(updatedPerson);
        return personMapper.domainToOutput(updatedPerson);
    }

    @Override
    public List<PersonOutputDto> updateEntitiesByIds(List<Integer> ids, List<PersonInputDto> inputEntities) {
        personRepository.findAllById(ids);
        List<Person> updatedPersons = personMapper.inputToDomain(inputEntities);
        updatedPersons = personRepository.saveAll(updatedPersons);
        return personMapper.domainToOutput(updatedPersons);
    }

    @Override
    public PersonOutputDto modifyEntityById(int id, PersonInputDto inputEntity) {
        personRepository.findById(id).orElseThrow();
        Person modifiedPerson = personMapper.inputToDomain(inputEntity);
        modifiedPerson = personRepository.save(modifiedPerson);
        return personMapper.domainToOutput(modifiedPerson);
    }

    @Override
    public List<PersonOutputDto> modifyEntitiesByIds(List<Integer> ids, List<PersonInputDto> inputEntities) {
        personRepository.findAllById(ids);
        List<Person> modifiedPersons = personMapper.inputToDomain(inputEntities);
        modifiedPersons = personRepository.saveAll(modifiedPersons);
        return personMapper.domainToOutput(modifiedPersons);
    }

    @Override
    public void deleteEntityById(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {
        personRepository.deleteAllById(ids);
    }

}

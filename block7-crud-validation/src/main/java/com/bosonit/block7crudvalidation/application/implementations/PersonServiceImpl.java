/**
 * @author Albert Lozano Blasco
 * @version 12.0
 */

package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.PersonMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.respository.PersonRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * PersonServiceImpl class. Implements PersonService interface and contains all methods related to Person's CRUD.
 */
@Service
public class PersonServiceImpl implements GenericService<PersonInputDto, PersonOutputDto, Long> {
    // Attributes
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    // Methods
    @Override
    public PersonOutputDto getEntityById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(EntityExistsException::new);
        return personMapper.domainToOutput(person);
    }

    @Override
    public List<PersonOutputDto> getEntitiesByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<PersonOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Person> allPersons = personRepository.findAll();
        return personMapper.domainToOutput(allPersons);
    }

    @Override
    public PersonOutputDto addEntity(PersonInputDto inputEntity) {
        Person person = personMapper.inputToDomain(inputEntity);
        personRepository.save(person);
        return personMapper.domainToOutput(person);
    }

    @Override
    public List<PersonOutputDto> addEntities(List<PersonInputDto> inputEntities) {
        return null;
    }

    @Override
    public PersonOutputDto updateEntityById(Long id, PersonInputDto inputEntity) {
        Person person = personRepository.findById(id).orElseThrow();
        Person updatedPerson = personMapper.inputToDomain(inputEntity);

        person.setLogin(updatedPerson.getLogin());
        person.setPassword(updatedPerson.getPassword());
        person.setName(updatedPerson.getName());
        person.setSurname(updatedPerson.getSurname());
        person.setCompanyEmail(updatedPerson.getCompanyEmail());
        person.setPersonalEmail(updatedPerson.getPersonalEmail());
        person.setCity(updatedPerson.getCity());
        person.setActive(updatedPerson.getActive());
        person.setCreatedDate(updatedPerson.getCreatedDate());
        person.setImageUrl(updatedPerson.getImageUrl());
        person.setTerminationDate(updatedPerson.getTerminationDate());

        personRepository.save(person);
        return personMapper.domainToOutput(person);
    }

    @Override
    public List<PersonOutputDto> updateEntitiesByIds(List<Long> ids, List<PersonInputDto> inputEntities) {
        return null;
    }

    @Override
    public PersonOutputDto modifyEntityById(Long id, PersonInputDto inputEntity) {
        Person person = personRepository.findById(id).orElseThrow();
        Person updatedPerson = personMapper.inputToDomain(inputEntity);

        person.setLogin(updatedPerson.getLogin());
        person.setPassword(updatedPerson.getPassword());
        person.setName(updatedPerson.getName());
        person.setSurname(updatedPerson.getSurname());
        person.setCompanyEmail(updatedPerson.getCompanyEmail());
        person.setPersonalEmail(updatedPerson.getPersonalEmail());
        person.setCity(updatedPerson.getCity());
        person.setActive(updatedPerson.getActive());
        person.setCreatedDate(updatedPerson.getCreatedDate());
        person.setImageUrl(updatedPerson.getImageUrl());
        person.setTerminationDate(updatedPerson.getTerminationDate());

        personRepository.save(person);
        return personMapper.domainToOutput(person);
    }

    @Override
    public List<PersonOutputDto> modifyEntitiesByIds(List<Long> ids, List<PersonInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Long> ids) {

    }

    @Override
    public void deleteAllEntities() {
        personRepository.deleteAll();
    }

    // Criteria API methods (using CriteriaBuilder)
    /**
     * getCustomPerson method. Allows listing those persons that matches user's conditions using CriteriaBuilder.
     * @param conditions (HashMap<String, Object>) Conditions set by the user.
     */
    public List<PersonOutputDto> getCustomPersons(HashMap<String, Object> conditions) {
        return personRepository.getCustomPersons(conditions);
    }

    // Security methods (using Spring Security)

}

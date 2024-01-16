package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class PersonController. RestController to manage all HTTP methods for a Person.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    //Attributes.
    @Autowired
    private GenericService<PersonInputDto, PersonOutputDto> personService;

    //Methods.

    //Get methods.
    @GetMapping("/getAll")
    public ResponseEntity<List<PersonOutputDto>> getAllPersons() {
        List<PersonOutputDto> persons = personService.getAllEntities(0, 10);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/getPersonById")
    public ResponseEntity<PersonOutputDto> getPersonById(@RequestParam int id) {
        PersonOutputDto person = personService.getEntityById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/getPersonByUser")
    public ResponseEntity<PersonOutputDto> getPersonByUser(@RequestParam String user) {
        List<PersonOutputDto> persons = personService.getEntitiesByName(user);
        if (!persons.isEmpty()) {
            return new ResponseEntity<>(persons.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Post methods.
    @PostMapping("/postPerson")
    public ResponseEntity<PersonOutputDto> postPerson(@RequestBody PersonInputDto personInputDto) {
        PersonOutputDto createdPerson = personService.addEntity(personInputDto);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PostMapping("/postPersons")
    public ResponseEntity<List<PersonOutputDto>> postPersons(@RequestBody List<PersonInputDto> personInputDtoList) {
        List<PersonOutputDto> createdPersons = personService.addEntities(personInputDtoList);
        return new ResponseEntity<>(createdPersons, HttpStatus.CREATED);
    }

    //Put methods.
    @PutMapping("/putPersonById")
    public ResponseEntity<PersonOutputDto> putPersonById(@RequestParam int id, @RequestBody PersonInputDto personInputDto) {
        PersonOutputDto updatedPerson = personService.updateEntityById(id, personInputDto);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @PutMapping("/putPersonsByIds")
    public ResponseEntity<List<PersonOutputDto>> putPersonsByIds(@RequestBody List<Integer> ids) {
        List<PersonOutputDto> updatedPersons = personService.updateEntitiesByIds(ids, null);
        return new ResponseEntity<>(updatedPersons, HttpStatus.OK);
    }

    //Patch methods.
    @PatchMapping("/patchPersonById")
    public ResponseEntity<PersonOutputDto> patchPersonById(@RequestParam int id, @RequestBody PersonInputDto personInputDto) {
        PersonOutputDto modifiedPerson = personService.modifyEntityById(id, personInputDto);
        return new ResponseEntity<>(modifiedPerson, HttpStatus.OK);
    }

    @PatchMapping("/patchPersonsByIds")
    public ResponseEntity<List<PersonOutputDto>> patchPersonsByIds(@RequestBody List<Integer> ids) {
        List<PersonOutputDto> modifiedPersons = personService.modifyEntitiesByIds(ids, null);
        return new ResponseEntity<>(modifiedPersons, HttpStatus.OK);
    }

    //Delete methods.
    @DeleteMapping("/deletePersonById")
    public ResponseEntity<Void> deletePersonById(@RequestParam int id) {
        personService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deletePersonsByIds")
    public ResponseEntity<Void> deletePersonsByIds(@RequestBody List<Integer> ids) {
        personService.deleteEntitiesByIds(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

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
 * PersonController class. RestController to manage all HTTP methods for a Person.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    // Attributes
    @Autowired
    private GenericService<PersonInputDto, PersonOutputDto, Long> personService;

    // CRUD Methods
    // Create methods
    @PostMapping("/post")
    public ResponseEntity<PersonOutputDto> postPerson(@RequestBody PersonInputDto personInputDto) {
        PersonOutputDto createdPerson = personService.addEntity(personInputDto);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    // Read methods
    @GetMapping("/get/all")
    public ResponseEntity<List<PersonOutputDto>> getAllPersons() {
        List<PersonOutputDto> persons = personService.getAllEntities(0, 10);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<PersonOutputDto> getPersonById(@RequestParam long id) {
        PersonOutputDto person = personService.getEntityById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // Update methods
    @PutMapping("/put")
    public ResponseEntity<PersonOutputDto> putPersonById(@RequestParam long id, @RequestBody PersonInputDto personInputDto) {
        PersonOutputDto updatedPerson = personService.updateEntityById(id, personInputDto);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity<PersonOutputDto> patchPersonById(@RequestParam long id, @RequestBody PersonInputDto personInputDto) {
        PersonOutputDto modifiedPerson = personService.modifyEntityById(id, personInputDto);
        return new ResponseEntity<>(modifiedPerson, HttpStatus.OK);
    }

    // Delete methods
    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllPersons() {
        personService.deleteAllEntities();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePersonById(@RequestParam long id) {
        personService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

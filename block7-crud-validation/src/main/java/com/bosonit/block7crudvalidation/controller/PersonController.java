/**
 * @author Albert Lozano Blasco
 * @version 12.0
 */

package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.implementations.PersonServiceImpl;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * PersonController class. RestController to manage all HTTP methods for a Person.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    // Attributes
    @Autowired
    private PersonServiceImpl personService;

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

    // Criteria API methods (using CriteriaBuilder)
    @GetMapping("/get/custom")
    public ResponseEntity<List<PersonOutputDto>> getCustomPersons (
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) boolean newer,
            @RequestParam(required = false) boolean orderedBy,
            @RequestParam int pageNumber,
            @RequestParam(required = false) int pageSize
    ) {
        HashMap<String, Object> conditions = new HashMap<>();

        // Adding parameters info to our map "conditions"
        // Plus checking if the parameters are empty or not:
        if (login != null) {
            conditions.put("login", login);
        }
        if (name != null) {
            conditions.put("name", name);
        }
        if (surname != null) {
            conditions.put("surname", name);
        }
        if (date != null) {
            conditions.put("createdDate", date);
        }
        if (pageSize == 0) {
            conditions.put("pageSize", 10);
        } else {
            conditions.put("pageSize", pageSize);
        }
        conditions.put("newer", newer);
        conditions.put("orderedBy", orderedBy);

        List<PersonOutputDto> results = personService.getCustomPersons(conditions);
        return new ResponseEntity<>(results, HttpStatus.OK);
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

/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.PersonService;
import com.bosonit.block7crudvalidation.controller.dto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.PersonMapper;
import com.bosonit.block7crudvalidation.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class TestController. RestController to manage all HTTP methods.
 */
@RestController
@RequestMapping("/person")
public class TestController {
    //Attributes.
    @Autowired
    private PersonService personService;

    //Methods.

    //Get methods.
    @GetMapping("/getAll")
    public ResponseEntity<List<PersonOutputDto>> getAllPersons() {
        return null;
    }

    @GetMapping("/getPersonById")
    public ResponseEntity<PersonOutputDto> getPersonById(int id) {
        return null;
    }

    @GetMapping("/getPersonByUser")
    public ResponseEntity<PersonOutputDto> getPersonByUser(String user) {
        return null;
    }

    //Post methods.
    @PostMapping("/postPerson")
    public ResponseEntity<PersonOutputDto> postPerson(PersonInputDto personInputDto) {
        return null;
    }

    @PostMapping("/postPersons")
    public ResponseEntity<List<PersonOutputDto>> postPersons(List<PersonInputDto> personInputDtoList) {
        return null;
    }

    //Put methods.
    @PutMapping("/putPersonById")
    public ResponseEntity<PersonOutputDto> putPersonById(int id, PersonInputDto personInputDto) {
        return null;
    }

    @PutMapping("/putPersonsByIds")
    public ResponseEntity<PersonOutputDto> putPersonsByIds(List<Integer> ids) {
        return null;
    }

    //Patch methods.
    @PatchMapping("/patchPersonById")
    public ResponseEntity<PersonOutputDto> patchPersonById(PersonInputDto personInputDto) {
        return null;
    }

    @PatchMapping("/putPersonsByIds")
    public ResponseEntity<PersonOutputDto> patchPersonsByIds(List<Integer> ids) {
        return null;
    }

    //Deletes methods.
    @DeleteMapping("/deletePersonById")
    public ResponseEntity<PersonOutputDto> deletePersonById(int id) {
        return null;
    }

    @DeleteMapping("/deletePersonsByIds")
    public ResponseEntity<PersonOutputDto> deletePersonsByIds(List<Integer> ids) {
        return null;
    }
}

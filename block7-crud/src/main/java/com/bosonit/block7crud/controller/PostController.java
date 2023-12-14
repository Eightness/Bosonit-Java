/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller;

import com.bosonit.block7crud.application.PersonService;
import com.bosonit.block7crud.controller.dto.PersonInputDto;
import com.bosonit.block7crud.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class PostController. Controller that will manage all post requests in our app.
 */
@RestController
@RequestMapping("/person")
public class PostController {
    //Dependencies injection.
    @Autowired
    private PersonService personService;

    //Methods.
    /**
     * Method addPerson. Will create a new person that we'll obtain through the body.
     * @param person new person via user's input.
     * @return ResponseEntity<PersonOutputDto>
     */
    @PostMapping("/add")
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(person));
    }
}

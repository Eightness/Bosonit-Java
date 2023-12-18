/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller;

import com.bosonit.block7crud.application.PersonService;
import com.bosonit.block7crud.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class DeleteController. Controller that will manage all delete requests.
 */
@RestController
@RequestMapping("/person")
public class DeleteController {
    //Dependencies Injection.
    @Autowired
    private PersonService personService;

    //Methods

    /**
     * Method deletePersonById. Will delete a user with an id provided by the user.
     * @param id person's id to delete.
     * @return a message confirming the action.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable int id) {
        try {
            personService.deletePersonById(id);
            return ResponseEntity.ok().body("Person with id: " + id + " was deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

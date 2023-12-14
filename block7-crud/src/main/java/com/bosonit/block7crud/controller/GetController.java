/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller;

import com.bosonit.block7crud.application.PersonService;
import com.bosonit.block7crud.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class GetController. Controller that will manage all get requests.
 */
@RestController
@RequestMapping("/person")
public class GetController {
    //Dependencies injection.
    @Autowired
    private PersonService personService;

    //Methods.
    /**
     * Method getPersonById. Will get a person by a determined id introduced by the user.
     * @param id inserted by the user via the url.
     * @return ResponseEntity<PersonOutputDto>
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //To do: getPersonByName(String name) and getAllPersons().
}

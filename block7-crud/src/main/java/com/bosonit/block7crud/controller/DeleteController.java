/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller;

import com.bosonit.block7crud.application.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class DeleteController {
    //Dependencies Injection.
    @Autowired
    private PersonService personService;

    //Methods

    //To do: deletePersonById(int id).
}

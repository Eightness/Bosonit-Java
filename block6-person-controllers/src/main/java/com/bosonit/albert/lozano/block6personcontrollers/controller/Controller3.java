/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.controller;

import com.bosonit.albert.lozano.block6personcontrollers.exceptions.NotCreatedPersonException;
import com.bosonit.albert.lozano.block6personcontrollers.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class Controller3. Third and final controller. Will get a determined person by qualifiers.
 */
@RestController //Indicates that this class' methods will be receiving RESTful requests.
@RequestMapping("/controller3/bean") //Defining class level route.
public class Controller3 {
    //Attributes.
    @Autowired
    @Qualifier("Albert")
    private Person bean1;

    @Autowired
    @Qualifier("Thomas")
    private Person bean2;

    @Autowired
    @Qualifier("Sergi")
    private Person bean3;

    /**
     * Method getDeterminedBean. Get request.
     * @return a determined person's object.
     */
    public Person getBean(@PathVariable String bean) {
        return switch (bean) {
            case "bean1" -> bean1;
            case "bean2" -> bean2;
            case "bean3" -> bean3;
            default -> throw new NotCreatedPersonException("Bean doesn't exist or it's not accessible.");
        };
    }

    //Adding an exception handler for NotCreatedPersonException.
    @ExceptionHandler(NotCreatedPersonException.class)
    public ResponseEntity<String> handleNotCreatedPersonException(NotCreatedPersonException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}

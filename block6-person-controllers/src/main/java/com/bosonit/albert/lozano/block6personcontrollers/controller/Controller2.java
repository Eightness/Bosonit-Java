/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.controller;

import com.bosonit.albert.lozano.block6personcontrollers.exceptions.NotCreatedPersonException;
import com.bosonit.albert.lozano.block6personcontrollers.model.City;
import com.bosonit.albert.lozano.block6personcontrollers.service.CityService;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Class Controller2. Second controller. Will manage object Person.
 */
@RestController //Indicates that this class' methods will be receiving RESTful requests.
@RequestMapping("/controller2") //Defining class level route.
public class Controller2 {
    //Attributes.
    private final PersonService personService;
    private final CityService cityService;

    @Autowired  //Dependencies injection.
    public Controller2(PersonService personService, CityService cityService) {
        this.personService = personService;
        this.cityService = cityService;
    }

    /**
     * Method getPerson. Get request.
     * @return the previously added person.
     */
    @GetMapping("/getPerson")
    public ResponseEntity<?> getPerson() {
        try {
            return ResponseEntity.ok(personService.getPerson());
        } catch (NotCreatedPersonException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Method getCities. Get request.
     * @return current existing cities.
     */
    @GetMapping("/getCities")
    public List<City> getCities() {
        return cityService.getCities();
    }

    //Adding an exception handler.
    @ExceptionHandler(NotCreatedPersonException.class)
    public ResponseEntity<String> handleNotCreatedPersonException(NotCreatedPersonException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

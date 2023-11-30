/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.controller;

import com.bosonit.albert.lozano.block6personcontrollers.exceptions.EmptyCityListException;
import com.bosonit.albert.lozano.block6personcontrollers.exceptions.NotCreatedPersonException;
import com.bosonit.albert.lozano.block6personcontrollers.model.City;
import com.bosonit.albert.lozano.block6personcontrollers.model.Person;
import com.bosonit.albert.lozano.block6personcontrollers.service.CityServiceInterface;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import
org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class Controller2. Second controller. Will manage object Person.
 */
@RestController //Indicates that this class' methods will be receiving RESTful requests.
@RequestMapping("/controller2") //Defining class level route.
public class Controller2 {
    //Attributes.
    @Autowired  //Dependencies injection.
    private final PersonServiceInterface personServiceInterface;
    private final CityServiceInterface cityServiceInterface;

    @Autowired  //Dependencies injection.
    public Controller2(
            PersonServiceInterface personServiceInterface,
            CityServiceInterface cityServiceInterface
    ) {
        this.personServiceInterface = personServiceInterface;
        this.cityServiceInterface = cityServiceInterface;
    }
    /**
     * Method getPerson. Get request.
     * @return the previously added person.
     */
    @GetMapping("/getPerson")
    public Person getPerson() {
        return personServiceInterface.getPerson();
    }

    /**
     * Method getCities. Get request.
     * @return current existing cities.
     */
    @GetMapping("/getCities")
    public List<City> getCities() {
        return cityServiceInterface.getCities();
    }

    //Adding an exception handler for EmptyCityListException.
    @ExceptionHandler(EmptyCityListException.class)
    public ResponseEntity<String> handleEmptyCityListException(EmptyCityListException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //Adding an exception handler for NotCreatedPersonException.
    @ExceptionHandler(NotCreatedPersonException.class)
    public ResponseEntity<String> handleNotCreatedPersonException(NotCreatedPersonException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

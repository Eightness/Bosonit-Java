/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.controller;

import com.bosonit.albert.lozano.block6personcontrollers.exceptions.InvalidCityException;
import com.bosonit.albert.lozano.block6personcontrollers.exceptions.InvalidVariablesException;
import com.bosonit.albert.lozano.block6personcontrollers.model.City;
import com.bosonit.albert.lozano.block6personcontrollers.model.Person;
import com.bosonit.albert.lozano.block6personcontrollers.service.CityServiceInterface;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class Controller1. First controller. Will manage person addition.
 */
@RestController //Indicates that this class' methods will be receiving RESTful requests.
@RequestMapping("/controller1") //Defining class' level route.
public class Controller1 {
    //Attributes.
    @Autowired  //Dependencies injection.
    private final PersonServiceInterface personServiceInterface;
    private final CityServiceInterface cityServiceInterface;

    @Autowired  //Dependencies injection.
    public Controller1(
        PersonServiceInterface personServiceInterface,
        CityServiceInterface cityServiceInterface
    ) {
        this.personServiceInterface = personServiceInterface;
        this.cityServiceInterface = cityServiceInterface;
    }

    /**
     * Method addPerson. Get request.
     * @param name new person's name.
     * @param town new person's origin town.
     * @param age new person's current age.
     * @return new object Person.
     */
    @GetMapping("/addPerson/name/{name}/town/{town}/age/{age}")
    public Person addPerson(
            @PathVariable(name = "name") String name,
            @PathVariable(name = "town") String town,
            @PathVariable(name = "age") int age) {
        return personServiceInterface.createPerson(name, town, age);
    }

    /**
     * Method addCity. Post request. Adds a city
     * @param city requested city in http body.
     */
    @PostMapping("/addCity")
    public void addCity(@RequestBody City city) {
        cityServiceInterface.addCity(city);
    }

    //Adding an exception handler for InvalidCityException.
    @ExceptionHandler(InvalidCityException.class)
    public ResponseEntity<String> handleInvalidCityException(InvalidCityException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //Adding an exception handler for InvalidHeadersException.
    @ExceptionHandler(InvalidVariablesException.class)
    public ResponseEntity<String> handleInvalidHeaderException(InvalidVariablesException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

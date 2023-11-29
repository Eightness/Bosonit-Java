/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.controller;

import com.bosonit.albert.lozano.block6personcontrollers.model.Person;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class Controller1. First controller. Will manage person addition.
 */
@RestController //Indicates that this class' methods will be receiving RESTful requests.
@RequestMapping("/controller1") //Defining class' level route.
public class Controller1 {

    //Instance of PersonService.
    private final PersonService personService;

    @Autowired  //Dependencies injection.
    public Controller1(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Method addPerson. Get request.
     * @param name new person's name.
     * @param town new person's origin town.
     * @param age new person's current age.
     * @return new object Person.
     */
    @GetMapping("/addPerson")
    public Person addPerson(
            @RequestHeader String name,
            @RequestHeader String town,
            @RequestHeader int age) {
        return personService.createPerson(name, town, age); //Calling PersonService's createPerson method to return a Person.
    }

    /**
     * Method addCity. Post request.
     */
    @PostMapping("/addCity")
    public void addCity() {
        //Add a city to the list of cities.
    }
}

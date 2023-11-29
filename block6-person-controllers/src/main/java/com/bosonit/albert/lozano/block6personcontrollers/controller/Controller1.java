/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.controller;

import com.bosonit.albert.lozano.block6personcontrollers.model.City;
import com.bosonit.albert.lozano.block6personcontrollers.model.Person;
import com.bosonit.albert.lozano.block6personcontrollers.service.CityServiceInterface;
import com.bosonit.albert.lozano.block6personcontrollers.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class Controller1. First controller. Will manage person addition.
 */
@RestController //Indicates that this class' methods will be receiving RESTful requests.
@RequestMapping("/controller1") //Defining class' level route.
public class Controller1 {
    //Attributes.
    @Autowired  //Dependencies injection.
    private PersonServiceInterface personServiceInterface;
    private CityServiceInterface cityServiceInterface;

    /**
     * Method addPerson. Get request.
     * @param name new person's name.
     * @param town new person's origin town.
     * @param age new person's current age.
     * @return new object Person.
     */
    @GetMapping("/addPerson/{name}/town/{town}/age/{age}")
    public Person addPerson(
            @PathVariable(name = "name") String name,
            @PathVariable(name = "town") String town,
            @PathVariable(name = "age") int age) {
        return personServiceInterface.createPerson(name, town, age); //Calling PersonService's createPerson method to return a Person.
    }

    /**
     * Method addCity. Post request. Adds a city
     * @param city requested city in http body.
     */
    @PostMapping("/addCity")
    public void addCity(@RequestBody City city) {
        cityServiceInterface.addCity(city);
    }
}

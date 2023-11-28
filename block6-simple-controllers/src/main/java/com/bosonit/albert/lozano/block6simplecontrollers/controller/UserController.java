/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6simplecontrollers.controller;

import com.bosonit.albert.lozano.block6simplecontrollers.model.Person;
import org.springframework.web.bind.annotation.*;

/**
 * Class UserController. This class has a get method and a post method.
 */
@RestController //Similar to @Controller, this annotation indicates that this class' methods will be receiving RESTful requests.
@RequestMapping("/user")    //This annotation defines the class' level route. Helping to group different endpoints under a single URL.
public class UserController {

    @GetMapping("/{name}")  //This annotation is for GET requests.
    public String greeting(@PathVariable String name) { //@PathVariable is used to extract the requested URL values and to map them.
        return "Hola " + name;
    }

    @PostMapping("/useradd")    //This annotation is for POST requests.
    public Person addUser(@RequestBody Person person) { //@RequestBody to indicate that this method expects to convert the requested body into an object (person).
        person.setAge(person.getAge() + 1); //Setting person's age to +1.
        return person;
    }
}

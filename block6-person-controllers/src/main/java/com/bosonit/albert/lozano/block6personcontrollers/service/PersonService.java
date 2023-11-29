/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.service;

import com.bosonit.albert.lozano.block6personcontrollers.exceptions.NotCreatedPersonException;
import com.bosonit.albert.lozano.block6personcontrollers.model.Person;
import org.springframework.stereotype.Service;

/**
 * Class PersonService. Serves to create a Person.
 */
@Service    //Define this class as a service. Business logic.
public class PersonService implements PersonServiceInterface{
    //Attributes.
    private Person person;


    /**
     * Method createPerson.
     * @param name person's name.
     * @param town origin town.
     * @param age current person's age.
     * @return a new object Person.
     */
    @Override
    public Person createPerson(String name, String town, int age) {
        this.person = new Person(name, town, age);
        return this.person;
    }

    @Override
    public Person getPerson() {
        //Verifies if person is created before returning.
        if (person == null) {
            throw new NotCreatedPersonException("There's no created person yet.");
        }

        //Multiplies by 2.
        person.setAge(person.getAge() * 2);

        return person;
    }
}

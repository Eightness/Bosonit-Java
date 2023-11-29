/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.service;

import com.bosonit.albert.lozano.block6personcontrollers.model.Person;

/**
 * Interface PersonServiceInterface. Contracts methods with determined classes.
 */
public interface PersonServiceInterface {
    Person createPerson(String name, String town, int age);
    Person getPerson();
}
/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface PersonRepository. Extends from JpaRepository and contains all methods related to Person's persistence.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Person, Integer>
        Person -> Defines entity to persist.
        Integer -> Defines entity's primary key type.
     */

    //Custom methods.
    List<Person> findByName(String name);
}

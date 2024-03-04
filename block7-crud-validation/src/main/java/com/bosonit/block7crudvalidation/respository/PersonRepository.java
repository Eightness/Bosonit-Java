/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * PersonRepository interface . Extends from JpaRepository and contains all methods related to Person's persistence.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Person, Long>
        Person -> Defines entity to persist.
        Long -> Defines entity's primary key type.
     */

    // Custom methods
    List<Person> findByName(String name);
}

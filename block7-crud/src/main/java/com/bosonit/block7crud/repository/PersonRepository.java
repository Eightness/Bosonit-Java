/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.repository;

import com.bosonit.block7crud.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class PersonRepository. Defines all methods related to Person's persistence.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    "<Person, Integer>"
        Person -> Defines object's type to persist.
        Integer -> Defines object's PK type.
     */
}

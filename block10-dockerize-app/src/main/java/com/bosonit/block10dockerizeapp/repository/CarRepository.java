/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.repository;

import com.bosonit.block10dockerizeapp.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CarRepository interface. Extends from JpaRepository and contains all methods related to Car's persistence.
 */
public interface CarRepository extends JpaRepository<Car, Long> {
    // Thanks to extending from JpaRepository, we can persist and read data:
    // Access to CRUD and query methods
    // Car -> Defines entity to persist
    // Long -> Defines entity's primary key type

    // We can implement custom methods here (click on JpaRepository to read and study Jpa already implemented methods)
}

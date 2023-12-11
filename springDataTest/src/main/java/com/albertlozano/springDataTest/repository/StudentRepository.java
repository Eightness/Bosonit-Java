/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.springDataTest.repository;

import com.albertlozano.springDataTest.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface StudentRepository. Defines all methods related to Students' persistence.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Extending from JpaRepository.
    //Thanks to this interface that extends JpaRepository, we have all we need right here to persist and read data.
    // First parameter indicates the object to map type.
    // Second parameter indicates PK type. (We'll be using Integer class (wrapped int) because it won't allow primitive types).
}

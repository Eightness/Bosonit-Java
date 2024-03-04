/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StudentRepository interface . Extends from JpaRepository and contains all methods related to Student's persistence.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Student, Long>
        Student -> Defines entity to persist.
        Long -> Defines entity's primary key type.
     */

    // Custom methods
}

/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProfessorRepository interface . Extends from JpaRepository and contains all methods related to Professor's persistence.
 */
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Professor, Long>
        Professor -> Defines entity to persist.
        Long -> Defines entity's primary key type.
     */

    // Custom methods
}

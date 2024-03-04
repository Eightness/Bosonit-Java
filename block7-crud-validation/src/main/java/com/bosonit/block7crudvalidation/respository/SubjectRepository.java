/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SubjectRepository interface . Extends from JpaRepository and contains all methods related to Subject's persistence.
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Subject, Long>
        Subject -> Defines entity to persist.
        Long -> Defines entity's primary key type.
     */

    // Custom methods
}

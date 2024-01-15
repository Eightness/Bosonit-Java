package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Subject, String>
        Subject -> Defines entity to persist.
        String -> Defines entity's primary key type.
     */

    //Custom methods.
}

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Subject, String>
        Subject -> Defines entity to persist.
        String -> Defines entity's primary key type.
     */

    //Custom methods.
}

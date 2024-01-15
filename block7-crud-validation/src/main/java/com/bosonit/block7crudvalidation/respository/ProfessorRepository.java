package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Professor, String>
        Professor -> Defines entity to persist.
        String -> Defines entity's primary key type.
     */

    //Custom methods.
}

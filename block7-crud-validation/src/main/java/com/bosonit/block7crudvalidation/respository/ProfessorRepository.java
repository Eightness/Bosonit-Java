package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Professor, String>
        Professor -> Defines entity to persist.
        String -> Defines entity's primary key type.
     */

    //Custom methods.
}

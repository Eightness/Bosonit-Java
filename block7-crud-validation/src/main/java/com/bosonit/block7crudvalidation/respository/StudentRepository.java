package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Student, String>
        Student -> Defines entity to persist.
        String -> Defines entity's primary key type.
     */

    //Custom methods.
}

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <Student, String>
        Student -> Defines entity to persist.
        String -> Defines entity's primary key type.
     */

    //Custom methods.
    List<Student> findByName(String name);
}

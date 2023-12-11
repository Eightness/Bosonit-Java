/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.springDataTest.application;

import com.albertlozano.springDataTest.controller.dto.StudentInputDto;
import com.albertlozano.springDataTest.controller.dto.StudentOutputDto;
import com.albertlozano.springDataTest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Class StudentServiceImpl. Implements StudentService Interface. Applies all methods related to business' logic.
 */
public class StudentServiceImpl implements StudentService { //Implements StudentService Interface, so we'll be applying the contracted methods.
    //Dependencies injection.
    @Autowired
    StudentRepository studentRepository;

    //Override methods from StudentService Interface.
    // We'll have access to CRUD methods thanks to extending from JpaRepository in our studentRepository interface.
    @Override
    public StudentOutputDto addStudent(StudentInputDto student) {
        return null;
    }

    @Override
    public StudentOutputDto getStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public List<StudentOutputDto> getAllStudents(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public StudentOutputDto updateStudent(StudentInputDto student) {
        return null;
    }
}

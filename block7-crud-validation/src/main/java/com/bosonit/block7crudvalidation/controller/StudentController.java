/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.StudentInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * StudentController class. RestController to manage all HTTP methods for a Student.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    // Attributes
    @Autowired
    private GenericService<StudentInputDto, StudentOutputDto, Long> studentService;

    // CRUD Methods
    // Create methods
    @PostMapping("/post")
    public ResponseEntity<StudentOutputDto> postStudent(@RequestBody StudentInputDto studentInputDto) {
        StudentOutputDto createdStudent = studentService.addEntity(studentInputDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // Read methods
    @GetMapping("/get/all")
    public ResponseEntity<List<StudentOutputDto>> getAllStudents() {
        List<StudentOutputDto> students = studentService.getAllEntities(0, 10);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<StudentOutputDto> getStudentById(@RequestParam long id) {
        StudentOutputDto student = studentService.getEntityById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Update methods
    @PutMapping("/put")
    public ResponseEntity<StudentOutputDto> putStudentById(@RequestParam long id, @RequestBody StudentInputDto studentInputDto) {
        StudentOutputDto updatedStudent = studentService.updateEntityById(id, studentInputDto);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity<StudentOutputDto> patchStudentById(@RequestParam long id, @RequestBody StudentInputDto studentInputDto) {
        StudentOutputDto modifiedStudent = studentService.modifyEntityById(id, studentInputDto);
        return new ResponseEntity<>(modifiedStudent, HttpStatus.OK);
    }

    // Delete methods
    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllStudents() {
        studentService.deleteAllEntities();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteStudentById(@RequestParam long id) {
        studentService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

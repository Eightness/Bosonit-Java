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
 * Class StudentController. RestController to manage all HTTP methods for a Student.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    //Attributes.
    @Autowired
    private GenericService<StudentInputDto, StudentOutputDto> studentService;

    //Methods.

    //Get methods.
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentOutputDto>> getAllStudents() {
        List<StudentOutputDto> students = studentService.getAllEntities(0, 10);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/getStudentById")
    public ResponseEntity<StudentOutputDto> getStudentById(@RequestParam int id) {
        StudentOutputDto student = studentService.getEntityById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/getStudentByUser")
    public ResponseEntity<StudentOutputDto> getStudentByUser(@RequestParam String user) {
        List<StudentOutputDto> students = studentService.getEntitiesByName(user);
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Post methods.
    @PostMapping("/postStudent")
    public ResponseEntity<StudentOutputDto> postStudent(@RequestBody StudentInputDto studentInputDto) {
        StudentOutputDto createdStudent = studentService.addEntity(studentInputDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PostMapping("/postStudents")
    public ResponseEntity<List<StudentOutputDto>> postStudents(@RequestBody List<StudentInputDto> studentInputDtoList) {
        List<StudentOutputDto> createdStudents = studentService.addEntities(studentInputDtoList);
        return new ResponseEntity<>(createdStudents, HttpStatus.CREATED);
    }

    //Put methods.
    @PutMapping("/putStudentById")
    public ResponseEntity<StudentOutputDto> putStudentById(@RequestParam int id, @RequestBody StudentInputDto studentInputDto) {
        StudentOutputDto updatedStudent = studentService.updateEntityById(id, studentInputDto);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @PutMapping("/putStudentsByIds")
    public ResponseEntity<List<StudentOutputDto>> putStudentsByIds(@RequestBody List<Integer> ids) {
        List<StudentOutputDto> updatedStudents = studentService.updateEntitiesByIds(ids, null);
        return new ResponseEntity<>(updatedStudents, HttpStatus.OK);
    }

    //Patch methods.
    @PatchMapping("/patchStudentById")
    public ResponseEntity<StudentOutputDto> patchStudentById(@RequestParam int id, @RequestBody StudentInputDto studentInputDto) {
        StudentOutputDto modifiedStudent = studentService.modifyEntityById(id, studentInputDto);
        return new ResponseEntity<>(modifiedStudent, HttpStatus.OK);
    }

    @PatchMapping("/patchStudentsByIds")
    public ResponseEntity<List<StudentOutputDto>> patchStudentsByIds(@RequestBody List<Integer> ids) {
        List<StudentOutputDto> modifiedStudents = studentService.modifyEntitiesByIds(ids, null);
        return new ResponseEntity<>(modifiedStudents, HttpStatus.OK);
    }

    //Delete methods.
    @DeleteMapping("/deleteStudentById")
    public ResponseEntity<Void> deleteStudentById(@RequestParam int id) {
        studentService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteStudentsByIds")
    public ResponseEntity<Void> deleteStudentsByIds(@RequestBody List<Integer> ids) {
        studentService.deleteEntitiesByIds(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

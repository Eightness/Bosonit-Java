/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.springDataTest.controller;

import com.albertlozano.springDataTest.application.StudentServiceImpl;
import com.albertlozano.springDataTest.controller.dto.StudentInputDto;
import com.albertlozano.springDataTest.controller.dto.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class Controller. REST Controller. Will manage HTTP methods.
 */
@RestController //Indicates that this class is indeed a REST Controller.
@RequestMapping("/student") //Grouping all http methods into /student url.
public class Controller {
    //Dependencies injection.
    @Autowired
    StudentServiceImpl studentService;

    //CRUD Methods.
    // Majority of them will be returning a ResponseEntity<>.
    // This is a good practise. It's important to send an adequate http code in every API response.

    //Get methods.
    @GetMapping("/{id]")
    public ResponseEntity<StudentOutputDto> getStudentById(@PathVariable int id) {
        return null;
    }

    @GetMapping
    public Iterable<StudentOutputDto> getAllStudents(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize
    ) {
        return null;
    }

    //Post methods.
    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto student) {
        return null;
    }

    //Put methods.
    @PutMapping
    public Iterable<StudentOutputDto> updateStudent(@RequestBody StudentInputDto student) {
        return null;
    }

    //Delete methods.
    @DeleteMapping
    public ResponseEntity<String> deleteStudentById(@RequestParam int id) {
        return null;
    }
}

/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.SubjectInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.SubjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SubjectController class. RestController to manage all HTTP methods for a Subject.
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {
    // Attributes
    @Autowired
    private GenericService<SubjectInputDto, SubjectOutputDto, Long> subjectService;

    // CRUD Methods
    // Create methods
    @PostMapping("/post")
    public ResponseEntity<SubjectOutputDto> postSubject(@RequestBody SubjectInputDto subjectInputDto) {
        SubjectOutputDto createdSubject = subjectService.addEntity(subjectInputDto);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    // Read methods
    @GetMapping("/get/all")
    public ResponseEntity<List<SubjectOutputDto>> getAllSubjects() {
        List<SubjectOutputDto> subjects = subjectService.getAllEntities(0, 10);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<SubjectOutputDto> getSubjectById(@RequestParam long id) {
        SubjectOutputDto subject = subjectService.getEntityById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    // Update methods
    @PutMapping("/put")
    public ResponseEntity<SubjectOutputDto> putSubjectById(@RequestParam long id, @RequestBody SubjectInputDto subjectInputDto) {
        SubjectOutputDto updatedSubject = subjectService.updateEntityById(id, subjectInputDto);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity<SubjectOutputDto> patchSubjectById(@RequestParam long id, @RequestBody SubjectInputDto subjectInputDto) {
        SubjectOutputDto modifiedSubject = subjectService.modifyEntityById(id, subjectInputDto);
        return new ResponseEntity<>(modifiedSubject, HttpStatus.OK);
    }

    // Delete methods
    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllSubjects() {
        subjectService.deleteAllEntities();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteSubjectById(@RequestParam long id) {
        subjectService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

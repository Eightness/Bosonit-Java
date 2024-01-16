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
 * Class SubjectController. RestController to manage all HTTP methods for a Subject.
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {
    //Attributes.
    @Autowired
    private GenericService<SubjectInputDto, SubjectOutputDto> subjectService;

    //Methods.

    //Get methods.
    @GetMapping("/getAll")
    public ResponseEntity<List<SubjectOutputDto>> getAllSubjects() {
        List<SubjectOutputDto> subjects = subjectService.getAllEntities(0, 10);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/getSubjectById")
    public ResponseEntity<SubjectOutputDto> getSubjectById(@RequestParam int id) {
        SubjectOutputDto subject = subjectService.getEntityById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping("/getSubjectByUser")
    public ResponseEntity<SubjectOutputDto> getSubjectByUser(@RequestParam String user) {
        List<SubjectOutputDto> subjects = subjectService.getEntitiesByName(user);
        if (!subjects.isEmpty()) {
            return new ResponseEntity<>(subjects.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Post methods.
    @PostMapping("/postSubject")
    public ResponseEntity<SubjectOutputDto> postSubject(@RequestBody SubjectInputDto subjectInputDto) {
        SubjectOutputDto createdSubject = subjectService.addEntity(subjectInputDto);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @PostMapping("/postSubjects")
    public ResponseEntity<List<SubjectOutputDto>> postSubjects(@RequestBody List<SubjectInputDto> subjectInputDtoList) {
        List<SubjectOutputDto> createdSubjects = subjectService.addEntities(subjectInputDtoList);
        return new ResponseEntity<>(createdSubjects, HttpStatus.CREATED);
    }

    //Put methods.
    @PutMapping("/putSubjectById")
    public ResponseEntity<SubjectOutputDto> putSubjectById(@RequestParam int id, @RequestBody SubjectInputDto subjectInputDto) {
        SubjectOutputDto updatedSubject = subjectService.updateEntityById(id, subjectInputDto);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @PutMapping("/putSubjectsByIds")
    public ResponseEntity<List<SubjectOutputDto>> putSubjectsByIds(@RequestBody List<Integer> ids) {
        List<SubjectOutputDto> updatedSubjects = subjectService.updateEntitiesByIds(ids, null);
        return new ResponseEntity<>(updatedSubjects, HttpStatus.OK);
    }

    //Patch methods.
    @PatchMapping("/patchSubjectById")
    public ResponseEntity<SubjectOutputDto> patchSubjectById(@RequestParam int id, @RequestBody SubjectInputDto subjectInputDto) {
        SubjectOutputDto modifiedSubject = subjectService.modifyEntityById(id, subjectInputDto);
        return new ResponseEntity<>(modifiedSubject, HttpStatus.OK);
    }

    @PatchMapping("/patchSubjectsByIds")
    public ResponseEntity<List<SubjectOutputDto>> patchSubjectsByIds(@RequestBody List<Integer> ids) {
        List<SubjectOutputDto> modifiedSubjects = subjectService.modifyEntitiesByIds(ids, null);
        return new ResponseEntity<>(modifiedSubjects, HttpStatus.OK);
    }

    //Delete methods.
    @DeleteMapping("/deleteSubjectById")
    public ResponseEntity<Void> deleteSubjectById(@RequestParam int id) {
        subjectService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteSubjectsByIds")
    public ResponseEntity<Void> deleteSubjectsByIds(@RequestBody List<Integer> ids) {
        subjectService.deleteEntitiesByIds(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

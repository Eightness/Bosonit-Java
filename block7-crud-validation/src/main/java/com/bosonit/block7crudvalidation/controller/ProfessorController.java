/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.ProfessorInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.ProfessorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProfessorController class. RestController to manage all HTTP methods for a Professor.
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    // Attributes
    @Autowired
    private GenericService<ProfessorInputDto, ProfessorOutputDto, Long> professorService;

    // CRUD Methods
    // Create methods
    @PostMapping("/post")
    public ResponseEntity<ProfessorOutputDto> postProfessor(@RequestBody ProfessorInputDto professorInputDto) {
        ProfessorOutputDto createdProfessor = professorService.addEntity(professorInputDto);
        return new ResponseEntity<>(createdProfessor, HttpStatus.CREATED);
    }

    // Read methods
    @GetMapping("/get/all")
    public ResponseEntity<List<ProfessorOutputDto>> getAllProfessors() {
        List<ProfessorOutputDto> professors = professorService.getAllEntities(0, 10);
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ProfessorOutputDto> getProfessorById(@RequestParam long id) {
        ProfessorOutputDto professor = professorService.getEntityById(id);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    // Update methods
    @PutMapping("/put")
    public ResponseEntity<ProfessorOutputDto> putProfessorById(@RequestParam long id, @RequestBody ProfessorInputDto professorInputDto) {
        ProfessorOutputDto updatedProfessor = professorService.updateEntityById(id, professorInputDto);
        return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity<ProfessorOutputDto> patchProfessorById(@RequestParam long id, @RequestBody ProfessorInputDto professorInputDto) {
        ProfessorOutputDto modifiedProfessor = professorService.modifyEntityById(id, professorInputDto);
        return new ResponseEntity<>(modifiedProfessor, HttpStatus.OK);
    }

    // Delete methods
    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllProfessors() {
        professorService.deleteAllEntities();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProfessorById(@RequestParam long id) {
        professorService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

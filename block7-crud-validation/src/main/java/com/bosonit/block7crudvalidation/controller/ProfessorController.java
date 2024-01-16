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
 * Class ProfessorController. RestController to manage all HTTP methods for a Professor.
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    //Attributes.
    @Autowired
    private GenericService<ProfessorInputDto, ProfessorOutputDto> professorService;

    //Methods.

    //Get methods.
    @GetMapping("/getAll")
    public ResponseEntity<List<ProfessorOutputDto>> getAllProfessors() {
        List<ProfessorOutputDto> professors = professorService.getAllEntities(0, 10);
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @GetMapping("/getProfessorById")
    public ResponseEntity<ProfessorOutputDto> getProfessorById(@RequestParam int id) {
        ProfessorOutputDto professor = professorService.getEntityById(id);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @GetMapping("/getProfessorByUser")
    public ResponseEntity<ProfessorOutputDto> getProfessorByUser(@RequestParam String user) {
        List<ProfessorOutputDto> professors = professorService.getEntitiesByName(user);
        if (!professors.isEmpty()) {
            return new ResponseEntity<>(professors.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Post methods.
    @PostMapping("/postProfessor")
    public ResponseEntity<ProfessorOutputDto> postProfessor(@RequestBody ProfessorInputDto professorInputDto) {
        ProfessorOutputDto createdProfessor = professorService.addEntity(professorInputDto);
        return new ResponseEntity<>(createdProfessor, HttpStatus.CREATED);
    }

    @PostMapping("/postProfessors")
    public ResponseEntity<List<ProfessorOutputDto>> postProfessors(@RequestBody List<ProfessorInputDto> professorInputDtoList) {
        List<ProfessorOutputDto> createdProfessors = professorService.addEntities(professorInputDtoList);
        return new ResponseEntity<>(createdProfessors, HttpStatus.CREATED);
    }

    //Put methods.
    @PutMapping("/putProfessorById")
    public ResponseEntity<ProfessorOutputDto> putProfessorById(@RequestParam int id, @RequestBody ProfessorInputDto professorInputDto) {
        ProfessorOutputDto updatedProfessor = professorService.updateEntityById(id, professorInputDto);
        return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
    }

    @PutMapping("/putProfessorsByIds")
    public ResponseEntity<List<ProfessorOutputDto>> putProfessorsByIds(@RequestBody List<Integer> ids) {
        List<ProfessorOutputDto> updatedProfessors = professorService.updateEntitiesByIds(ids, null);
        return new ResponseEntity<>(updatedProfessors, HttpStatus.OK);
    }

    //Patch methods.
    @PatchMapping("/patchProfessorById")
    public ResponseEntity<ProfessorOutputDto> patchProfessorById(@RequestParam int id, @RequestBody ProfessorInputDto professorInputDto) {
        ProfessorOutputDto modifiedProfessor = professorService.modifyEntityById(id, professorInputDto);
        return new ResponseEntity<>(modifiedProfessor, HttpStatus.OK);
    }

    @PatchMapping("/patchProfessorsByIds")
    public ResponseEntity<List<ProfessorOutputDto>> patchProfessorsByIds(@RequestBody List<Integer> ids) {
        List<ProfessorOutputDto> modifiedProfessors = professorService.modifyEntitiesByIds(ids, null);
        return new ResponseEntity<>(modifiedProfessors, HttpStatus.OK);
    }

    //Delete methods.
    @DeleteMapping("/deleteProfessorById")
    public ResponseEntity<Void> deleteProfessorById(@RequestParam int id) {
        professorService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteProfessorsByIds")
    public ResponseEntity<Void> deleteProfessorsByIds(@RequestBody List<Integer> ids) {
        professorService.deleteEntitiesByIds(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.ProfessorInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.ProfessorMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.ProfessorOutputDto;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.respository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class ProfessorServiceImpl. Implements GenericService interface and contains all methods related to Professors' CRUD.
 */
@Service
public class ProfessorServiceImpl implements GenericService<ProfessorInputDto, ProfessorOutputDto> {
    //Attributes.
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    ProfessorMapper professorMapper;

    //Methods.
    @Override
    public ProfessorOutputDto getEntityById(int id) {
        Professor professor = professorRepository.findById(id).orElseThrow();
        return professorMapper.domainToOutput(professor);
    }

    @Override
    public List<ProfessorOutputDto> getEntitiesByName(String name) {
        return null;
    }

    @Override
    public List<ProfessorOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Professor> professors = professorRepository.findAll();
        return professorMapper.domainToOutput(professors);
    }

    @Override
    public ProfessorOutputDto addEntity(ProfessorInputDto inputEntity) {
        Professor professor = professorMapper.inputToDomain(inputEntity);
        professor = professorRepository.save(professor);
        return professorMapper.domainToOutput(professor);
    }

    @Override
    public List<ProfessorOutputDto> addEntities(List<ProfessorInputDto> inputEntities) {
        List<Professor> professors = professorMapper.inputToDomain(inputEntities);
        professors = professorRepository.saveAll(professors);
        return professorMapper.domainToOutput(professors);
    }

    @Override
    public ProfessorOutputDto updateEntityById(int id, ProfessorInputDto inputEntity) {
        professorRepository.findById(id).orElseThrow();
        Professor updatedProfessor = professorMapper.inputToDomain(inputEntity);
        updatedProfessor = professorRepository.save(updatedProfessor);
        return professorMapper.domainToOutput(updatedProfessor);
    }

    @Override
    public List<ProfessorOutputDto> updateEntitiesByIds(List<Integer> ids, List<ProfessorInputDto> inputEntities) {
        professorRepository.findAllById(ids);
        List<Professor> updatedProfessors = professorMapper.inputToDomain(inputEntities);
        updatedProfessors = professorRepository.saveAll(updatedProfessors);
        return professorMapper.domainToOutput(updatedProfessors);
    }

    @Override
    public ProfessorOutputDto modifyEntityById(int id, ProfessorInputDto inputEntity) {
        professorRepository.findById(id).orElseThrow();
        Professor modifiedProfessor = professorMapper.inputToDomain(inputEntity);
        modifiedProfessor = professorRepository.save(modifiedProfessor);
        return professorMapper.domainToOutput(modifiedProfessor);
    }

    @Override
    public List<ProfessorOutputDto> modifyEntitiesByIds(List<Integer> ids, List<ProfessorInputDto> inputEntities) {
        professorRepository.findAllById(ids);
        List<Professor> modifiedProfessors = professorMapper.inputToDomain(inputEntities);
        modifiedProfessors = professorRepository.saveAll(modifiedProfessors);
        return professorMapper.domainToOutput(modifiedProfessors);
    }

    @Override
    public void deleteEntityById(int id) {
        professorRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {
        professorRepository.deleteAllById(ids);
    }
}

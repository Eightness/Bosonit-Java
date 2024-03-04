/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.ProfessorInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.ProfessorMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.ProfessorOutputDto;
import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.respository.PersonRepository;
import com.bosonit.block7crudvalidation.respository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProfessorServiceImpl class. Implements GenericService interface and contains all methods related to Professors' CRUD.
 */
@Service
public class ProfessorServiceImpl implements GenericService<ProfessorInputDto, ProfessorOutputDto, Long> {
    // Attributes
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    ProfessorMapper professorMapper;
    @Autowired
    PersonRepository personRepository;

    // Methods
    @Override
    public ProfessorOutputDto getEntityById(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow();
        return professorMapper.domainToOutput(professor);
    }

    @Override
    public List<ProfessorOutputDto> getEntitiesByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<ProfessorOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Professor> allProfessors = professorRepository.findAll();
        return professorMapper.domainToOutput(allProfessors);
    }

    @Override
    public ProfessorOutputDto addEntity(ProfessorInputDto inputEntity) {
        Professor professor = new Professor();
        Person associatedPerson = personRepository.findById(inputEntity.getPersonId()).orElseThrow();
        professor.setPerson(associatedPerson);
        professor.setComments(inputEntity.getComment());
        professor.setBranch(inputEntity.getBranch());

        professorRepository.save(professor);
        return professorMapper.domainToOutput(professor);
    }

    @Override
    public List<ProfessorOutputDto> addEntities(List<ProfessorInputDto> inputEntities) {
        return null;
    }

    @Override
    public ProfessorOutputDto updateEntityById(Long id, ProfessorInputDto inputEntity) {
        professorRepository.findById(id).orElseThrow();
        Professor professor = professorMapper.inputToDomain(inputEntity);
        professorRepository.save(professor);
        return professorMapper.domainToOutput(professor);
    }

    @Override
    public List<ProfessorOutputDto> updateEntitiesByIds(List<Long> ids, List<ProfessorInputDto> inputEntities) {
        return null;
    }

    @Override
    public ProfessorOutputDto modifyEntityById(Long id, ProfessorInputDto inputEntity) {
        professorRepository.findById(id).orElseThrow();
        Professor professor = professorMapper.inputToDomain(inputEntity);
        professorRepository.save(professor);
        return professorMapper.domainToOutput(professor);
    }

    @Override
    public List<ProfessorOutputDto> modifyEntitiesByIds(List<Long> ids, List<ProfessorInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Long> ids) {

    }

    @Override
    public void deleteAllEntities() {
        professorRepository.deleteAll();
    }
}

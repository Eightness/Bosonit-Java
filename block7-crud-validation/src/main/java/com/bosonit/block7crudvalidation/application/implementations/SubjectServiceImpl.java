/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.SubjectInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.SubjectMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.SubjectOutputDto;
import com.bosonit.block7crudvalidation.domain.Subject;
import com.bosonit.block7crudvalidation.respository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SubjectServiceImpl class. Implements GenericService interface and contains all methods related to Subjects' CRUD.
 */
@Service
public class SubjectServiceImpl implements GenericService<SubjectInputDto, SubjectOutputDto, Long> {
    // Attributes
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectMapper subjectMapper;

    // Methods
    @Override
    public SubjectOutputDto getEntityById(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow();
        return subjectMapper.domainToOutput(subject);
    }

    @Override
    public List<SubjectOutputDto> getEntitiesByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<SubjectOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Subject> allSubjects = subjectRepository.findAll();
        return subjectMapper.domainToOutput(allSubjects);
    }

    @Override
    public SubjectOutputDto addEntity(SubjectInputDto inputEntity) {
        Subject subject = subjectMapper.inputToDomain(inputEntity);
        subjectRepository.save(subject);
        return subjectMapper.domainToOutput(subject);
    }

    @Override
    public List<SubjectOutputDto> addEntities(List<SubjectInputDto> inputEntities) {
        return null;
    }

    @Override
    public SubjectOutputDto updateEntityById(Long id, SubjectInputDto inputEntity) {
        subjectRepository.findById(id).orElseThrow();
        Subject subject = subjectMapper.inputToDomain(inputEntity);
        subjectRepository.save(subject);
        return subjectMapper.domainToOutput(subject);
    }

    @Override
    public List<SubjectOutputDto> updateEntitiesByIds(List<Long> ids, List<SubjectInputDto> inputEntities) {
        return null;
    }

    @Override
    public SubjectOutputDto modifyEntityById(Long id, SubjectInputDto inputEntity) {
        subjectRepository.findById(id).orElseThrow();
        Subject subject = subjectMapper.inputToDomain(inputEntity);
        subjectRepository.save(subject);
        return subjectMapper.domainToOutput(subject);
    }

    @Override
    public List<SubjectOutputDto> modifyEntitiesByIds(List<Long> ids, List<SubjectInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Long> ids) {

    }

    @Override
    public void deleteAllEntities() {
        subjectRepository.deleteAll();
    }
}

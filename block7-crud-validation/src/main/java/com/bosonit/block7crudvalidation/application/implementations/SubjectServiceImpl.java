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

@Service
public class SubjectServiceImpl implements GenericService<SubjectInputDto, SubjectOutputDto> {
    //Attributes.
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectMapper subjectMapper;

    //Methods.
    @Override
    public SubjectOutputDto getEntityById(int id) {
        Subject subject = subjectRepository.findById(id).orElseThrow();
        return subjectMapper.domainToOutput(subject);
    }

    @Override
    public List<SubjectOutputDto> getEntitiesByName(String name) {
        return null;
    }

    @Override
    public List<SubjectOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Subject> subjects = subjectRepository.findAll();
        return subjectMapper.domainToOutput(subjects);
    }

    @Override
    public SubjectOutputDto addEntity(SubjectInputDto inputEntity) {
        Subject subject = subjectMapper.inputToDomain(inputEntity);
        subject = subjectRepository.save(subject);
        return subjectMapper.domainToOutput(subject);
    }

    @Override
    public List<SubjectOutputDto> addEntities(List<SubjectInputDto> inputEntities) {
        List<Subject> subjects = subjectMapper.inputToDomain(inputEntities);
        subjects = subjectRepository.saveAll(subjects);
        return subjectMapper.domainToOutput(subjects);
    }

    @Override
    public SubjectOutputDto updateEntityById(int id, SubjectInputDto inputEntity) {
        subjectRepository.findById(id).orElseThrow();
        Subject updatedSubject = subjectMapper.inputToDomain(inputEntity);
        updatedSubject = subjectRepository.save(updatedSubject);
        return subjectMapper.domainToOutput(updatedSubject);
    }

    @Override
    public List<SubjectOutputDto> updateEntitiesByIds(List<Integer> ids, List<SubjectInputDto> inputEntities) {
        subjectRepository.findAllById(ids);
        List<Subject> updatedSubjects = subjectMapper.inputToDomain(inputEntities);
        updatedSubjects = subjectRepository.saveAll(updatedSubjects);
        return subjectMapper.domainToOutput(updatedSubjects);
    }

    @Override
    public SubjectOutputDto modifyEntityById(int id, SubjectInputDto inputEntity) {
        subjectRepository.findById(id).orElseThrow();
        Subject modifiedSubject = subjectMapper.inputToDomain(inputEntity);
        modifiedSubject = subjectRepository.save(modifiedSubject);
        return subjectMapper.domainToOutput(modifiedSubject);
    }

    @Override
    public List<SubjectOutputDto> modifyEntitiesByIds(List<Integer> ids, List<SubjectInputDto> inputEntities) {
        subjectRepository.findAllById(ids);
        List<Subject> modifiedSubjects = subjectMapper.inputToDomain(inputEntities);
        modifiedSubjects = subjectRepository.saveAll(modifiedSubjects);
        return subjectMapper.domainToOutput(modifiedSubjects);
    }

    @Override
    public void deleteEntityById(int id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {
        subjectRepository.deleteAllById(ids);
    }
}

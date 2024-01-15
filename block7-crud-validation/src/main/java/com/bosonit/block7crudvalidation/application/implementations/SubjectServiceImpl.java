package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.SubjectInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.SubjectMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.SubjectOutputDto;
import com.bosonit.block7crudvalidation.respository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubjectServiceImpl implements GenericService<SubjectInputDto, SubjectOutputDto> {
    //Attributes.
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectMapper subjectMapper;

    //Methods.
    @Override
    public SubjectOutputDto getEntityById(int id) {
        return null;
    }

    @Override
    public List<SubjectOutputDto> getEntitiesByName(String name) {
        return null;
    }

    @Override
    public List<SubjectOutputDto> getAllEntities(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public SubjectOutputDto addEntity(SubjectInputDto inputEntity) {
        return null;
    }

    @Override
    public List<SubjectOutputDto> addEntities(List<SubjectInputDto> inputEntities) {
        return null;
    }

    @Override
    public SubjectOutputDto updateEntityById(int id, SubjectInputDto inputEntity) {
        return null;
    }

    @Override
    public List<SubjectOutputDto> updateEntitiesByIds(List<Integer> ids, List<SubjectInputDto> inputEntities) {
        return null;
    }

    @Override
    public SubjectOutputDto modifyEntityById(int id, SubjectInputDto inputEntity) {
        return null;
    }

    @Override
    public List<SubjectOutputDto> modifyEntitiesByIds(List<Integer> ids, List<SubjectInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(int id) {

    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {

    }
}

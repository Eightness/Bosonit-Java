package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.StudentInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.StudentMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.StudentOutputDto;
import com.bosonit.block7crudvalidation.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements GenericService<StudentInputDto, StudentOutputDto> {
    //Attributes.
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    //Methods.
    @Override
    public StudentOutputDto getEntityById(int id) {
        return null;
    }

    @Override
    public List<StudentOutputDto> getEntitiesByName(String name) {
        return null;
    }

    @Override
    public List<StudentOutputDto> getAllEntities(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public StudentOutputDto addEntity(StudentInputDto inputEntity) {
        return null;
    }

    @Override
    public List<StudentOutputDto> addEntities(List<StudentInputDto> inputEntities) {
        return null;
    }

    @Override
    public StudentOutputDto updateEntityById(int id, StudentInputDto inputEntity) {
        return null;
    }

    @Override
    public List<StudentOutputDto> updateEntitiesByIds(List<Integer> ids, List<StudentInputDto> inputEntities) {
        return null;
    }

    @Override
    public StudentOutputDto modifyEntityById(int id, StudentInputDto inputEntity) {
        return null;
    }

    @Override
    public List<StudentOutputDto> modifyEntitiesByIds(List<Integer> ids, List<StudentInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(int id) {

    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {

    }
}

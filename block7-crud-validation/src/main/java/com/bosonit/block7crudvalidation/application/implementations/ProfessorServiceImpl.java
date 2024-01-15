package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.ProfessorInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.ProfessorMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.ProfessorOutputDto;
import com.bosonit.block7crudvalidation.respository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Class ProfessorServiceImpl. Implements GenericService interface and contains all methods related to Professors' CRUD.
 */
public class ProfessorServiceImpl implements GenericService<ProfessorInputDto, ProfessorOutputDto> {
    //Attributes.
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    ProfessorMapper professorMapper;

    //Methods.
    @Override
    public ProfessorOutputDto getEntityById(int id) {
        return null;
    }

    @Override
    public List<ProfessorOutputDto> getEntitiesByName(String name) {
        return null;
    }

    @Override
    public List<ProfessorOutputDto> getAllEntities(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public ProfessorOutputDto addEntity(ProfessorInputDto inputEntity) {
        return null;
    }

    @Override
    public List<ProfessorOutputDto> addEntities(List<ProfessorInputDto> inputEntities) {
        return null;
    }

    @Override
    public ProfessorOutputDto updateEntityById(int id, ProfessorInputDto inputEntity) {
        return null;
    }

    @Override
    public List<ProfessorOutputDto> updateEntitiesByIds(List<Integer> ids, List<ProfessorInputDto> inputEntities) {
        return null;
    }

    @Override
    public ProfessorOutputDto modifyEntityById(int id, ProfessorInputDto inputEntity) {
        return null;
    }

    @Override
    public List<ProfessorOutputDto> modifyEntitiesByIds(List<Integer> ids, List<ProfessorInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(int id) {

    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {

    }
}

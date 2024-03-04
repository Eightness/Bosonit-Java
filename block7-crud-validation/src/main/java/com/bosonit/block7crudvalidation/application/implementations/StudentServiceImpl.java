/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.application.implementations;

import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.StudentInputDto;
import com.bosonit.block7crudvalidation.controller.dto.mappers.StudentMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.StudentOutputDto;
import com.bosonit.block7crudvalidation.domain.Student;
import com.bosonit.block7crudvalidation.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StudentServiceImpl class. Implements GenericService interface and contains all methods related to Students' CRUD.
 */
@Service
public class StudentServiceImpl implements GenericService<StudentInputDto, StudentOutputDto, Long> {
    // Attributes
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    // Methods
    @Override
    public StudentOutputDto getEntityById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return studentMapper.domainToOutput(student);
    }

    @Override
    public List<StudentOutputDto> getEntitiesByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<StudentOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Student> allStudents = studentRepository.findAll();
        return studentMapper.domainToOutput(allStudents);
    }

    @Override
    public StudentOutputDto addEntity(StudentInputDto inputEntity) {
        Student student = studentMapper.inputToDomain(inputEntity);
        studentRepository.save(student);
        return studentMapper.domainToOutput(student);
    }

    @Override
    public List<StudentOutputDto> addEntities(List<StudentInputDto> inputEntities) {
        return null;
    }

    @Override
    public StudentOutputDto updateEntityById(Long id, StudentInputDto inputEntity) {
        studentRepository.findById(id).orElseThrow();
        Student student = studentMapper.inputToDomain(inputEntity);
        studentRepository.save(student);
        return studentMapper.domainToOutput(student);
    }

    @Override
    public List<StudentOutputDto> updateEntitiesByIds(List<Long> ids, List<StudentInputDto> inputEntities) {
        return null;
    }

    @Override
    public StudentOutputDto modifyEntityById(Long id, StudentInputDto inputEntity) {
        studentRepository.findById(id).orElseThrow();
        Student student = studentMapper.inputToDomain(inputEntity);
        studentRepository.save(student);
        return studentMapper.domainToOutput(student);
    }

    @Override
    public List<StudentOutputDto> modifyEntitiesByIds(List<Long> ids, List<StudentInputDto> inputEntities) {
        return null;
    }

    @Override
    public void deleteEntityById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Long> ids) {

    }

    @Override
    public void deleteAllEntities() {
        studentRepository.deleteAll();
    }
}

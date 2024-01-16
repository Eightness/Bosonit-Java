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

@Service
public class StudentServiceImpl implements GenericService<StudentInputDto, StudentOutputDto> {

    //Attributes.
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    //Methods.
    @Override
    public StudentOutputDto getEntityById(int id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return studentMapper.domainToOutput(student);
    }

    @Override
    public List<StudentOutputDto> getEntitiesByName(String name) {
        List<Student> students = studentRepository.findByName(name);
        return studentMapper.domainToOutput(students);
    }

    @Override
    public List<StudentOutputDto> getAllEntities(int pageNumber, int pageSize) {
        List<Student> students = studentRepository.findAll();
        return studentMapper.domainToOutput(students);
    }

    @Override
    public StudentOutputDto addEntity(StudentInputDto inputEntity) {
        Student student = studentMapper.inputToDomain(inputEntity);
        student = studentRepository.save(student);
        return studentMapper.domainToOutput(student);
    }

    @Override
    public List<StudentOutputDto> addEntities(List<StudentInputDto> inputEntities) {
        List<Student> students = studentMapper.inputToDomain(inputEntities);
        students = studentRepository.saveAll(students);
        return studentMapper.domainToOutput(students);
    }

    @Override
    public StudentOutputDto updateEntityById(int id, StudentInputDto inputEntity) {
        studentRepository.findById(id).orElseThrow();
        Student updatedStudent = studentMapper.inputToDomain(inputEntity);
        updatedStudent = studentRepository.save(updatedStudent);
        return studentMapper.domainToOutput(updatedStudent);
    }

    @Override
    public List<StudentOutputDto> updateEntitiesByIds(List<Integer> ids, List<StudentInputDto> inputEntities) {
        studentRepository.findAllById(ids);
        List<Student> updatedStudents = studentMapper.inputToDomain(inputEntities);
        updatedStudents = studentRepository.saveAll(updatedStudents);
        return studentMapper.domainToOutput(updatedStudents);
    }

    @Override
    public StudentOutputDto modifyEntityById(int id, StudentInputDto inputEntity) {
        studentRepository.findById(id).orElseThrow();
        Student modifiedStudent = studentMapper.inputToDomain(inputEntity);
        modifiedStudent = studentRepository.save(modifiedStudent);
        return studentMapper.domainToOutput(modifiedStudent);
    }

    @Override
    public List<StudentOutputDto> modifyEntitiesByIds(List<Integer> ids, List<StudentInputDto> inputEntities) {
        studentRepository.findAllById(ids);
        List<Student> modifiedStudents = studentMapper.inputToDomain(inputEntities);
        modifiedStudents = studentRepository.saveAll(modifiedStudents);
        return studentMapper.domainToOutput(modifiedStudents);
    }

    @Override
    public void deleteEntityById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteEntitiesByIds(List<Integer> ids) {
        studentRepository.deleteAllById(ids);
    }
}

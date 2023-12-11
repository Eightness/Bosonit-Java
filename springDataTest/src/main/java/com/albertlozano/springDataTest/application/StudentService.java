/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.springDataTest.application;

import com.albertlozano.springDataTest.controller.dto.StudentInputDto;
import com.albertlozano.springDataTest.controller.dto.StudentOutputDto;

/**
 * Interface StudentService. Contains methods that define business' logic.
 */
public interface StudentService {
    //Methods that will be implemented.
    StudentOutputDto addStudent(StudentInputDto student);
    StudentOutputDto getStudentById(int id);
    void deleteStudentById(int id);
    Iterable<StudentOutputDto> getAllStudents(int pageNumber, int pageSize);
    StudentOutputDto updateStudent(StudentInputDto student);
    //REMEMBER: Service layer gets and returns DTOs, not Student's instances.
}

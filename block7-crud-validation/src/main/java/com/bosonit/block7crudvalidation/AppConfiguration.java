/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation;

import com.bosonit.block7crudvalidation.application.implementations.ProfessorServiceImpl;
import com.bosonit.block7crudvalidation.application.implementations.StudentServiceImpl;
import com.bosonit.block7crudvalidation.application.implementations.SubjectServiceImpl;
import com.bosonit.block7crudvalidation.application.implementations.PersonServiceImpl;
import com.bosonit.block7crudvalidation.application.services.GenericService;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.PersonInputDto;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.ProfessorInputDto;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.StudentInputDto;
import com.bosonit.block7crudvalidation.controller.dto.inputDto.SubjectInputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.ProfessorOutputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.StudentOutputDto;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.SubjectOutputDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class AppConfiguration. Defines all Beans for the project to run.
 */
@Configuration
public class AppConfiguration {
    //Beans.
    @Bean
    public GenericService<PersonInputDto, PersonOutputDto> personService() {
        return new PersonServiceImpl();
    }
    @Bean
    public GenericService<ProfessorInputDto, ProfessorOutputDto> professorService() {
        return new ProfessorServiceImpl();
    }
    @Bean
    public GenericService<StudentInputDto, StudentOutputDto> studentService() {
        return new StudentServiceImpl();
    }
    @Bean
    public GenericService<SubjectInputDto, SubjectOutputDto> subjectService() {
        return new SubjectServiceImpl();
    }
}

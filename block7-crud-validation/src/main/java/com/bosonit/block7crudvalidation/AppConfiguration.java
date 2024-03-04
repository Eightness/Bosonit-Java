/**
 * @author Albert Lozano Blasco
 * @version 11.0
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
 * AppConfiguration class. Defines all Beans for the project to run.
 */
@Configuration
public class AppConfiguration {
    // Beans
    @Bean
    public GenericService<PersonInputDto, PersonOutputDto, Long> personService() {
        return new PersonServiceImpl();
    }

    @Bean
    public GenericService<ProfessorInputDto, ProfessorOutputDto, Long> professorService() {
        return new ProfessorServiceImpl();
    }

    @Bean
    public GenericService<StudentInputDto, StudentOutputDto, Long> studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public GenericService<SubjectInputDto, SubjectOutputDto, Long> subjectService() {
        return new SubjectServiceImpl();
    }
}

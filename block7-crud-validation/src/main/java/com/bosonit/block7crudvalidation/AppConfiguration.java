/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation;

import com.bosonit.block7crudvalidation.application.implementations.ProfessorServiceImpl;
import com.bosonit.block7crudvalidation.application.implementations.StudentServiceImpl;
import com.bosonit.block7crudvalidation.application.implementations.SubjectServiceImpl;
import com.bosonit.block7crudvalidation.application.services.PersonService;
import com.bosonit.block7crudvalidation.application.implementations.PersonServiceImpl;
import com.bosonit.block7crudvalidation.application.services.ProfessorService;
import com.bosonit.block7crudvalidation.application.services.StudentService;
import com.bosonit.block7crudvalidation.application.services.SubjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class AppConfiguration. Defines all Beans for the project to run.
 */
@Configuration
public class AppConfiguration {
    //Bean for PersonService interface (returns the only class that implements it).
    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }
    @Bean
    public ProfessorService professorService() { return new ProfessorServiceImpl(); }
    @Bean
    public StudentService studentService() { return new StudentServiceImpl(); }
    @Bean
    public SubjectService subjectService() { return new SubjectServiceImpl(); }
}

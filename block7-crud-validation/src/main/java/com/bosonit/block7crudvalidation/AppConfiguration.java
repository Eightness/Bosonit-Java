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
import com.bosonit.block7crudvalidation.exceptions.CustomError;
import com.bosonit.block7crudvalidation.respository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * AppConfiguration class. Defines all Beans for the project to run.
 */
@Configuration
@RequiredArgsConstructor
public class AppConfiguration {
    // Attributes
    private final PersonRepository personRepository;

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

    // Authentication
    @Bean
    public UserDetailsService userDetailsService() {
        return login -> (UserDetails) personRepository.findByLogin(login)
                .orElseThrow();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

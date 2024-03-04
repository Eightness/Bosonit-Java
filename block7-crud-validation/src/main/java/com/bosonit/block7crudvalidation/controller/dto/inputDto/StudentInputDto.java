/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.inputDto;

import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Subject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * StudentInputDto class. Contains all Student's attributes obtainable by user's input.
 */
@Data
@NoArgsConstructor
public class StudentInputDto {
    // Attributes
    @NotNull
    private String studentId;

    @NotNull
    private Person person;

    @NotNull
    private int numHoursPerWeek;

    private String comments;

    @NotNull
    private Professor professor;

    @NotNull
    private List<Subject> subjects;

    // Custom constructor with validations
    public StudentInputDto(
            @Valid String studentId,
            @Valid Person person,
            @Valid int numHoursPerWeek,
            String comments,
            @Valid Professor professor,
            @Valid List<Subject> subjects
    ) {
        this.studentId = studentId;
        this.person = person;
        this.numHoursPerWeek = numHoursPerWeek;
        this.comments = comments;
        this.professor = professor;
        this.subjects = subjects;
    }
}

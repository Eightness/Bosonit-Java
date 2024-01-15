package com.bosonit.block7crudvalidation.controller.dto.inputDto;

import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Subject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentInputDto {
    //Attributes.
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

    //Custom constructor.
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

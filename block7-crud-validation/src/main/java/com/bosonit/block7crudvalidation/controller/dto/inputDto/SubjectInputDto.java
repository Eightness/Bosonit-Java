/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.inputDto;

import com.bosonit.block7crudvalidation.domain.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * SubjectInputDto class. Contains all Subject's attributes obtainable by user's input.
 */
@Data
@NoArgsConstructor
public class SubjectInputDto {
    // Attributes
    @NotNull
    private String subjectId;

    @NotNull
    private List<Student> students;

    @NotNull
    private String subject;

    private String comments;

    @NotNull
    private Date initialDate;

    private Date finishDate;

    // Custom constructor with validations
    public SubjectInputDto(
        @Valid String subjectId,
        @Valid List<Student> students,
        @Valid String subject,
        String comments,
        @Valid Date initialDate,
        Date finishDate
    ) {
        this.subjectId = subjectId;
        this.students = students;
        this.subject = subject;
        this.comments = comments;
        this.initialDate = initialDate;
        this.finishDate = finishDate;
    }
}

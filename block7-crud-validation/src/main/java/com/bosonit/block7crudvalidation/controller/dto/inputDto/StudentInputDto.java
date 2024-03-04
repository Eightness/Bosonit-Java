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
    private long personId;

    @NotNull
    private int numHoursPerWeek;

    private String comments;

    @NotNull
    private long professorId;
}

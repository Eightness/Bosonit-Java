/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.inputDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProfessorInputDto class. Contains all Professor's attributes obtainable by user's input.
 */
@Data
@NoArgsConstructor
public class ProfessorInputDto {
    // Attributes
    @NotNull
    private String professorId;

    @NotNull
    private String personId;

    private String comment;

    @NotNull
    private String branch;

    // Custom constructor with validations
    public ProfessorInputDto(
            @Valid String professorId,
            @Valid String personId,
            String comment,
            @Valid String branch
    ) {
        this.professorId = professorId;
        this.personId = personId;
        this.comment = comment;
        this.branch = branch;
    }
}

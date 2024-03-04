/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.inputDto;

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
    private long personId;

    private String comment;

    @NotNull
    private String branch;
}

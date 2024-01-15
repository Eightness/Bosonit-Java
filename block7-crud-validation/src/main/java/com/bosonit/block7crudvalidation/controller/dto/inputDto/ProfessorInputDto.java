package com.bosonit.block7crudvalidation.controller.dto.inputDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfessorInputDto {
    //Attributes.
    @NotNull
    private String professorId;
    @NotNull
    private String personId;
    private String comment;
    @NotNull
    private String branch;

    //Custom constructor.
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

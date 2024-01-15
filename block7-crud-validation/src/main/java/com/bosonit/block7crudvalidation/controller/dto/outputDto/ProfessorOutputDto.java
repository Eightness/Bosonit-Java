package com.bosonit.block7crudvalidation.controller.dto.outputDto;

import com.bosonit.block7crudvalidation.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorOutputDto {
    //Attributes.
    private String professorId;
    private Person person;
    private String comments;
    private String branch;
}

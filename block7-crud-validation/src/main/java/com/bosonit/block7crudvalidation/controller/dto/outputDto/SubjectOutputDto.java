package com.bosonit.block7crudvalidation.controller.dto.outputDto;

import com.bosonit.block7crudvalidation.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOutputDto {
    //Attributes.
    private String subjectId;
    private List<Student> students;
    private String subject;
    private String comments;
    private Date initialDate;
    private Date finishDate;
}

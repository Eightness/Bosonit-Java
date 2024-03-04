/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.outputDto;

import com.bosonit.block7crudvalidation.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * SubjectOutputDto class. Contains all Subject's attributes to display.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOutputDto {
    // Attributes
    private String subjectId;
    private List<Student> students;
    private String subject;
    private String comments;
    private Date initialDate;
    private Date finishDate;
}

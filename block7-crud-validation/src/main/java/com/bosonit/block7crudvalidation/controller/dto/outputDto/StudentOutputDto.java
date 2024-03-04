/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.outputDto;

import com.bosonit.block7crudvalidation.domain.Person;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * StudentOutputDto class. Contains all Student's attributes to display.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    // Attributes
    private String studentId;
    private Person person;
    private int numHoursPerWeek;
    private String comments;
    private Professor professor;
    private String branch;
    private List<Subject> subjects;
}

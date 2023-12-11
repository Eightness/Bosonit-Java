/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.springDataTest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class StudentOutputDto. Data Transfer Object that works with Student's output.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    //In this case, StudentOutputDto class will be exactly the same as StudentInputDto class.
    // If Student had, for instance, a password, it wouldn't be in this class, because there's no need to show that data.
    int id;
    String name;
    String lastName;
}

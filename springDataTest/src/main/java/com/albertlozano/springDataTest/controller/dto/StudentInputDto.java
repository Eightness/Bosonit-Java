/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.springDataTest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class StudentInputDto. Data Transfer Object that works with user's input.
 */
//Lombok's annotations.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDto {
    int id;
    String name;
    String lastName;
}

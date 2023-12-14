/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class PersonOutputDto. Data Transfer Object that works with Person's output.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    //Attributes.
    private int id;
    private String outputName;
    private String outputAge;
    private String outputTown;
}

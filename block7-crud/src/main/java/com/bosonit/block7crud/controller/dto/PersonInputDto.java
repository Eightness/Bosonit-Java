/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class PersonInputDto. Data Transfer Object that works with user's input.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDto {
    //Attributes.
    private String inputName;
    private String inputAge;
    private String inputTown;
}

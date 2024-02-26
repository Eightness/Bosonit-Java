/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.controller.dto.outputDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CarOutputDTO class. Contains all Car's attributes to show.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarOutputDTO {
    // Attributes
    private long binNumber;
    private String color;
    private String licensePlate;
    private String brand;
    private String model;
}

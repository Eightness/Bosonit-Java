/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.controller.dto.inputDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * CarInputDTO class. Contains all Car's attributes obtainable by user's input.
 */
@Data
public class CarInputDTO {
    // Attributes
    @NotNull
    private String color;

    @NotNull
    private String licensePlate;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private boolean isAvailable;

    // Custom constructor with validations
    public CarInputDTO(
        @Valid String color,
        @Valid String licensePlate,
        @Valid String brand,
        @Valid String model,
        @Valid boolean isAvailable
    ) {
        this.color = color;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.isAvailable = isAvailable;
    }
}

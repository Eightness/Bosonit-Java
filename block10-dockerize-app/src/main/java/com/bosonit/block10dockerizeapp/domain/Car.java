/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Car entity. Contains all car's attributes and related methods.
 */
@Entity
@Table(name = "Car")
@Data
@AllArgsConstructor
public class Car {
    // Enum
    public enum Color {
        BLACK,
        GREY,
        WHITE,
        RED,
        BLUE,
        YELLOW,
        GREEN
    }

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long binNumber;

    @NotNull
    private Color color;

    @NotNull
    private String licensePlate;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private boolean isAvailable;
}

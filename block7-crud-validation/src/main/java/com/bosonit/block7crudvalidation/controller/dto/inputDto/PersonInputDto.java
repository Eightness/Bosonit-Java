/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.inputDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * PersonInputDto class. Contains all Person's attributes obtainable by user's input.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInputDto {
    // Attributes
    @Size(min = 6, max = 10)
    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String name;

    private String surname;

    @NotNull
    private String companyEmail;

    @NotNull
    private String personalEmail;

    @NotNull
    private String city;

    @NotNull
    private Boolean active;

    @NotNull
    private Date createdDate;

    private String imageUrl;

    private Date terminationDate;
}

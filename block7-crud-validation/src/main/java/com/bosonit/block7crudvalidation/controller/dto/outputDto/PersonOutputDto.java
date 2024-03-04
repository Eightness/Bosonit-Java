/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.outputDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * PersonOutputDto class. Contains all Person's attributes to display.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    // Attributes
    private int personId;
    private String user;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;
}

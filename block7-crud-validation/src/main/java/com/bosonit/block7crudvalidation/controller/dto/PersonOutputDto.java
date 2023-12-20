/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.controller.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PersonOutputDto {
    //Attributes.
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

/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.controller.dto.inputDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonInputDto {
    //Attributes.
    @NotNull
    @Max(10)
    @Min(6)
    private String user;
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
    private boolean active;
    @NotNull
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;

    //Custom constructor with @Valid.
    public PersonInputDto(
        @Valid String user,
        @Valid String password,
        @Valid String name,
        String surname,
        @Valid String companyEmail,
        @Valid String personalEmail,
        @Valid String city,
        @Valid boolean active,
        @Valid Date createdDate,
        String imageUrl,
        Date terminationDate
    ) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.companyEmail = companyEmail;
        this.personalEmail = personalEmail;
        this.city = city;
        this.active = active;
        this.createdDate = createdDate;
        this.imageUrl = imageUrl;
        this.terminationDate = terminationDate;
    }
}

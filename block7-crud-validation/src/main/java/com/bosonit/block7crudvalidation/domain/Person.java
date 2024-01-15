/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crudvalidation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    //Attributes.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String personId;

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
    private Boolean active;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;
}


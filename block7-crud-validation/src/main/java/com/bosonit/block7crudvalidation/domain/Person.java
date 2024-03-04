/**
 * @author Albert Lozano Blasco
 * @version 11.0
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

/**
 * Person class. Defines a person.
 */
@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;

    @NotNull
    @Max(10)
    @Min(6)
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;
}


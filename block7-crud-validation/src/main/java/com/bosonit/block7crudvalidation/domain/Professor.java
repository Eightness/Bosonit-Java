package com.bosonit.block7crudvalidation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Professor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    //Attributes.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String professorId;
    @OneToOne
    @JoinColumn(name = "personId", nullable = false, unique = true)
    private String personId;
    private String comments;
    @NotNull
    private String branch;
}

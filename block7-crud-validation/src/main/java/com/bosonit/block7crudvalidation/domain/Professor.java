/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Professor class. Defines a professor.
 */
@Entity
@Table(name = "Professor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long professorId;

    @OneToOne
    @JoinColumn(name = "personId", nullable = false, unique = true)
    private Person person;

    private String comments;

    @NotNull
    private String branch;

    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<Student> students;
}


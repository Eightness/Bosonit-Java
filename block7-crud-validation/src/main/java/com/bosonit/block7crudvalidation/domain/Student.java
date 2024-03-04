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
 * Student class. Defines a student.
 */
@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long studentId;

    @OneToOne
    @JoinColumn(name = "personId", nullable = false, unique = true)
    private Person person;

    @NotNull
    private int numHoursPerWeek;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "professorId", nullable = false)
    private Professor professor;

    @NotNull
    private String branch;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Subject_Student", joinColumns = @JoinColumn(name = "students"),
            inverseJoinColumns = @JoinColumn(name = "subjects"))
    private List<Subject> subjects;
}

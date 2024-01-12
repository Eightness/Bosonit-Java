package com.bosonit.block7crudvalidation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    //Attributes.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String subjectId;
    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false, unique = true)
    private List<Student> students;
    private String subject;
    private String comments;
    @NotNull
    private Date initialDate;
    private Date finishDate;

}

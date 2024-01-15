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
    private long subjectId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Subject_Student", joinColumns = @JoinColumn(name = "subjects"),
            inverseJoinColumns = @JoinColumn(name = "students"))
    private List<Student> students;

    private String subject;
    private String comments;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date initialDate;

    @Temporal(TemporalType.DATE)
    private Date finishDate;
}

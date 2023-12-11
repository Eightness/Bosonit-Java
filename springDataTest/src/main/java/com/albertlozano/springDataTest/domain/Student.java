/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.springDataTest.domain;

import com.albertlozano.springDataTest.controller.dto.StudentInputDto;
import com.albertlozano.springDataTest.controller.dto.StudentOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Student. Defines a student. It's a model/domain class and an Entity/Table.
 */
@Entity //Java Persistence annotation to define this class as an Entity.
//Lombok's annotations.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    //Attributes or Columns.
    @Id //Indicates that this attribute will be the table's PK.
    @GeneratedValue //Will automatically generate the key in case it's not specified.
    int id;
    String name;
    String lastName;

    //Constructor via StudentInputDto. (We'll be getting an already constructed Student from user's input).
    public Student (StudentInputDto studentInputDto) {
        this.id = studentInputDto.getId();
        this.name = studentInputDto.getName();
        this.lastName = studentInputDto.getLastName();
    }

    //Methods.
    //Method to transform and return a Student as a StudentOutputDto.
    // We would be using "MapStruct" or some another library to automatically map DTOs.
    // In this case, Student's class is simple, and we can implement this method instead. (Imagine a class with 20+ attributes).
    public StudentOutputDto studentToStudentOutputDto() {
        return new StudentOutputDto(
                this.id,
                this.name,
                this.lastName
        );
    }

}

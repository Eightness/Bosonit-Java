/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block7crud.domain;

import com.bosonit.block7crud.controller.dto.PersonInputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Person. Defines a person. It's a model/domain class and an Entity/Table.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    //Attributes.
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String age;
    private String town;

    //Custom constructor with PersonInputDto.
    public Person(PersonInputDto personInputDto) {
        this.name = personInputDto.getInputName();
        this.age = personInputDto.getInputAge();
        this.town = personInputDto.getInputTown();
    }
}

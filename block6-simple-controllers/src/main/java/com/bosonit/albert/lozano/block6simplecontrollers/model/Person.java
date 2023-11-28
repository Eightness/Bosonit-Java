/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6simplecontrollers.model;

import lombok.Data;

/**
 * Class Person. It's intended to recreate a person. Attributes: name, town, age.
 */
@Data   //Using lombok's data annotation to automatically create setters, getters, constructors, toString, equals and hash methods.
public class Person {
    private String name;
    private String town;
    private int age;
}

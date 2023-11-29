/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class Person. Defines a person in our app.
 */
@Data   //Lombok's annotation. All class Person's methods contained.
@AllArgsConstructor //Lombok's annotation. Creates an all arguments' constructor.
public class Person {
    //Attributes.
    private String name;
    private String town;
    private int age;
}

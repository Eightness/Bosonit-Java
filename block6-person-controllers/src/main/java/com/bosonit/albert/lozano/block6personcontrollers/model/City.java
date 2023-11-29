/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class City. Defines a city in our app.
 */
@Data   //Lombok's annotation. All class' methods contained.
@AllArgsConstructor //Lombok's annotation. Creates an all arguments' constructor.
public class City {
    //Attributes.
    private String name;
    private int population;
}

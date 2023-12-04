/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6pathvariableheaders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class MyObject. Defines a general object.
 */
//Lombok's annotations.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyObject {
    //Attributes.
    private String property1;
    private String property2;
    private int property3;
    private int property4;
}

/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6pathvariableheaders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class AllDataResponse. To receive custom Json.
 */
//Lombok's annotations.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllDataResponse {
    //Attributes.
    private String body;
    private List<String> requestParams;
    private String h1;
    private String h2;
}

/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * CustomError class. This class's serves to display a custom error via different exceptions.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    // Attributes
    private Date timestamp;
    private int httpCode;
    private String message;

}

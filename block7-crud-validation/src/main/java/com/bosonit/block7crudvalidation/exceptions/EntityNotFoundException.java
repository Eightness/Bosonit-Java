/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * EntityNotFoundException class. Extends from RuntimeException. Used to throw a custom exception when an entity is not found. Uses a custom error.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public CustomError getCustomError() {
        return new CustomError(new Date(), HttpStatus.NOT_FOUND.value(), getMessage());
    }
}

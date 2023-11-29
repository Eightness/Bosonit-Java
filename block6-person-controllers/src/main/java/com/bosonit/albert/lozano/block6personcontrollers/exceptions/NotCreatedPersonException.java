/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.exceptions;

/**
 * Class NotCreatedPersonException. Extends from Exception class. This is a custom exception for the class Person.
 */
public class NotCreatedPersonException extends RuntimeException {

    public NotCreatedPersonException(String message) {
        super(message);
    }
}

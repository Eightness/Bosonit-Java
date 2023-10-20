/**
 *
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package org.example;

/**
 * This exception is thrown to indicate that a line in a CSV file has an invalid format.
 * It is a checked exception, meaning it should be explicitly caught or declared by the calling code.
 */
public class InvalidLineFormatException extends Exception {

    /**
     * Constructs a new InvalidLineFormatException with the specified detail message.
     *
     * @param message the detail message that describes the reason for the exception
     */
    public InvalidLineFormatException(String message) {
        super(message);
    }
}

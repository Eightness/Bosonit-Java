/**
 *
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package org.example;

/**
 * This exception is thrown to indicate that a required field is missing.
 * It is a checked exception, meaning it should be explicitly caught or declared by the calling code.
 */
public class FieldRequiredException extends Exception {

    /**
     * Constructs a new FieldRequiredException with the specified detail message.
     *
     * @param fieldName field Name that is required.
     */
    public FieldRequiredException(String fieldName) {
        super("Field " + fieldName + " is required.");
    }
}

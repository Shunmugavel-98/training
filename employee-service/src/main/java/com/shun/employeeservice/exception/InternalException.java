package com.shun.employeeservice.exception;

/**
 * <p>
 * Custom exception to represent internal server errors.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
public class InternalException extends RuntimeException {

    /**
     * <p>
     * Constructs a new InternalException with the specified detail message.
     * </p>
     *
     * @param message the detail message
     */
    public InternalException(String message) {
        super(message);
    }
}

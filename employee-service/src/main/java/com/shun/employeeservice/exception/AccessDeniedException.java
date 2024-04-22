package com.shun.employeeservice.exception;

/**
 * <p>
 * Custom exception to represent access denied errors.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
public class AccessDeniedException extends RuntimeException {

    /**
     * <p>
     * Constructs a new AccessDeniedException with the specified detail message.
     * </p>
     *
     * @param message the detail message
     */
    public AccessDeniedException(String message) {
        super(message);
    }
}

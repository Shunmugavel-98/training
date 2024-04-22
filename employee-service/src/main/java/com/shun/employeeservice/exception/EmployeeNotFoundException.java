package com.shun.employeeservice.exception;

/**
 * <p>
 * Custom exception to represent resource not found errors.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
public class EmployeeNotFoundException extends RuntimeException {

    /**
     * <p>
     * Constructs a new EmployeeNotFoundException with the specified detail message.
     * </p>
     *
     * @param message the detail message
     */
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

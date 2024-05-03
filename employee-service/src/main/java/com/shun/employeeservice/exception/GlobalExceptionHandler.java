package com.shun.employeeservice.exception;

import com.shun.employeeservice.common.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <p>
 * This class serves as a global exception handler for the application
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * <p>
     * Handles the EmployeeNotFoundException and returns a GenericResponse with the exception message and
     * HttpStatus.NOT_FOUND status.
     * </p>
     *
     * @param exception The EmployeeNotFoundException that was thrown
     * @return GenericResponse with the exception message and HttpStatus.NOT_FOUND status
     */
    @ExceptionHandler({EmployeeNotFoundException.class})
    public GenericResponse<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        return new GenericResponse<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * <p>
     * Handles the AccessDeniedException and returns a GenericResponse with the exception message and
     * HttpStatus.UNAUTHORIZED status.
     * </p>
     *
     * @param exception The AccessDeniedException that was thrown
     * @return GenericResponse with the exception message and HttpStatus.UNAUTHORIZED status
     */
    @ExceptionHandler({AccessDeniedException.class})
    public GenericResponse<Object> handleAccessDeniedException(AccessDeniedException exception) {
        return new GenericResponse<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    /**
     * <p>
     * Handles the RuntimeException and returns a GenericResponse with the exception message and
     * HttpStatus.INTERNAL_SERVER_ERROR status.
     * </p>
     *
     * @param exception The RuntimeException that was thrown
     * @return GenericResponse with the exception message and HttpStatus.INTERNAL_SERVER_ERROR status
     */
    @ExceptionHandler({RuntimeException.class})
    public GenericResponse<Object> handleRuntimeException(RuntimeException exception) {
        return new GenericResponse<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

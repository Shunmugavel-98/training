package com.shun.notificationservice.exception;

import com.shun.notificationservice.common.GenericResponse;
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
     * Handles the MailServerException and returns a GenericResponse with the exception message and
     * HttpStatus.BAD_GATEWAY status.
     * </p>
     *
     * @param exception The MailServerException that was thrown
     * @return GenericResponse with the exception message and HttpStatus.BAD_GATEWAY status
     */
    @ExceptionHandler({MailServerException.class})
    public GenericResponse<Object> handleMailServerException(MailServerException exception) {
        return new GenericResponse<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

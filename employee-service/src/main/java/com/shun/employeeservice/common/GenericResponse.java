package com.shun.employeeservice.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * <p>
 * This class represents a generic response with data, message and status code.
 * </p>
 *
 * @param <T> the type of data in the message
 * @author Shunmugavel - created on April 09, 2024
 */
public class GenericResponse<T> extends ResponseEntity<Object> {

    /**
     * <p>
     * Constructor for a generic response with data, message and status code.
     * </p>
     *
     * @param data the data to include in the response
     * @param message the message to include in the response
     * @param httpStatus the HTTP status code to include in the response
     */
    public GenericResponse(Object data, String message, HttpStatus httpStatus) {
        super(new GenericMessage<T>(message, data, Integer.valueOf(httpStatus.value())), httpStatus);
    }

    /**
     * <p>
     * Constructor for a generic response with only message and status code.
     * </p>
     *
     * @param message the message to include in the response
     * @param httpStatus the HTTP status code to include in the response
     */
    public GenericResponse(String message, HttpStatus httpStatus) {
        super(new GenericMessage<T>(message, null, Integer.valueOf(httpStatus.value())), httpStatus);
    }
}

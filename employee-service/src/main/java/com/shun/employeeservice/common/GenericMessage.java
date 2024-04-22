package com.shun.employeeservice.common;

import lombok.Data;

/**
 * <p>
 * This class represents a generic message with a message, data, and status code.
 * </p>
 *
 * @param <T> the type of data in the message
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
public class GenericMessage<T> {
    private String message;
    private Object data;
    private Integer statusCode;

    /**
     * <p>
     * Constructs a new GenericMessage with the specified message, data, and status code.
     * </p>
     *
     * @param message the message content
     * @param data the additional data
     * @param statusCode the status code
     */
    public GenericMessage(String message, Object data, Integer statusCode) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}

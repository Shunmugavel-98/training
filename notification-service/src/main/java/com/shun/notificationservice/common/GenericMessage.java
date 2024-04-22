package com.shun.notificationservice.common;

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
    private Integer statusCode;

    /**
     * <p>
     * Constructs a new GenericMessage with the specified message, data, and status code.
     * </p>
     *
     * @param message the message content
     * @param statusCode the status code
     */
    public GenericMessage(String message, Integer statusCode) {
        this.statusCode = statusCode;
        this.message = message;
    }
}

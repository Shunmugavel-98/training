package com.shun.employeeservice.common;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class GenericMessage<T> {
    private String message;
    private Object data;
    private Integer statusCode;
}

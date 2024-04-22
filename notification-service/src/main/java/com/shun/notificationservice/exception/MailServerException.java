package com.shun.notificationservice.exception;

/**
 * <p>
 * Custom exception to represent mail server errors.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
public class MailServerException extends RuntimeException {

    /**
     * <p>
     * Constructs a new MailServerException with the specified detail message.
     * </p>
     *
     * @param message the detail message
     */
    public MailServerException(String message) {
        super(message);
    }
}

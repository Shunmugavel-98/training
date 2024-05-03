package com.shun.employeeservice.common;

import lombok.Data;

/**
 * <p>
 * Represents the response for a login operation.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
public class LoginResponse {

    private String message;
    private String accessToken;
    private Long userId;
    private String userName;

}

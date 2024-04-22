package com.shun.employeeservice.common;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * Represents the response for a login operation.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Getter
@Setter
public class LoginResponse {

    private String message;
    private String accessToken;

}

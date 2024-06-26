package com.shun.employeeservice.model.dto;

import lombok.Data;

/**
 * <p>
 * Data transfer object for sign up request.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
public class SignUpRequestDto {

    private String name;
    private String emailId;
    private String phone;
    private String password;
    private Long createdBy;
}

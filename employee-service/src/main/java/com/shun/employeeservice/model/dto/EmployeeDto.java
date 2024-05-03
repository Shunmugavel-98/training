package com.shun.employeeservice.model.dto;

import lombok.Data;

/**
 * <p>
 * Data transfer object for employee.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phone;
}

package com.shun.employeeservice.model.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phone;
}

package com.shun.employeeservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * Data transfer object for sign up response.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
@AllArgsConstructor
public class SignUpResponseDto {
    private String message;
}

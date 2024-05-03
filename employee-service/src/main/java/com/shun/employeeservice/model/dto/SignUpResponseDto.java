package com.shun.employeeservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * <p>
 * Data transfer object for sign up response.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
public class SignUpResponseDto {
    @NonNull
    private String message;
}

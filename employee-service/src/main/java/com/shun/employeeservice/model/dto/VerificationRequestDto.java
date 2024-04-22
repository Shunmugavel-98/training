package com.shun.employeeservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * Data transfer object for verification request.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
public class VerificationRequestDto {

    private String recipientEmailId;

    private String verificationCode;
}

package com.shun.notificationservice.model.dto;

import lombok.AllArgsConstructor;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerificationRequestDto {

    private String recipientEmailId;

    private String verificationCode;
}

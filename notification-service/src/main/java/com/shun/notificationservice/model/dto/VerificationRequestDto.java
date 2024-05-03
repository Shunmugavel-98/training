package com.shun.notificationservice.model.dto;

import lombok.Data;

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

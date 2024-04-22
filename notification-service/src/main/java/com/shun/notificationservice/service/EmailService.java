package com.shun.notificationservice.service;

import com.shun.notificationservice.model.dto.VerificationRequestDto;

public interface EmailService {

    String sendVerificationMail(VerificationRequestDto verificationRequestDto);

    String verifyMail(String verificationCode);
}

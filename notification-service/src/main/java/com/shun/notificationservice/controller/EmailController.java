package com.shun.notificationservice.controller;

import com.shun.notificationservice.common.Constants;
import com.shun.notificationservice.model.dto.VerificationRequestDto;
import com.shun.notificationservice.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Controller for managing email-related operations.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@RestController
@RequestMapping("/notification")
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    /**
     * <p>
     * Endpoint for sending an email.
     * </p>
     *
     * @param verificationRequestDto The data of the recipient of the email
     * @return ResponseEntity with the status of the email
     */
    @PostMapping("/send-verification-mail")
    public ResponseEntity<String> sendVerificationMail(@RequestBody VerificationRequestDto verificationRequestDto) {
        String status = emailService.sendVerificationMail(verificationRequestDto);
        if (status.equals(Constants.INTERNAL_SERVER_ERROR)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.status(HttpStatus.OK).body(Constants.SUCCESS);
    }

    /**
     * <p>
     * Endpoint for verifying an email.
     * </p>
     *
     * @param verificationCode The verification code
     * @return ResponseEntity with the status of the email
     */
    @PostMapping("/verify-mail")
    public ResponseEntity<String> verifyMail(@RequestParam String verificationCode) {
        String status = emailService.verifyMail(verificationCode);
        if (status.equals(Constants.VERIFICATION_FAILED)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constants.VERIFICATION_FAILED);
        }
        return ResponseEntity.status(HttpStatus.OK).body(Constants.VERIFICATION_SUCCESS);
    }
}

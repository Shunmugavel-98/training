package com.shun.notificationservice.service.impl;

import com.shun.notificationservice.common.Constants;
import com.shun.notificationservice.exception.MailServerException;
import com.shun.notificationservice.model.dto.VerificationRequestDto;
import com.shun.notificationservice.model.entity.User;
import com.shun.notificationservice.repository.UserRepository;
import com.shun.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Service class for managing email data.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    /**
     * <p>
     * Sends an email using the provided mail request data.
     * </p>
     *
     * @param verificationRequestDto The data of the recipient of the email
     * @return A status message after sending the email
     * @throws MailServerException if an error occurs while sending the email
     */
    public String sendVerificationMail(VerificationRequestDto verificationRequestDto) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            String content = Constants.VERIFICATION_MAIL_BODY;
            content = content.replace(Constants.VERIFICATION_CODE, verificationRequestDto.getVerificationCode());
            mailMessage.setFrom(sender);
            mailMessage.setTo(verificationRequestDto.getRecipientEmailId());
            mailMessage.setText(content);
            mailMessage.setSubject(Constants.MAIL_SUBJECT);
            javaMailSender.send(mailMessage);
            return Constants.SUCCESS;
        } catch (Exception ex) {
            throw new MailServerException(Constants.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * <p>
     * Verify an email using the verification code.
     * </p>
     *
     * @param verificationCode The verification code
     * @return A status message after verifying the email
     */
    public String verifyMail(String verificationCode) {
        try {
            User user = userRepository.findByVerificationCodeAndIsActiveFalse(verificationCode);
            if (user == null) {
                return Constants.VERIFICATION_FAILED;
            }
            user.setIsActive(true);
            userRepository.save(user);
            return Constants.SUCCESS;
        } catch (Exception ex) {
            throw new MailServerException(Constants.INTERNAL_SERVER_ERROR);
        }
    }
}

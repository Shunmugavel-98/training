package com.shun.notificationservice.common;

/**
 * <p>
 * This class contains common constants used in the application.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
public class Constants {

    // Status messages
    public static final String SUCCESS = "Success";

    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

    // Mail content
    public static final String MAIL_SUBJECT = "Verify your registration";

    public static final String VERIFICATION_MAIL_BODY = "Please click the link to verify your registration: "
            + "<a href=\"http://localhost:8080/api/notification/verify-mail?verificationCode={{verificationCode}}\">Verify your account</a>";

    public static final String VERIFICATION_CODE = "{{verificationCode}}";
    public static final int VERIFICATION_CODE_LENGTH = 64;

    public static final String VERIFICATION_FAILED = "Sorry, we could not verify account. It maybe already verified or verification code is incorrect";

    public static final String VERIFICATION_SUCCESS = "Your account has been verified successfully. You can login now!";
}

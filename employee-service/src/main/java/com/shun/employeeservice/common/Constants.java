package com.shun.employeeservice.common;

/**
 * <p>
 * This class contains common constants used in the application.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
public class Constants {

    // Status messages
    public static final String DELETE_STATUS = "Deleted Successfully";
    public static final String CREATED_STATUS = "Created Successfully";
    public static final String UPDATE_STATUS = "Updated Successfully";
    public static final String FETCH_STATUS = "Retrieved Successfully";
    public static final String USER_TYPE_NORMAL = "Normal";
    public static final String USER_TYPE_ADMIN = "Admin";
    public static final String SUCCESS = "Success";
    public static final String USER_CREATION_SUCCESS = "User created successfully";

    // Integer constants
    public static final int ZERO = 0;
    public static final int ONE = 1;

    // Login messages
    public static final String LOGIN_SUCCESS = "Successfully Logged In";
    public static final String INVALID_CREDENTIALS = "Invalid Credentials";
    public static final String INVALID_CREDENTIALS_OR_USER_NOT_ACTIVE = "Invalid Credentials or the user is not active";
    public static final String RETRY_LATER = "Login failed. Try again after 1 minute...";
    public static final String INCORRECT_LOGIN_ATTEMPTS = "Too many incorrect login attempts. Try again after ";

    // Access messages
    public static final String ACCESS_DENIED = "Access Denied";
    public static final String SECONDS = " seconds";

    // Not found message
    public static final String NOT_FOUND = "Not Found";

    public static final String EMPLOYEE_NOT_FOUND = "Employee not found with id: ";

    // Login attempts limit
    public static final int MAX_INCORRECT_LOGIN_ATTEMPTS = 3;

    // Email send url
    public static final String EMAIL_URL = "http://localhost:8082/api/notification/send-verification-mail";

    // Error messages
    public static final String USER_CREATION_FAILED = "User creation failed";

    public static final String INTERNAL_SERVER_ERROR = "Internal server error occurred - ";

    public static final String EMAIL_ALREADY_EXISTS = "Email already exists";

    // Verification
    public static final String VERIFICATION_MESSAGE = "An email has been sent. Please verify your account";

    public static final int VERIFICATION_CODE_LENGTH = 64;

    // Authorization
    public static final String AUTHORIZATION = "Authorization";
    public static final String LOGIN_URL = "/api/user/login";
    public static final String SIGN_UP_URL = "/api/user/signup";

    // JWT
    public static final String MY_SECRET_KEY = "Th1$-i$-4-5up3r-53cr3t-k3y-th@t-y0u-c@n't-gu3$$-h@-h@-h@";

    public static final String EMAIL = "email";

    public static final String ROLE = "role";

}

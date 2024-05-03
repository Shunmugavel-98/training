package com.shun.employeeservice.controller;

import com.shun.employeeservice.common.Constants;
import com.shun.employeeservice.common.GenericResponse;
import com.shun.employeeservice.common.LoginResponse;
import com.shun.employeeservice.model.dto.LoginRequestDto;
import com.shun.employeeservice.model.dto.SignUpRequestDto;
import com.shun.employeeservice.model.dto.SignUpResponseDto;
import com.shun.employeeservice.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Controller for managing login-related operations.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    /**
     * <p>
     * Endpoint for user signup.
     * </p>
     *
     * @param signUpRequestDto The request data for user signup
     * @return GenericResponse based on the signup response
     */
    @PostMapping("/signup")
    public GenericResponse<String> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto response = loginService.signUp(signUpRequestDto);
        if (response.getMessage().equals(Constants.EMAIL_ALREADY_EXISTS)) {
            return new GenericResponse<>(Constants.EMAIL_ALREADY_EXISTS, HttpStatus.NOT_ACCEPTABLE);
        } else if (response.getMessage().equals(Constants.USER_CREATION_FAILED)) {
            return new GenericResponse<>(Constants.USER_CREATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new GenericResponse<>(Constants.VERIFICATION_MESSAGE, HttpStatus.OK);
    }

    /**
     * <p>
     * Endpoint for user login.
     * </p>
     *
     * @param loginRequestDto The request data for user login
     * @return GenericResponse based on the login response
     */
    @PostMapping("/login")
    public GenericResponse<LoginResponse> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponse loginResponse = loginService.login(loginRequestDto);
        return switch (loginResponse.getMessage()) {
            case Constants.INVALID_CREDENTIALS_OR_USER_NOT_ACTIVE ->
                    new GenericResponse<>(loginResponse, Constants.INVALID_CREDENTIALS_OR_USER_NOT_ACTIVE, HttpStatus.UNAUTHORIZED);
            case Constants.RETRY_LATER ->
                    new GenericResponse<>(loginResponse, Constants.RETRY_LATER, HttpStatus.UNAUTHORIZED);
            case Constants.LOGIN_SUCCESS -> new GenericResponse<>(loginResponse, Constants.FETCH_STATUS, HttpStatus.OK);
            default -> new GenericResponse<>(loginResponse, loginResponse.getMessage(), HttpStatus.UNAUTHORIZED);
        };
    }
}

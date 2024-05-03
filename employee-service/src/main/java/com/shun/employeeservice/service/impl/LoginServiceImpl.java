package com.shun.employeeservice.service.impl;

import com.shun.employeeservice.common.Constants;
import com.shun.employeeservice.common.LoginResponse;
import com.shun.employeeservice.model.dto.LoginRequestDto;
import com.shun.employeeservice.model.dto.SignUpRequestDto;
import com.shun.employeeservice.model.dto.SignUpResponseDto;
import com.shun.employeeservice.model.dto.VerificationRequestDto;
import com.shun.employeeservice.model.entity.User;
import com.shun.employeeservice.repository.UserRepository;
import com.shun.employeeservice.service.LoginService;
import com.shun.employeeservice.util.JwtUtils;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * <p>
 * Service class for managing login data.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * <p>
     * Sign up a new user based on the provided SignUpRequestDto.
     * </p>
     *
     * @param signUpRequestDto the SignUpRequestDto containing user information
     * @return SignUpResponseDto based on the sign up attempt
     */
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        User checkUser = userRepository.findByEmailId(signUpRequestDto.getEmailId());
        if (null != checkUser) {
            return new SignUpResponseDto(Constants.EMAIL_ALREADY_EXISTS);
        }
        User user = new User();
        user.setEmailId(signUpRequestDto.getEmailId());
        user.setName(signUpRequestDto.getName());
        user.setPassword(signUpRequestDto.getPassword());
        user.setPhone(signUpRequestDto.getPhone());
        user.setIsActive(Boolean.FALSE);
        user.setUserType(Constants.USER_TYPE_NORMAL);
        user.setIncorrectLoginAttempts(Constants.ZERO);

        String randomCode = RandomString.make(Constants.VERIFICATION_CODE_LENGTH);
        VerificationRequestDto verificationRequestDto = new VerificationRequestDto();
        verificationRequestDto.setRecipientEmailId(signUpRequestDto.getEmailId());
        verificationRequestDto.setVerificationCode(randomCode);
        user.setVerificationCode(randomCode);
        if (null != signUpRequestDto.getCreatedBy()) {
            user.setCreatedBy(signUpRequestDto.getCreatedBy());
        }

        // Send a verification email
        HttpEntity<VerificationRequestDto> entity = new HttpEntity<>(verificationRequestDto);
        ResponseEntity<String> emailResponse = restTemplate.exchange(Constants.EMAIL_URL, HttpMethod.POST, entity, String.class);
        if (emailResponse.getStatusCode().is2xxSuccessful() && Objects.equals(emailResponse.getBody(), Constants.SUCCESS)) {
            userRepository.save(user);
            return new SignUpResponseDto(Constants.VERIFICATION_MESSAGE);
        }
        return new SignUpResponseDto(Constants.USER_CREATION_FAILED);
    }

    /**
     * <p>
     * Login a user based on the provided LoginRequestDto.
     * </p>
     *
     * @param loginRequestDto the LoginRequestDto containing login information
     * @return the LoginResponse based on the login attempt
     */
    public LoginResponse login(LoginRequestDto loginRequestDto) {
        LoginResponse loginResponse = new LoginResponse();
        User user = userRepository.findByEmailIdAndIsActiveTrue(loginRequestDto.getEmailId());
        if (null != user) {
            loginResponse.setUserId(user.getId());
            loginResponse.setUserName(user.getName());
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime retryAt = user.getRetryPeriod();
            // retry login can be attempted or not
            if (retryAt != null && currentTime.isBefore(retryAt)) {
                loginResponse.setMessage(Constants.INCORRECT_LOGIN_ATTEMPTS + currentTime.until(retryAt, ChronoUnit.SECONDS) + Constants.SECONDS);
                return loginResponse;
            }
            // if the login info is correct
            if (loginRequestDto.getPassword().equals(user.getPassword())) {
                String token = jwtUtils.generateJwt(user.getName(), user.getEmailId(), user.getUserType());

                loginResponse.setAccessToken(token);
                loginResponse.setMessage(Constants.LOGIN_SUCCESS);
                if (user.getIncorrectLoginAttempts() > Constants.ZERO) {
                    user.setIncorrectLoginAttempts(Constants.ZERO);
                    userRepository.save(user);
                }
                return loginResponse;
            } else {
                if (null != retryAt && currentTime.until(retryAt, ChronoUnit.HOURS) >= Constants.ONE) {
                    user.setIncorrectLoginAttempts(Constants.ZERO);
                } else if (user.getIncorrectLoginAttempts() > Constants.MAX_INCORRECT_LOGIN_ATTEMPTS) {
                    loginResponse.setMessage(Constants.RETRY_LATER);
                    user.setRetryPeriod(currentTime.plus(Constants.ONE, ChronoUnit.MINUTES));
                }
                user.setIncorrectLoginAttempts(user.getIncorrectLoginAttempts() + 1);
                userRepository.save(user);
            }
        } else {
            loginResponse.setMessage(Constants.INVALID_CREDENTIALS_OR_USER_NOT_ACTIVE);
        }
        return loginResponse;
    }
}

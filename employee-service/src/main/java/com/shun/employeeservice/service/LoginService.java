package com.shun.employeeservice.service;

import com.shun.employeeservice.common.LoginResponse;
import com.shun.employeeservice.model.dto.LoginRequestDto;
import com.shun.employeeservice.model.dto.SignUpRequestDto;
import com.shun.employeeservice.model.dto.SignUpResponseDto;

public interface LoginService {

    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);

    LoginResponse login(LoginRequestDto loginRequestDto);
}

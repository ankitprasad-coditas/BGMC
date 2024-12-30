package com.project4.BGMC.service;

import com.project4.BGMC.dto.UserRequestDto;
import com.project4.BGMC.dto.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
}

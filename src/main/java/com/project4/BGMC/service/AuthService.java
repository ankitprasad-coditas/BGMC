package com.project4.BGMC.service;


import com.project4.BGMC.dto.AuthRequestDto;
import com.project4.BGMC.dto.TokenResponseDto;

public interface AuthService {
    TokenResponseDto login (AuthRequestDto authRequestDto);
}

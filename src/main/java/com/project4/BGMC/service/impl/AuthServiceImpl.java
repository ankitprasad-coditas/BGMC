package com.project4.BGMC.service.impl;


import com.project4.BGMC.dto.AuthRequestDto;
import com.project4.BGMC.dto.TokenResponseDto;
import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.exceptions.UnauthorisedException;
import com.project4.BGMC.repository.UserRepository;
import com.project4.BGMC.security.JwtService;
import com.project4.BGMC.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepo;


    public TokenResponseDto login(AuthRequestDto authRequestDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));
            User user = userRepo.findByEmail(authRequestDto.getEmail()).orElseThrow(() -> new UnauthorisedException("User not found with email: " + authRequestDto.getEmail()));
            String companyId = user.getCompanyId();
            String accessToken = jwtService.generateAccessToken(authRequestDto.getEmail(),companyId);
            String name = user.getName();
            String role = user.getRole().getName();
            TokenResponseDto tokenResponseDto = TokenResponseDto.builder()
                    .accessToken(accessToken)
                    .name(name)
                    .role(role)
                    .build();
            return tokenResponseDto;
        } catch (BadCredentialsException e) {
            throw new UnauthorisedException("Invalid Login Details");
        }
    }
}

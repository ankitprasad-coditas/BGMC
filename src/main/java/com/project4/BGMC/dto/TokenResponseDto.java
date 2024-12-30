package com.project4.BGMC.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TokenResponseDto {

    private String accessToken;
    private String name;
    private String role;
}
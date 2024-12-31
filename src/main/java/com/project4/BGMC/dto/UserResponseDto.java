package com.project4.BGMC.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String role;
    private String profilePicPath;
    private Long stateId;
    private Long districtId;
    private Long cityId;
    private String companyId;
    private boolean isDeleted;
}


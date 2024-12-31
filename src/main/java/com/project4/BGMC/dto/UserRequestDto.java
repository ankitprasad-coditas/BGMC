package com.project4.BGMC.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "Give marks for Logic")
    private String name;
    private String email;
    private Long role;
    private String profilePicturePath;
    private Long stateId = 0l;
    private Long districtId = 0l;
    private Long cityId = 0l;
    private boolean isDeleted = false;
}

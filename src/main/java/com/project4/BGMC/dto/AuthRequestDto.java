package com.project4.BGMC.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthRequestDto {

    @NotBlank(message = "Please Enter A Valid EmailId")
    private String email;

    @NotBlank(message = "Please Enter Your Password")
    private String password;

}

package com.project4.BGMC.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponseDto {

    private String companyName;
    private String primaryEmail;
    private String city;
    private String companyId;

}

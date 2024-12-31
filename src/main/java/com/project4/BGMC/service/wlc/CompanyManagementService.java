package com.project4.BGMC.service.wlc;

import com.project4.BGMC.dto.CompanyRequestDto;
import com.project4.BGMC.dto.CompanyResponseDto;

import java.util.List;

public interface CompanyManagementService {
    
    void createCompany(CompanyRequestDto companyRequestDto);

    List<CompanyResponseDto> getALlCompanies();

}
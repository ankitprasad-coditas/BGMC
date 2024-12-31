package com.project4.BGMC.controller;

import com.project4.BGMC.dto.ApiResponseDto;
import com.project4.BGMC.dto.CompanyRequestDto;
import com.project4.BGMC.dto.CompanyResponseDto;
import com.project4.BGMC.service.wlc.CompanyManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class TenantsApiController {

    private final CompanyManagementService companyManagementService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto<Void>> createTenant(@RequestBody CompanyRequestDto companyRequestDto) {
        companyManagementService.createCompany(companyRequestDto);
        ApiResponseDto<Void> response = new ApiResponseDto<>(null,HttpStatus.CREATED.value(),"Company Created Successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/allCompanies")
    public ResponseEntity<ApiResponseDto<List<CompanyResponseDto>>> getAllCompanies(){
        ApiResponseDto<List<CompanyResponseDto>> response = new ApiResponseDto<>(companyManagementService.getALlCompanies(),HttpStatus.OK.value(),"Company List Fetched");
        return ResponseEntity.ok(response);
    }

}
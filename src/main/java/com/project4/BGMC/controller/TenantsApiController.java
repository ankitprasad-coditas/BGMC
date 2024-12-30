package com.project4.BGMC.controller;

import com.project4.BGMC.dto.CompanyRequestDto;
import com.project4.BGMC.service.wlc.CompanyManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class TenantsApiController {

    private final CompanyManagementService companyManagementService;

    @PostMapping("/create")
    public ResponseEntity<Void> createTenant(@RequestBody CompanyRequestDto companyRequestDto) {
        companyManagementService.createCompany(companyRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
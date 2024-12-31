package com.project4.BGMC.controller;

import com.project4.BGMC.dto.ApiResponseDto;
import com.project4.BGMC.dto.MeterRequestDto;
import com.project4.BGMC.dto.MeterResponseDto;
import com.project4.BGMC.service.serviceprovider.MeterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/meter")
@RequiredArgsConstructor
public class MeterController {

    private final MeterService meterService;

    @PostMapping("/create")
    private ResponseEntity<ApiResponseDto<MeterResponseDto>> createMeter(@RequestBody MeterRequestDto meterRequestDto){
        ApiResponseDto<MeterResponseDto> response = new ApiResponseDto<>(meterService.createMeter(meterRequestDto), HttpStatus.CREATED.value(), "Meter Created Successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}

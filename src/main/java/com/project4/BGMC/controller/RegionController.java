package com.project4.BGMC.controller;

import com.project4.BGMC.dto.ApiResponseDto;
import com.project4.BGMC.dto.RegionResponseDto;
import com.project4.BGMC.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/region")
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/states")
    public ResponseEntity<ApiResponseDto<List<RegionResponseDto>>> getAllStates() {
        ApiResponseDto<List<RegionResponseDto>> response = new ApiResponseDto(regionService.getAllStates(), HttpStatus.OK.value(), "States Fetched Successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/districts")
    public ResponseEntity<ApiResponseDto<List<RegionResponseDto>>> getDistrictByState(@RequestParam("stateId") Long stateId) {
        ApiResponseDto<List<RegionResponseDto>> response = new ApiResponseDto(regionService.getDistrictByState(stateId), HttpStatus.OK.value(), "District's Fetched Successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cities")
    public ResponseEntity<ApiResponseDto<List<RegionResponseDto>>> getCityByDistrictByState(@RequestParam("districtId") Long districtId, @RequestParam("stateId") Long stateId) {
        ApiResponseDto<List<RegionResponseDto>> response = new ApiResponseDto(regionService.getCityByDistrict(districtId, stateId), HttpStatus.OK.value(), "Cities Fetched Successfully");
        return ResponseEntity.ok(response);
    }

}

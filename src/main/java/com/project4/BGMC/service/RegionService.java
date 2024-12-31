package com.project4.BGMC.service;

import com.project4.BGMC.dto.RegionResponseDto;

import java.util.List;

public interface RegionService {

    List<RegionResponseDto> getAllStates();

    List<RegionResponseDto> getDistrictByState(Long id);

    List<RegionResponseDto> getCityByDistrict(Long districtId, Long stateId);
}

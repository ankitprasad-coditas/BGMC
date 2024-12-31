package com.project4.BGMC.service.serviceprovider;

import com.project4.BGMC.dto.MeterRequestDto;
import com.project4.BGMC.dto.MeterResponseDto;

public interface MeterService {

    MeterResponseDto createMeter(MeterRequestDto meterRequestDto);
}

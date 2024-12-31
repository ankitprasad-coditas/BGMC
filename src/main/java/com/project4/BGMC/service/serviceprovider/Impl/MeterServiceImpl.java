package com.project4.BGMC.service.serviceprovider.Impl;

import com.project4.BGMC.dto.MeterRequestDto;
import com.project4.BGMC.dto.MeterResponseDto;
import com.project4.BGMC.entity.serviceprovider.Meter;
import com.project4.BGMC.mapper.Impl.MeterRequestMapper;
import com.project4.BGMC.mapper.Impl.MeterResponseMapper;
import com.project4.BGMC.repository.serviceprovider.MeterRepository;
import com.project4.BGMC.service.serviceprovider.MeterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeterServiceImpl implements MeterService {

    private final MeterRepository meterRepository;
    private final MeterRequestMapper meterRequestMapper;
    private final MeterResponseMapper meterResponseMapper;

    @Override
    @Transactional
    public MeterResponseDto createMeter(MeterRequestDto meterRequestDto) {
        Meter newMeter = meterRequestMapper.toEntity(meterRequestDto);
        Meter savedMeter = meterRepository.save(newMeter);
        return meterResponseMapper.toDto(savedMeter);
    }
}

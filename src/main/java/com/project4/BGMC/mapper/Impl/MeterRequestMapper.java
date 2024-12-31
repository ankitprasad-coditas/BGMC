package com.project4.BGMC.mapper.Impl;

import com.project4.BGMC.dto.MeterRequestDto;
import com.project4.BGMC.entity.serviceprovider.Meter;
import com.project4.BGMC.mapper.DtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MeterRequestMapper implements DtoMapper<Meter, MeterRequestDto> {

    @Override
    public MeterRequestDto toDto(Meter entity) {
        return null;
    }

    @Override
    public Meter toEntity(MeterRequestDto meterRequestDto) {
        return Meter.builder()
                .meterType(meterRequestDto.getMeterType())
                .meterRate(meterRequestDto.getMeterRate())
                .noOfReadings(meterRequestDto.getNoOfReadings())
                .timeInterval(meterRequestDto.getTimeInterval())
                .isDeleted(meterRequestDto.isDeleted())
                .build();
    }

    @Override
    public Set<MeterRequestDto> toDtoSet(Set<Meter> entityList) {
        return Set.of();
    }

    @Override
    public Set<Meter> toEntitySet(Set<MeterRequestDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<MeterRequestDto> toDtoList(List<Meter> entityList) {
        return List.of();
    }

    @Override
    public List<Meter> toEntityList(List<MeterRequestDto> dtoList) {
        return List.of();
    }
}

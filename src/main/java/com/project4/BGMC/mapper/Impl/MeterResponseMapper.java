package com.project4.BGMC.mapper.Impl;

import com.project4.BGMC.dto.MeterResponseDto;
import com.project4.BGMC.entity.serviceprovider.Meter;
import com.project4.BGMC.mapper.DtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MeterResponseMapper implements DtoMapper<Meter, MeterResponseDto> {

    @Override
    public MeterResponseDto toDto(Meter entity) {
        return MeterResponseDto.builder()
                .id(entity.getId())
                .meterType(entity.getMeterType())
                .meterRate(entity.getMeterRate())
                .noOfReadings(entity.getNoOfReadings())
                .timeInterval(entity.getTimeInterval())
                .isDeleted(entity.isDeleted())
                .build();
    }

    @Override
    public Meter toEntity(MeterResponseDto dto) {
        return null;
    }

    @Override
    public Set<MeterResponseDto> toDtoSet(Set<Meter> entityList) {
        return Set.of();
    }

    @Override
    public Set<Meter> toEntitySet(Set<MeterResponseDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<MeterResponseDto> toDtoList(List<Meter> entityList) {
        return List.of();
    }

    @Override
    public List<Meter> toEntityList(List<MeterResponseDto> dtoList) {
        return List.of();
    }
}

package com.project4.BGMC.mapper.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project4.BGMC.dto.RegionResponseDto;
import com.project4.BGMC.entity.masterentity.District;
import com.project4.BGMC.mapper.DtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DistrictMapper implements DtoMapper<District, RegionResponseDto> {

    @Override
    public RegionResponseDto toDto(District entity) throws JsonProcessingException {
        return null;
    }

    @Override
    public District toEntity(RegionResponseDto dto) {
        return null;
    }

    @Override
    public Set<RegionResponseDto> toDtoSet(Set<District> entityList) {
        return Set.of();
    }

    @Override
    public Set<District> toEntitySet(Set<RegionResponseDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<RegionResponseDto> toDtoList(List<District> entityList) {
        return entityList.stream().map(
                district -> RegionResponseDto.builder().regionId(district.getId()).regionName(district.getName()).build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<District> toEntityList(List<RegionResponseDto> dtoList) {
        return List.of();
    }
}

package com.project4.BGMC.mapper.Impl;

import com.project4.BGMC.dto.RegionResponseDto;
import com.project4.BGMC.entity.masterentity.City;
import com.project4.BGMC.mapper.DtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CityMapper implements DtoMapper<City, RegionResponseDto> {


    @Override
    public RegionResponseDto toDto(City entity) {
        return null;
    }

    @Override
    public City toEntity(RegionResponseDto dto) {
        return null;
    }

    @Override
    public Set<RegionResponseDto> toDtoSet(Set<City> entityList) {
        return Set.of();
    }

    @Override
    public Set<City> toEntitySet(Set<RegionResponseDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<RegionResponseDto> toDtoList(List<City> entityList) {
        return entityList.stream().map(
                city -> RegionResponseDto.builder().regionId(city.getId()).regionName(city.getName()).build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<City> toEntityList(List<RegionResponseDto> dtoList) {
        return List.of();
    }
}

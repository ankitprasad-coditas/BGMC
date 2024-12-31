package com.project4.BGMC.mapper.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project4.BGMC.dto.RegionResponseDto;
import com.project4.BGMC.entity.masterentity.State;
import com.project4.BGMC.mapper.DtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StateMapper implements DtoMapper<State, RegionResponseDto> {

    @Override
    public RegionResponseDto toDto(State entity) throws JsonProcessingException {
        return null;
    }

    @Override
    public State toEntity(RegionResponseDto dto) {
        return null;
    }

    @Override
    public Set<RegionResponseDto> toDtoSet(Set<State> entityList) {
        return Set.of();
    }

    @Override
    public Set<State> toEntitySet(Set<RegionResponseDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<RegionResponseDto> toDtoList(List<State> entityList) {
        return entityList.stream()
                .map(
                        state -> RegionResponseDto.builder()
                                .regionId(state.getId())
                                .regionName(state.getName())
                                .build()
                ).collect(Collectors.toList());

    }

    @Override
    public List<State> toEntityList(List<RegionResponseDto> dtoList) {
        return List.of();
    }
}

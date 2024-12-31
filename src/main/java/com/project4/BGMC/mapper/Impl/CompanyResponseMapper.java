package com.project4.BGMC.mapper.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project4.BGMC.dto.CompanyResponseDto;
import com.project4.BGMC.entity.wlc.Company;
import com.project4.BGMC.mapper.DtoMapper;
import com.project4.BGMC.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyResponseMapper implements DtoMapper<Company, CompanyResponseDto> {

    private final CityRepository cityRepository;

    @Override
    public CompanyResponseDto toDto(Company entity) throws JsonProcessingException {
        return null;
    }

    @Override
    public Company toEntity(CompanyResponseDto dto) {
        return null;
    }

    @Override
    public Set<CompanyResponseDto> toDtoSet(Set<Company> entityList) {
        return Set.of();
    }

    @Override
    public Set<Company> toEntitySet(Set<CompanyResponseDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<CompanyResponseDto> toDtoList(List<Company> entityList) {
        return entityList.stream().map(
                company -> CompanyResponseDto.builder().companyName(company.getCompanySchemaName().toUpperCase())
                        .primaryEmail(company.getCompanyEmail())
                        .city(cityRepository.findById(company.getCitiList().get(0)).get().getName())
                        .companyId(company.getCompanyId())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<Company> toEntityList(List<CompanyResponseDto> dtoList) {
        return List.of();
    }
}

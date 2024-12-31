package com.project4.BGMC.service.impl;

import com.project4.BGMC.dto.RegionResponseDto;
import com.project4.BGMC.entity.masterentity.City;
import com.project4.BGMC.entity.masterentity.District;
import com.project4.BGMC.entity.masterentity.State;
import com.project4.BGMC.mapper.Impl.CityMapper;
import com.project4.BGMC.mapper.Impl.DistrictMapper;
import com.project4.BGMC.mapper.Impl.StateMapper;
import com.project4.BGMC.repository.CityRepository;
import com.project4.BGMC.repository.DistrictRepository;
import com.project4.BGMC.repository.StateRepository;
import com.project4.BGMC.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegionServiceImpl implements RegionService {
    private final StateRepository stateRepository;
    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;
    private final StateMapper stateMapper;
    private final DistrictMapper districtMapper;
    private final CityMapper cityMapper;

    @Override
    public List<RegionResponseDto> getAllStates() {
        List<State> stateList = stateRepository.findAll();
        return stateMapper.toDtoList(stateList);
    }

    @Override
    public List<RegionResponseDto> getDistrictByState(Long id) {
        List<District> districtList =  districtRepository.findByStateId(id);
        return districtMapper.toDtoList(districtList);
    }

    @Override
    public List<RegionResponseDto> getCityByDistrict(Long districtId, Long stateId) {
        List<City> cityList =  cityRepository.findByDistrictIdAndStateId(districtId,stateId);
        return cityMapper.toDtoList(cityList);
    }
}

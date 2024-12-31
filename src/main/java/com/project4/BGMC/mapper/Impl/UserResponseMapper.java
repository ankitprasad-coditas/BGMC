package com.project4.BGMC.mapper.Impl;

import com.project4.BGMC.dto.UserResponseDto;
import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.mapper.DtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UserResponseMapper implements DtoMapper<User, UserResponseDto> {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole() != null ? user.getRole().getName() : null);
        dto.setProfilePicPath(user.getProfilePicPath());
        dto.setStateId(user.getStateId());
        dto.setDistrictId(user.getDistrictId());
        dto.setCityId(user.getCityId());
        dto.setCompanyId(user.getCompanyId());
        dto.setDeleted(user.isDeleted());
        return dto;
    }

    @Override
    public User toEntity(UserResponseDto userResponseDto) {
        return null;
    }

    @Override
    public Set<UserResponseDto> toDtoSet(Set<User> entityList) {
        return Set.of();
    }

    @Override
    public Set<User> toEntitySet(Set<UserResponseDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<UserResponseDto> toDtoList(List<User> entityList) {
        return List.of();
    }

    @Override
    public List<User> toEntityList(List<UserResponseDto> dtoList) {
        return List.of();
    }

}

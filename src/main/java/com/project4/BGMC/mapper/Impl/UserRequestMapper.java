package com.project4.BGMC.mapper.Impl;

import com.project4.BGMC.dto.UserRequestDto;
import com.project4.BGMC.entity.masterentity.User;
import com.project4.BGMC.mapper.DtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UserRequestMapper implements DtoMapper<User, UserRequestDto> {
    @Override
    public UserRequestDto toDto(User entity) {
        return null;
    }

    @Override
    public User toEntity(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
//        user.setRole(role);
        user.setProfilePicPath(userRequestDto.getProfilePicturePath());
        user.setStateId(userRequestDto.getStateId());
        user.setDistrictId(userRequestDto.getDistrictId());
        user.setCityId(userRequestDto.getCityId());
        user.setDeleted(userRequestDto.isDeleted());
        return user;
    }

    @Override
    public Set<UserRequestDto> toDtoSet(Set<User> entityList) {
        return Set.of();
    }

    @Override
    public Set<User> toEntitySet(Set<UserRequestDto> dtoList) {
        return Set.of();
    }

    @Override
    public List<UserRequestDto> toDtoList(List<User> entityList) {
        return List.of();
    }

    @Override
    public List<User> toEntityList(List<UserRequestDto> dtoList) {
        return List.of();
    }
}

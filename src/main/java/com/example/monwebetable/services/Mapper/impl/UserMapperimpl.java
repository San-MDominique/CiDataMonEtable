package com.example.monwebetable.services.Mapper.impl;

import com.example.monwebetable.models.User;
import com.example.monwebetable.services.DTO.UserDTO;
import com.example.monwebetable.services.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapperimpl implements UserMapper {

    private final ModelMapper modelMapper;
    @Override
    public UserDTO toDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}

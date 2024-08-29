package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.User;
import com.example.monwebetable.repositories.UserRepository;
import com.example.monwebetable.services.DTO.UserDTO;
import com.example.monwebetable.services.Mapper.UserMapper;
import com.example.monwebetable.services.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository  userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save User: {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return userRepository.findById(id).map(user ->{
            return userMapper.toDto(user);
        } );
    }

    @Override
    public UserDTO upade(UserDTO userDTO) {
        return findOne(userDTO.getId()).map(existingUser -> {
            existingUser.setPseudo(userDTO.getPseudo());
            existingUser.setPassword(userDTO.getPassword());
            return save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException("User not found with id " + userDTO.getId()));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> {
            return userMapper.toDto(user);
        }).toList();
    }

    @Override
    public void delete(Long id) {

    }
}


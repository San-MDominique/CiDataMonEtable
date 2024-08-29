package com.example.monwebetable.services;

import com.example.monwebetable.models.User;
import com.example.monwebetable.services.DTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserDTO user);
    Optional<UserDTO> findOne(Long id);

    UserDTO upade(UserDTO user);

    List<UserDTO> findAll();
    void delete(Long id);
}

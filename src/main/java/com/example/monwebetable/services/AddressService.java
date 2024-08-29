package com.example.monwebetable.services;

import com.example.monwebetable.services.DTO.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressDTO save(AddressDTO address);
    Optional<AddressDTO>findOne(Long id);
    AddressDTO upade(AddressDTO address);

    List<AddressDTO> findAll();

    void delete(Long id);

}

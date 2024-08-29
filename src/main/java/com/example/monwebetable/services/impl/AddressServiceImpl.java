package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.Address;
import com.example.monwebetable.repositories.AdressRepository;
import com.example.monwebetable.services.AddressService;
import com.example.monwebetable.services.DTO.AddressDTO;
import com.example.monwebetable.services.Mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AdressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("request to save: {}", addressDTO);
        Address address = addressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    @Override
    public Optional<AddressDTO> findOne(Long id) {
        return addressRepository.findById(id).map(address -> {
            return addressMapper.toDto(address);
        });
    }

    @Override
    public AddressDTO upade(AddressDTO AddressDTO) {
        return findOne(AddressDTO.getId()).map(existingAdress -> {
            existingAdress.setCountry(AddressDTO.getCountry());
            existingAdress.setCity(AddressDTO.getCity());
            return save(existingAdress);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream().map(address -> {
            return addressMapper.toDto(address);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        if (addressRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found with id " + id);
        }
        addressRepository.deleteById(id);
    }
}

package com.example.monwebetable.services.Mapper.impl;

import com.example.monwebetable.models.Address;
import com.example.monwebetable.services.DTO.AddressDTO;
import com.example.monwebetable.services.Mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapperimpl implements AddressMapper {
    private final ModelMapper modelMapper;
    @Override
    public AddressDTO toDto(Address entity) {
        return modelMapper.map(entity, AddressDTO.class);
    }

    @Override
    public Address toEntity(AddressDTO dto) {
        return modelMapper.map(dto, Address.class);
    }
}

package com.example.monwebetable.services.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class AddressDTO {
    private Long id;

    private String country;

    private String city;

    private String street;

}

package com.example.monwebetable.services.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDTO {

        private Long id;

        private String pseudo;

        private String password;

        private Instant creationDate=Instant.now();

    }


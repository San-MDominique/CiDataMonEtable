package com.example.monwebetable.services.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonneDTO {
    private Long id;

    private String nom;
    private String prenom;
    private String telephone;
    private String ville;

    private Date dateNaissance;
}

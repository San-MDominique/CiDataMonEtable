package com.example.monwebetable.services.DTO;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO  extends PersonneDTO{

    private String classe;
    private String matricule;

}

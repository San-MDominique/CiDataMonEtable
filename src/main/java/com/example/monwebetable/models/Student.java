package com.example.monwebetable.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends Personne{


    @Column(name = "classe")
    private String classe;

    @Column(name = "matricule")
    private String matricule;

}


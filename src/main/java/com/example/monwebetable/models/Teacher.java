package com.example.monwebetable.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher  extends Personne{


    @Column(name = "vacant")
    private boolean vacant;

    @Column(name = "matiereEnseigne")
    private String matiereEnseigne;

    @Column(name = "prochainCours")
    private String prochainCours;

    @Column(name = "sujetProchaineReunion")
    private String sujetProchaineReunion;




}

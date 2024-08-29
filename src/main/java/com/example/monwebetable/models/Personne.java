package com.example.monwebetable.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    private String nom;
    private String prenom;
    private String telephone;
    private String ville;

    @DateTimeFormat( pattern = "yyyy-MM-dd")
    @Column(name = "date_naissance")
    private Date dateNaissance;

    @OneToOne (cascade = CascadeType.ALL)
    private Address address;


}
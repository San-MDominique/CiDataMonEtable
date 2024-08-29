package com.example.monwebetable.models;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pseudo", unique = true, nullable = false)
    private String pseudo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "creation-date", nullable = false)
    private Instant creationDate=Instant.now();

}
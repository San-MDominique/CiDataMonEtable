package com.example.monwebetable.repositories;

import com.example.monwebetable.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
}

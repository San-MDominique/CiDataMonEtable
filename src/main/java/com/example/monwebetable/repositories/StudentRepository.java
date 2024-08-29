package com.example.monwebetable.repositories;

import com.example.monwebetable.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student,Long> {
}

package com.example.monwebetable.repositories;

import com.example.monwebetable.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository <Teacher,Long> {
}

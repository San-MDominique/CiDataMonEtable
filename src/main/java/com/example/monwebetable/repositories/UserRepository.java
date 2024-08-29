package com.example.monwebetable.repositories;

import com.example.monwebetable.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

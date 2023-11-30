package com.example.financialflowback.repository;

import com.example.financialflowback.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    public User findByUsername(String username);
}

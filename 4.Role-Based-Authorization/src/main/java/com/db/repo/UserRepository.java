package com.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.db.entites.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer>{
    
    public User findByEmail(String email);
}

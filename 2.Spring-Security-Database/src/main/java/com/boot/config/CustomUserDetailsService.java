package com.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.boot.entity.Employee;
import com.boot.repo.EmpRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmpRepository repository; 

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee emp = repository.findByEmail(email);
        if (emp == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUser(emp);
    }
}

package com.example.web.services;

import com.example.web.dtos.UserAppDto;
import com.example.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String rawPassword, String email) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (!email.contains("@") || !email.contains(".") || email.length() < 6 || email == null) {
            throw new IllegalArgumentException("Invalid email address");

        }
        if(rawPassword.length() < 6 || rawPassword.length() > 20) {
            throw new IllegalArgumentException("Password must be between 6 and 20 characters");
        }
        UserAppDto user = new UserAppDto();
        user.setUsername(username);
        user.setEmail(email);  // Added email
        user.setPassword(passwordEncoder.encode(rawPassword));  // Encoding the password
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAppDto user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()  // Role mapping
        );
    }

}

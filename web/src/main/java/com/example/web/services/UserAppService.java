package com.example.web.services;

import com.example.web.dtos.UserAppDto;
import com.example.web.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class UserAppService implements UserDetailsService {

    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String rawPassword, String email) {
        if (userAppRepository.findByUsername(username).isPresent()) {
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
        userAppRepository.save(user);
    }

    public void deleteUser(Integer id_user_app) {
        userAppRepository.deleteUser(id_user_app);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAppDto user = userAppRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new UserAppDto(
                user.getId_user_app(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                List.of()
        );
    }


}

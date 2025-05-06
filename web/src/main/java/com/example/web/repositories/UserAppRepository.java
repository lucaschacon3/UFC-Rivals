package com.example.web.repositories;

import com.example.web.dtos.UserAppDto;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserAppRepository {

    private final JdbcClient jdbcClient;

    public UserAppRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Optional<UserAppDto> findByUsername(String username) {
        return jdbcClient.sql("SELECT username,email, password FROM user_app WHERE username = ?")
                .params(List.of(username))
                .query(UserAppDto.class)
                .list()
                .stream()
                .findFirst();
    }


    public void save(UserAppDto user) {
        jdbcClient.sql("""
                            INSERT INTO user_app (username, email, password)
                            VALUES (?, ?, ?)
                        """)
                .params(List.of(
                        user.getUsername(),
                        user.getEmail(),
                        user.getPassword()
                ))
                .update();
    }

}


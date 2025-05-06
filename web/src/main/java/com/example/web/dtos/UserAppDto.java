package com.example.web.dtos;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "user_app")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAppDto {

    private Integer id_user_app;
    private String username;
    private String email;
    private String password;

}


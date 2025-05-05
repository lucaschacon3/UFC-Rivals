package com.example.web.security;

import com.example.web.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;  // Injecting CustomUserDetailsService

    @Bean
    @Order(1)
    public SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher(new AntPathRequestMatcher("/h2-console/**"))
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().disable());
        return http.build();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/","/login", "/register", "/h2-console/**", "/fighters", "/ranking", "/css/**", "/img/**", "/fonts/**", "/fragments/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")  // Custom login page
                        .loginProcessingUrl("/login")  // URL for handling login requests
                        .defaultSuccessUrl("/user", true)  // Redirect to /user upon successful login
                        .failureUrl("/login?error=true")  // Redirect to login with error message on failure
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // URL for logging out
                        .logoutSuccessUrl("/login?logout=true")  // Redirect after logout
                        .permitAll()
                )
                .oauth2Login(oauth -> oauth
                        .loginPage("/login")
                        .defaultSuccessUrl("/user", true)
                )
                .userDetailsService(userDetailsService)  // Ensure that UserDetailsService is used
                .csrf().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoder for hashing passwords
    }
}


package com.example.web.repositories;


import com.example.web.entities.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<Fighter, Integer> {
}

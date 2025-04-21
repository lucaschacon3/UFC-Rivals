package com.example.web.repositories;


import com.example.web.entities.Fighter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, Integer> {

    List<Fighter> findByRankingBetween(int start, int end);

    Page<Fighter> findByNameContainingIgnoreCaseOrNicknameContainingIgnoreCase(String name, String nickname, Pageable pageable);

}


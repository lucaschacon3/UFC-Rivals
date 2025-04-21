package com.example.web.services;

import com.example.web.entities.Fighter;
import com.example.web.repositories.FighterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public Page<Fighter> findAll(Pageable pageable) {
        return fighterRepository.findAll(pageable);
    }


    public List<Fighter> findByRankingBetween() {
        return fighterRepository.findByRankingBetween(0,15);
    }

    public Page<Fighter> findFilteredAndSorted(String search, String sort, Pageable pageable) {
        Sort sortOrder = switch (sort) {
            case "weightAsc" -> Sort.by("weight").ascending();
            case "weightDesc" -> Sort.by("weight").descending();
            case "total_wins" -> Sort.by("total_wins").descending();
            case "wins_ko" -> Sort.by("wins_ko").descending();
            default -> Sort.unsorted();
        };

        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortOrder);

        if (search != null && !search.isBlank()) {
            return fighterRepository.findByNameContainingIgnoreCaseOrNicknameContainingIgnoreCase(search, search, pageable);

        } else {
            return fighterRepository.findAll(sortedPageable);
        }
    }

}

package com.example.web.controllers;

import com.example.web.entities.Fighter;
import com.example.web.services.FighterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UFCRivalsController {

    private final FighterService fighterService;

    public UFCRivalsController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("page", "home");
        return "home";
    }

    @GetMapping("/fighters")
    public String listFighters(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "16") int size,
                               @RequestParam(defaultValue = "") String search,
                               @RequestParam(defaultValue = "") String sort) {

        Page<Fighter> fightersPage = fighterService.findFilteredAndSorted(search, sort, PageRequest.of(page, size));

        model.addAttribute("fighters", fightersPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", fightersPage.getTotalPages());
        model.addAttribute("search", search);
        model.addAttribute("sort", sort);
        model.addAttribute("page", "fighters");

        return "fighters";
    }



    @GetMapping("/ranking")
    public String ranking(Model model) {
        model.addAttribute("page", "ranking");
        model.addAttribute("fighters", fighterService.findByRankingBetween());
        return "ranking";
    }

    @GetMapping("/simulator")
    public String simulator(Model model) {
        model.addAttribute("page", "simulator");
        return "simulator";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("page", "user");
        return "user";
    }
}

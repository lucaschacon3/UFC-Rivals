package com.example.web.controllers;

import com.example.web.services.FighterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String mostrarFighters(Model model) {
        model.addAttribute("fighters", fighterService.findAll());
        model.addAttribute("page", "fighters"); // por si usas nav activo
        return "fighters"; // Se refiere a templates/fighters.html
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        model.addAttribute("page", "ranking");
        model.addAttribute("fighters", fighterService.findAll());
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

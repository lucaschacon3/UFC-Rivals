package com.example.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UFCRivalsController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("page", "home");
        return "home";
    }

    @GetMapping("/fighters")
    public String fighters(Model model) {
        model.addAttribute("page", "fighters");
        return "fighters";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        model.addAttribute("page", "ranking");
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

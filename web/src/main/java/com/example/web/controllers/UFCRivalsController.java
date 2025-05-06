package com.example.web.controllers;

import com.example.web.dtos.FighterDto;
import com.example.web.dtos.UserAppDto;
import com.example.web.services.FighterService;
import com.example.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class UFCRivalsController {

    private final FighterService fighterService;

    public UFCRivalsController(FighterService fighterService) {
        this.fighterService = fighterService;
    }
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Página de login (HTML)
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           Model model) {

        model.addAttribute("username", username);
        model.addAttribute("email", email);
        try {
            userService.registerUser(username, password, email);  // Passing all parameters
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";  // Returning error if registration fails
        }
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("page", "home");
        return "home";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("page", "home");
        return "home";
    }

    @GetMapping("/fighters")
    public String listFighters(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "16") int size,
                               @RequestParam(defaultValue = "") String search,
                               @RequestParam(defaultValue = "") String sort) {

        Page<FighterDto> fightersPage = fighterService.findFilteredAndSorted(search, sort, PageRequest.of(page, size));


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
    public String showSimulator(Model model,
                                @RequestParam(required = false) String category,
                                @RequestParam(required = false) Integer fighter1Id,
                                @RequestParam(required = false) Integer fighter2Id) {

        if (category != null) {
            model.addAttribute("category_selected", category);
        }else{
            model.addAttribute("category_selected", "select category");
        }

        if (category != null) {
            model.addAttribute("fighters", fighterService.findFightersByCategory(category));
        }

        if (fighter1Id != null && fighter2Id != null) {
            List<FighterDto> fighter1List = fighterService.findByIdFighter(fighter1Id);
            List<FighterDto> fighter2List = fighterService.findByIdFighter(fighter2Id);

            if (!fighter1List.isEmpty() && !fighter2List.isEmpty()) {
                FighterDto fighter1 = fighter1List.get(0);
                FighterDto fighter2 = fighter2List.get(0);

                model.addAttribute("fighter1", fighter1);
                model.addAttribute("fighter2", fighter2);

            } else {
                model.addAttribute("error", "No se encontraron los peleadores.");
            }
        }

        return "simulator";
    }


    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("page", "user");
        return "user";
    }

    @GetMapping("/favorites")
    public String favorites(Model model) {
        model.addAttribute("page", "user");
        return "favorites";
    }
}

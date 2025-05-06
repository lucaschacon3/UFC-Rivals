package com.example.web.controllers;

import com.example.web.dtos.FavFightDto;
import com.example.web.dtos.FighterDto;
import com.example.web.dtos.UserAppDto;
import com.example.web.repositories.FavFightRepository;
import com.example.web.services.FighterService;
import com.example.web.services.UserAppService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UFCRivalsController {


    private final UserAppService userService;
    private final FighterService fighterService;
    private final FavFightRepository favFightRepository;


    public UFCRivalsController(UserAppService userService, FighterService fighterService, FavFightRepository favFightRepository) {
        this.userService = userService;
        this.fighterService = fighterService;
        this.favFightRepository = favFightRepository;
    }



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
                                @RequestParam(required = false) Integer fighter2Id,
                                @AuthenticationPrincipal UserAppDto userApp) {


        if (userApp != null) {
            model.addAttribute("id_user_app", userApp.getId_user_app());
        }

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


    @PostMapping("/simulator/save")
    @ResponseBody
    public ResponseEntity<?> saveFight(@RequestBody FavFightDto favFightDto) {
        FavFightDto favFight = new FavFightDto();
        favFight.setId_user(favFightDto.getId_user());
        favFight.setId_fighter1(favFightDto.getId_fighter1());
        favFight.setId_fighter2(favFightDto.getId_fighter2());
        favFight.setPercentage_f1(favFightDto.getPercentage_f1());
        favFight.setPercentage_f2(favFightDto.getPercentage_f2());;

        favFightRepository.save(favFight);
        return ResponseEntity.ok("Fight saved");
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

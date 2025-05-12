package com.example.web.controllers;

import com.example.web.dtos.FavFightDto;
import com.example.web.dtos.FighterDto;
import com.example.web.dtos.UserAppDto;
import com.example.web.services.FavFightService;
import com.example.web.services.FighterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class SimulatorController {

    private final FighterService fighterService;
    private final FavFightService favFightService;

    public SimulatorController(FighterService fighterService, FavFightService favFightService) {
        this.fighterService = fighterService;
        this.favFightService = favFightService;
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
        } else {
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
        favFight.setPercentage_f2(favFightDto.getPercentage_f2());
        favFight.setDate_fight(favFightDto.getDate_fight());
        ;

        favFightService.save(favFight);
        return ResponseEntity.ok("Fight saved");
    }

}

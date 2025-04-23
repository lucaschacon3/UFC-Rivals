package com.example.web.controllers;

import com.example.web.entities.Fighter;
import com.example.web.services.ChartService;
import com.example.web.services.FighterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class UFCRivalsController {

    private final FighterService fighterService;
    private final ChartService chartService;

    public UFCRivalsController(FighterService fighterService, ChartService chartService) {
        this.fighterService = fighterService;
        this.chartService = chartService;
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



    @GetMapping("/simulator")
    public String showSimulator(Model model,
                                @RequestParam(required = false) String category,
                                @RequestParam(required = false) Integer fighter1Id,
                                @RequestParam(required = false) Integer fighter2Id) {

        if (category != null) {
            model.addAttribute("fighters", fighterService.findFightersByCategory(category));
        }

        if (fighter1Id != null && fighter2Id != null) {
            List<Fighter> fighter1List = fighterService.findByIdFighter(fighter1Id);
            List<Fighter> fighter2List = fighterService.findByIdFighter(fighter2Id);

            if (!fighter1List.isEmpty() && !fighter2List.isEmpty()) {
                Fighter fighter1 = fighter1List.get(0);
                Fighter fighter2 = fighter2List.get(0);

                try {
                    // Generar los gráficos y obtener las rutas relativas
                    String chart1Path = chartService.generateRadarChart(fighter1, fighter2, "chart_" + fighter1.getIdFighter()+fighter2.getIdFighter() + ".png");


                    // Agregar rutas de imagen al modelo
                    model.addAttribute("chart", chart1Path);
                    model.addAttribute("fighter1", fighter1);
                    model.addAttribute("fighter2", fighter2);
                } catch (IOException e) {
                    model.addAttribute("error", "Error generando los gráficos.");
                }

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
}

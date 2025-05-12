package com.example.web.controllers;

import com.example.web.dtos.UserAppDto;
import com.example.web.services.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    private final UserAppService userService;

    public UserController(UserAppService userService) {
        this.userService = userService;
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

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("page", "home");
        return "home";
    }


    @GetMapping("/user")
    public String user(Model model, @AuthenticationPrincipal UserAppDto userApp) {
        model.addAttribute("id_user_app", userApp.getId_user_app());
        model.addAttribute("page", "user");
        return "user";
    }

    @PostMapping("/user/delete")
    @ResponseBody
    public ResponseEntity<Void> deleteAccount(@AuthenticationPrincipal UserAppDto userApp) {
        userService.deleteUser(userApp.getId_user_app());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/details")
    public String userDetails(Model model, @RequestParam(required = false) String new_username,
                              @RequestParam(required = false) String new_email,
                              @RequestParam(required = false) String current_password,
                              @RequestParam(required = false) String new_password,
                              @RequestParam(required = false) String confirm_new_password) {

        model.addAttribute("new_username", new_username);
        model.addAttribute("new_email", new_email);
        model.addAttribute("current_password", current_password);
        model.addAttribute("new_password", new_password);
        model.addAttribute("confirm_new_password", confirm_new_password);
        model.addAttribute("page", "user");
        return "user_details";
    }

}

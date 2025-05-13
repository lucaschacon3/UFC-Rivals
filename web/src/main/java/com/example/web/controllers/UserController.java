package com.example.web.controllers;

import com.example.web.dtos.UserAppDto;
import com.example.web.services.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {


    private final UserAppService userService;

    public UserController(UserAppService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
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

    @PostMapping("/user/update")
    @ResponseBody
    public ResponseEntity<String> updateAccount(@AuthenticationPrincipal UserAppDto userApp, @RequestBody Map<String, Object> payload) {
        String new_username = (String) payload.get("new_username");
        String new_email = (String) payload.get("new_email");
        String new_password = (String) payload.get("new_password");
        String confirm_new_password = (String) payload.get("confirm_new_password");

        try {
            userService.updateUser(userApp,new_username, new_email, new_password, confirm_new_password);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

}

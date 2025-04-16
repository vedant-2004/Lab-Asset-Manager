package com.college.labassetmanager.controller;

import com.college.labassetmanager.model.User;
import com.college.labassetmanager.model.User.Role;
import com.college.labassetmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    //GET Home Page
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    // GET Signup Page
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    // POST Signup Form
    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user, Model model) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already registered.");
            return "signup";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login";
    }

    // GET Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}

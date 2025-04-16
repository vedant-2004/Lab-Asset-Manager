package com.college.labassetmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboardRedirect(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Get user role and redirect accordingly
        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_TECHNICAL_PERSON"))) {
            return "dashboard/technical_person";
        } else if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ASSISTANT"))) {
            return "dashboard/assistant";
        } else if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_COORDINATOR"))) {
            return "dashboard/coordinator";
        }

        return "redirect:/login";
    }
}

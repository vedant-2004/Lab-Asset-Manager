package com.college.labassetmanager.controller;

import com.college.labassetmanager.model.Lab;
import com.college.labassetmanager.repository.service.LabService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/labs")
@RequiredArgsConstructor
public class LabController {

    private final LabService labService;

    public LabController(LabService labService) {
        this.labService = labService;
    }

    // ✅ View All Labs
    @GetMapping
    public String viewLabs(Model model) {
        model.addAttribute("labs", labService.getAllLabs());
        model.addAttribute("newLab", new Lab()); // For inline add form
        return "dashboard/coordinator";
    }

    // ✅ Add New Lab
    @PostMapping("/add")
    public String addLab(@ModelAttribute("newLab") Lab lab) {
        labService.saveLab(lab);
        return "redirect:/labs";
    }

    // ✅ Show Edit Lab Form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Lab lab = labService.getLabById(id);
        if (lab == null) {
            return "redirect:/labs"; // fallback if lab not found
        }
        model.addAttribute("lab", lab);
        return "dashboard/edit-lab";
    }

    // ✅ Update Lab
    @PostMapping("/edit/{id}")
    public String updateLab(@PathVariable Long id, @ModelAttribute("lab") Lab updatedLab) {
        updatedLab.setId(Math.toIntExact(id));
        labService.saveLab(updatedLab);
        return "redirect:/labs";
    }

    // ✅ Delete Lab
    @GetMapping("/delete/{id}")
    public String deleteLab(@PathVariable Long id) {
        labService.deleteLab(id);
        return "redirect:/labs";
    }
}

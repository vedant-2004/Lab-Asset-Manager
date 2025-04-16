package com.college.labassetmanager.controller;

import com.college.labassetmanager.model.Asset;
import com.college.labassetmanager.repository.AssetRepository;
import com.college.labassetmanager.repository.LabRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/assets")
public class AssetController {

    private final AssetRepository assetRepository;
    private final LabRepository labRepository;

    @GetMapping
    public String allAssets(Model model) {
        model.addAttribute("assets", assetRepository.findAll());
        model.addAttribute("labs", labRepository.findAll());
        return "coordinator/assets";
    }

    @PostMapping("/add")
    public String addAsset(@ModelAttribute Asset asset) {
        assetRepository.save(asset);
        return "redirect:/assets";
    }

    @PostMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Integer id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
        asset.setStatus(Asset.Status.DELETED);
        assetRepository.save(asset);
        return "redirect:/assets";
    }


}


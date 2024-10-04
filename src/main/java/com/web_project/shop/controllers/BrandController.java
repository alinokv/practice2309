package com.web_project.shop.controllers;

import com.web_project.shop.model.BrandModel;
import com.web_project.shop.service.BrandServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandServiceIMPL brandService;

    @GetMapping("/all")
    public String getAllBrands(Model model) {
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("brand", new BrandModel());
        return "brandList";
    }

    @PostMapping("/add")
    public String addBrand(@Valid @ModelAttribute("brand") BrandModel brand, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            return "brandList";
        }
        brandService.add(brand);
        return "redirect:/brands/all";
    }

    @PostMapping("/update")
    public String updateBrand(@Valid @ModelAttribute("brand") BrandModel brand, BindingResult result) {
        if (result.hasErrors()) {
            return "brandList";
        }
        brandService.update(brand);
        return "redirect:/brands/all";
    }

    @PostMapping("/delete")
    public String deleteBrand(@RequestParam UUID id) {
        brandService.delete(id);
        return "redirect:/brands/all";
    }

    @GetMapping("/all/{id}")
    public String getBrandById(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("brand", brandService.findById(id));
        return "brandList";
    }
}

package com.web_project.shop.controllers;

import com.web_project.shop.model.SupplierModel;

import com.web_project.shop.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/suppliers")
//@PreAuthorize("hasAnyAuthority('MODERATOR')")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/all")
    public String getAllSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("supplier", new SupplierModel());
        return "supplierList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/add")
    public String addSupplier(@Valid @ModelAttribute("supplier") SupplierModel supplier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("suppliers", supplierService.findAll());
            return "supplierList";
        }
        supplierService.add(supplier);
        return "redirect:/suppliers/all";
    }

    @GetMapping("/edit/{id}")
    public String getSupplierForEdit(@PathVariable UUID id, Model model) {
        SupplierModel supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "editSupplier"; // Переход на страницу редактирования
    }

    @PostMapping("/update")
    public String updateSupplier(@Valid @ModelAttribute("supplier") SupplierModel supplier, BindingResult result) {
        if (result.hasErrors()) {
            return "editSupplier"; // Если есть ошибки, возвращаемся на страницу редактирования
        }
        supplierService.update(supplier);
        return "redirect:/suppliers/all";
    }

    @PostMapping("/delete")
    public String deleteSupplier(@RequestParam UUID id) {
        supplierService.delete(id);
        return "redirect:/suppliers/all";
    }
}

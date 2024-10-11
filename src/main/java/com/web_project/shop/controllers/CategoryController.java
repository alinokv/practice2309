package com.web_project.shop.controllers;

import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.service.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", new CategoryModel());
        return "categoryList";
    }

    @GetMapping("/edit/{id}")
    public String getCategoryForEdit(@PathVariable UUID id, Model model) {
        CategoryModel category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "editCategory"; // Страница для редактирования
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") CategoryModel category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "categoryList";
        }
        categoryService.add(category);
        return "redirect:/categories/all";
    }

    @PostMapping("/update")
    public String updateCategory(@Valid @ModelAttribute("category") CategoryModel category, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/categories/all"; // Возвращаем на страницу, если есть ошибки
        }
        categoryService.update(category);
        return "redirect:/categories/all";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam UUID id) {
        categoryService.delete(id);
        return "redirect:/categories/all";
    }
}

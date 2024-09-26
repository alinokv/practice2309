package com.web_project.shop.controllers;

import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categoryList";
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam String Name,
                             @RequestParam String Description) {
        CategoryModel newCategory = new CategoryModel(0, Name, Description);
        categoryService.addCategory(newCategory);
        return "redirect:/categories/all";
    }

    @PostMapping("/update")
    public String updateCategory(@RequestParam int id,
                                @RequestParam String Name,
                                @RequestParam String Description) {
        CategoryModel updateCategory = new CategoryModel(id, Name, Description);
        categoryService.updateCategory(updateCategory);
        return "redirect:/categories/all";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories/all";
    }

    @GetMapping("/all/{id}")
    public String getIdCategory(@PathVariable("id") int id, Model model) {
        model.addAttribute("categories", categoryService.findCategoryById(id));
        return "categoryList";
    }
}

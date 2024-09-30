/*
package com.web_project.shop.controllers;

import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.model.ProductModel;
import com.web_project.shop.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("category", new CategoryModel());
        return "categoryList";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") CategoryModel category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", categoryService.findAllCategories());
            return "categoryList";
        }
        categoryService.addCategory(category);
        return "redirect:/categories/all";
    }

    @PostMapping("/update")
    public String updateCategory(@Valid @ModelAttribute("category") CategoryModel category, BindingResult result) {
        categoryService.updateCategory(category);
        return "redirect:/categories/all";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories/all";
    }

    @GetMapping("/all/{id}")
    public String getIdCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categories", categoryService.findCategoryById(id));
        model.addAttribute("category", new CategoryModel());
        return "categoryList";
    }
}
*/
package com.web_project.shop.controllers;

import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.service.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        categoryService.update(category);
        return "redirect:/categories/all";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam Long id) {
        categoryService.delete(id);
        return "redirect:/categories/all";
    }

    @GetMapping("/all/{id}")
    public String getCategoryById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categories", categoryService.findById(id));
        model.addAttribute("category", new CategoryModel());
        return "categoryList";
    }
}

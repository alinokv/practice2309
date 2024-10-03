package com.web_project.shop.controllers;

import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.model.ProductModel;
import com.web_project.shop.model.TagModel;
import com.web_project.shop.service.CategoryService;
import com.web_project.shop.service.ProductService;
import com.web_project.shop.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public TagService tagService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("product", new ProductModel());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "productList";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("tags", tagService.findAll());
            return "productList";
        }
        productService.add(product);
        return "redirect:/products/all";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/all";
        }
        productService.update(product);
        return "redirect:/products/all";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam UUID id) {
        productService.delete(id);
        return "redirect:/products/all";
    }

    @GetMapping("/all/{id}")
    public String getProductById(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "productDetails";
    }
}

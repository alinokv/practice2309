package com.web_project.shop.controllers;

import com.web_project.shop.model.ProductModel;
import com.web_project.shop.service.*;
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
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ReviewService reviewService;

    // Отображение всех продуктов
    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("product", new ProductModel());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "productList";  // Страница со списком продуктов
    }

    // Добавление продукта
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("suppliers", supplierService.findAll());
            model.addAttribute("tags", tagService.findAll());
            return "productList";
        }
        productService.add(product);
        return "redirect:/products/all";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") String idString, Model model) {
        try {
            UUID id = UUID.fromString(idString); // Преобразуем строку в UUID
            ProductModel product = productService.findById(id);
            if (product == null) {
                return "redirect:/products/all";  // Если продукт не найден
            }
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("suppliers", supplierService.findAll());
            model.addAttribute("tags", tagService.findAll());
            return "productEdit";  // Страница редактирования продукта
        } catch (IllegalArgumentException e) {
            // Обработка ситуации, когда строка не является корректным UUID
            return "redirect:/products/all"; // Или другой обработчик ошибки
        }
    }


    @GetMapping("/details/{id}")
    public String getProductByIdDetails(@PathVariable("id") String idString, Model model) {
        try {
            UUID id = UUID.fromString(idString);
            ProductModel product = productService.findById(id);
            if (product == null) {
                return "redirect:/products/all";  // Если продукт не найден
            }

            // Получение отзывов для данного продукта
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("suppliers", supplierService.findAll());
            model.addAttribute("tags", tagService.findAll());
            model.addAttribute("reviews", reviewService.findById(id));

            return "productsDetails";  // Страница деталей продукта
        } catch (IllegalArgumentException e) {
            // Обработка ситуации, когда строка не является корректным UUID
            return "redirect:/products/all"; // Или другой обработчик ошибки
        }
    }


    // Обновление продукта
    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/all";
        }
        productService.update(product);
        return "redirect:/products/all";
    }

    // Удаление продукта
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam UUID id) {
        productService.delete(id);
        return "redirect:/products/all";
    }

    // Поиск продукта по имени
    @GetMapping("/search")
    public String searchProductByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("products", productService.findByName(name));
        model.addAttribute("product", new ProductModel());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "productList";
    }
}

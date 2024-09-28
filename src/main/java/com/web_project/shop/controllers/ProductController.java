package com.web_project.shop.controllers;
import com.web_project.shop.model.ProductModel;
import com.web_project.shop.model.StudentModel;
import com.web_project.shop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;

//    @PostMapping("/delete-multiple")
//    public String deleteMultipleProducts(@RequestParam(required = false) List<Integer> productIds) {
//        if (productIds != null && !productIds.isEmpty()) {
//            productService.deleteMultipleProducts(productIds);
//        }
//        return "redirect:/products/all";
//    }


    // Пагинация и получение всех продуктов
    @GetMapping("/all")
    public String getAllProducts(Model model) {
//        List<ProductModel> products = productService.findProductsPaginated(page, size);
//        int totalProducts = productService.countProducts();
//        int totalPages = (int) Math.ceil((double) totalProducts / size);
//
//        model.addAttribute("products", products);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        return "productList";
        model.addAttribute("products", productService.findAllProducts());
        model.addAttribute("product", new ProductModel());
        return "productList";
    }

    // Метод для добавления продукта
    @PostMapping("/add")
    public String addProducts(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model) {
//        ProductModel newProduct = new ProductModel(0, name, price);
//        productService.addProduct(newProduct);
//        return "redirect:/products/all";
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAllProducts());
            return "productList";
        }
        productService.addProduct(product);
        return "redirect:/products/all";

    }
    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
        productService.updateProduct(product);
        return "redirect:/products/all";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "redirect:/products/all";
    }

    @GetMapping("/all/{id}")
    public String getIdProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("products", productService.findProductById(id));
        model.addAttribute("product", new ProductModel());
        return "productList";
    }
}


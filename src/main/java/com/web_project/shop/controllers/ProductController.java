package com.web_project.shop.controllers;
import com.web_project.shop.model.ProductModel;
import com.web_project.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @PostMapping("/delete-multiple")
    public String deleteMultipleProducts(@RequestParam(required = false) List<Integer> productIds) {
        if (productIds != null && !productIds.isEmpty()) {
            productService.deleteMultipleProducts(productIds);
        }
        return "redirect:/products/all";
    }


    // Пагинация и получение всех продуктов
    @GetMapping("/all")
    public String getAllProducts(Model model,
                                 @RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "5") int size) {
        List<ProductModel> products = productService.findProductsPaginated(page, size);
        int totalProducts = productService.countProducts();
        int totalPages = (int) Math.ceil((double) totalProducts / size);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "productList";
    }

    // Метод для добавления продукта
    @PostMapping("/add")
    public String addProducts(@RequestParam String name,
                              @RequestParam double price) {
        ProductModel newProduct = new ProductModel(0, name, price);
        productService.addProduct(newProduct);
        return "redirect:/products/all";
    }

    // Метод для обновления продукта
    @PostMapping("/update")
    public String updateProducts(@RequestParam int id,
                                 @RequestParam String name,
                                 @RequestParam double price) {
        ProductModel updateProduct = new ProductModel(id, name, price);
        productService.updateProduct(updateProduct);
        return "redirect:/products/all";
    }

    // Получение продукта по ID
    @GetMapping("/all/{id}")
    public String getProductID(@PathVariable("id") int id, Model model) {
        model.addAttribute("products", productService.findProductById(id));
        return "productList";
    }
}


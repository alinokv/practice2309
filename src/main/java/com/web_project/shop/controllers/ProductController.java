package com.web_project.shop.controllers;
import com.web_project.shop.model.ProductModel;
import com.web_project.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "productList";
    }

    @PostMapping("/add")
    public String addProducts(@RequestParam String name,
                             @RequestParam double price) {
        ProductModel newProduct = new ProductModel(0, name, price);
        productService.addProduct(newProduct);
        return "redirect:/products/all";
    }

    @PostMapping("/update")
    public String updateProducts(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam double price) {
        ProductModel updateProduct = new ProductModel(id, name, price);
        productService.updateProduct(updateProduct);
        return "redirect:/products/all";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/products/all";
    }

    @GetMapping("/all/{id}")
    public String getProductID(@PathVariable("id") int id, Model model) {
        model.addAttribute("products", productService.findProductById(id));
        return "productList";
    }
}

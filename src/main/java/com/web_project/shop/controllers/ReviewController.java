package com.web_project.shop.controllers;

import com.web_project.shop.model.ReviewModel;
import com.web_project.shop.model.ProductModel;
import com.web_project.shop.model.CustomerModel;
import com.web_project.shop.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    // Получение всех отзывов
    @GetMapping("/all")
    public String getAllReviews(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        model.addAttribute("review", new ReviewModel());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "reviewList";
    }

    // Добавление нового отзыва
    @PostMapping("/add")
    public String addReview(@Valid @ModelAttribute("review") ReviewModel review, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("reviews", reviewService.findAll());
            model.addAttribute("products", productService.findAll());
            model.addAttribute("customers", customerService.findAll());
            return "reviewList";
        }
        reviewService.add(review);
        return "redirect:/reviews/all";
    }

    // Получение отзыва по ID для редактирования
    @GetMapping("/{id}")
    public String getReviewById(@PathVariable("id") UUID id, Model model) {
        ReviewModel review = reviewService.findById(id);
        if (review == null) {
            // Обработка случая, если отзыв не найден
            return "redirect:/reviews/all";
        }
        model.addAttribute("review", review);
        model.addAttribute("products", productService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "reviewEdit"; // Страница редактирования отзыва
    }

    // Обновление отзыва
    @PostMapping("/update")
    public String updateReview(@Valid @ModelAttribute("review") ReviewModel review, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/reviews/all";
        }
        reviewService.update(review);
        return "redirect:/reviews/all";
    }

    // Удаление отзыва
    @PostMapping("/delete")
    public String deleteReview(@RequestParam UUID id) {
        reviewService.delete(id);
        return "redirect:/reviews/all";
    }
}

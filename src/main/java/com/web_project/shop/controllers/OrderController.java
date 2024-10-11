package com.web_project.shop.controllers;

import com.web_project.shop.model.OrderModel;
import com.web_project.shop.service.CustomerService;
import com.web_project.shop.service.OrderService;

import com.web_project.shop.service.ProductService;
import com.web_project.shop.service.ProductServiceImpl; // Импортируем сервис для работы с продуктами
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    // Получение всех заказов
    @GetMapping("/all")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("order", new OrderModel());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("products", productService.findAll());
        return "orderList"; // Название страницы со списком заказов
    }

    // Добавление нового заказа
    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("orders", orderService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("products", productService.findAll());
            return "orderList"; // Возвращаемся на страницу при ошибках
        }
        orderService.add(order);
        return "redirect:/orders/all"; // Перенаправление на список заказов
    }

    // Обновление заказа
    @GetMapping("/edit/{id}")
    public String getOrderForEdit(@PathVariable UUID id, Model model) {
        OrderModel order = orderService.findById(id);
        if (order == null) {
            return "redirect:/orders/all"; // Если заказ не найден, возвращаемся на список
        }
        model.addAttribute("order", order);
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("products", productService.findAll());
        return "editOrder"; // Страница редактирования заказа
    }

    @PostMapping("/update")
    public String updateOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result) {
        if (result.hasErrors()) {
            return "editOrder"; // Если есть ошибки, возвращаемся на страницу редактирования
        }
        orderService.update(order);
        return "redirect:/orders/all"; // Перенаправление на список заказов
    }

    // Удаление заказа
    @PostMapping("/delete")
    public String deleteOrder(@RequestParam UUID id) {
        orderService.delete(id);
        return "redirect:/orders/all"; // Перенаправление на список заказов
    }
}

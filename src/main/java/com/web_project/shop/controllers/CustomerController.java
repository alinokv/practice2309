package com.web_project.shop.controllers;

import com.web_project.shop.model.CustomerModel;
import com.web_project.shop.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/customers")
//@PreAuthorize("hasAnyAuthority('MODERATOR')")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("customer", new CustomerModel());
        return "customerList";
    }

    @PostMapping("/add")
    public String addCustomer(@Valid @ModelAttribute("customer") CustomerModel customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customers", customerService.findAll());
            return "customerList";
        }
        customerService.add(customer);
        return "redirect:/customers/all";
    }

    @GetMapping("/edit/{id}")
    public String getCustomerForEdit(@PathVariable UUID id, Model model) {
        CustomerModel customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "editCustomer"; // Переход на страницу редактирования
    }

    @PostMapping("/update")
    public String updateCustomer(@Valid @ModelAttribute("customer") CustomerModel customer, BindingResult result) {
        if (result.hasErrors()) {
            return "editCustomer"; // Если есть ошибки, возвращаемся на страницу редактирования
        }
        customerService.update(customer);
        return "redirect:/customers/all";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam UUID id) {
        customerService.delete(id);
        return "redirect:/customers/all";
    }
}

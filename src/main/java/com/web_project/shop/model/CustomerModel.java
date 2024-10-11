package com.web_project.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.UUID;

@Entity
public class CustomerModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(min = 3, message = "Имя не менее 3 символов")
    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    @Size(min = 8, message = "Телефон не менее 8 символов")
    private String phone;

    // Связь OneToMany с OrderModel
    @OneToMany(mappedBy = "customer")
    private Set<OrderModel> orders;

    // Связь OneToMany с ReviewModel
    @OneToMany(mappedBy = "customer")
    private Set<ReviewModel> reviews;

    // Конструкторы, геттеры и сеттеры
    public CustomerModel() { }

    public CustomerModel(UUID id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderModel> orders) {
        this.orders = orders;
    }

    public Set<ReviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewModel> reviews) {
        this.reviews = reviews;
    }
}

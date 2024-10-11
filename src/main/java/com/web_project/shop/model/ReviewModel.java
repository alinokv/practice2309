package com.web_project.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class ReviewModel {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private ProductModel product;

    @Min(1)
    @Max(5)
    @NotNull
    private int rating;

    @Size(min = 5, message = "Отзыв должен содержать не менее 5 символов")
    private String comment;

    // Конструкторы, геттеры и сеттеры
    public ReviewModel() { }

    public ReviewModel(UUID id, CustomerModel customer, ProductModel product, int rating, String comment) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

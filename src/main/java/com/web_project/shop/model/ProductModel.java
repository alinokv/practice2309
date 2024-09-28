package com.web_project.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class ProductModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    @NotNull
    private String name;
    @NotNull
    @Positive
    private Double price;
    @Min(1)
    @Max(100)
    @NotNull
    private int quantity;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateorder;

    public ProductModel() {
    }

    public ProductModel(Long id, String name, Double price, int quantity, Date dateorder) {
        Id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dateorder = dateorder;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") @NotNull String getName() {
        return name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") @NotNull String name) {
        this.name = name;
    }

    public @NotNull @Positive Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Positive Double price) {
        this.price = price;
    }

    @Min(1)
    @Max(100)
    @NotNull
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Min(1) @Max(100) @NotNull int quantity) {
        this.quantity = quantity;
    }


    public @PastOrPresent Date getDateorder() {
        return dateorder;
    }

    public void setDateorder(@PastOrPresent Date dateorder) {
        this.dateorder = dateorder;
    }
}

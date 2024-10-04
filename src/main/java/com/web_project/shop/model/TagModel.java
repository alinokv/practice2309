package com.web_project.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.UUID;

@Entity
//@Table(name = "tags")
public class TagModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(min = 3, message = "Имя не менее 3 символов")
    @NotNull
    private String name;

    // Связь ManyToMany с Product
    @ManyToMany(mappedBy = "tags")
    private Set<ProductModel> products;

    // Конструкторы, геттеры и сеттеры
    public TagModel() { }

    public TagModel(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") @NotNull String getName() {
        return name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") @NotNull String name) {
        this.name = name;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }


}

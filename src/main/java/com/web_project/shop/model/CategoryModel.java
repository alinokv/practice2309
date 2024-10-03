package com.web_project.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(min = 3, message = "Имя не менее 3 символов")
    @NotNull
    private String name;

    @Size(min = 3, message = "Описание не менее 3 символов")
    @NotNull
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<ProductModel> products;

    public CategoryModel() {
    }

    public CategoryModel(UUID id, String name, String description, Set<ProductModel> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
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

    public @Size(min = 3, message = "Описание не менее 3 символов") @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 3, message = "Описание не менее 3 символов") @NotNull String description) {
        this.description = description;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductModel> products) {
        this.products = products;
    }
}

package com.web_project.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    @NotNull
    private String name;
    @Size(min = 3, message = "Имя не менее 3 символов")
    @NotNull
    private String description;

    public CategoryModel(){

    }

    public CategoryModel(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") @NotNull String getName() {
        return name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") @NotNull String name) {
        this.name = name;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 3, message = "Имя не менее 3 символов") @NotNull String description) {
        this.description = description;
    }
}

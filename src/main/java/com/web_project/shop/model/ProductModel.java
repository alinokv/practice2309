package com.web_project.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
//@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue
    private UUID Id;

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

    // Связь ManyToOne с Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    // Связь ManyToOne с Brand
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    // Связь ManyToMany с Tag
    @ManyToMany
    @JoinTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagModel> tags;


    public ProductModel() { }

    public ProductModel(UUID id, String name, Double price, int quantity, Date dateorder, CategoryModel category, BrandModel brand, Set<TagModel> tags) {
        Id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dateorder = dateorder;
        this.category = category;
        this.brand = brand;
        this.tags = tags;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
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

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public Set<TagModel> getTags() {
        return tags;
    }

    public void setTags(Set<TagModel> tags) {
        this.tags = tags;
    }
}

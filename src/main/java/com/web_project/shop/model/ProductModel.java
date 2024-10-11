package com.web_project.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class ProductModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(min = 3, message = "Имя не менее 3 символов")
    @NotNull
    private String name;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    private String description;

    private String image;

    @Min(1)
    @Max(100)
    @NotNull
    private int quantity;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOrder;

    // Связь ManyToOne с CategoryModel
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    // Связь ManyToOne с BrandModel
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    // Связь ManyToOne с SupplierModel
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierModel supplier;

    // Связь ManyToMany с TagModel
    @ManyToMany
    @JoinTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagModel> tags;

    // Конструкторы, геттеры и сеттеры
    public ProductModel() { }

    public ProductModel(UUID id, String name, Double price, String description, String image, int quantity, Date dateOrder, CategoryModel category, BrandModel brand, SupplierModel supplier, Set<TagModel> tags) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.dateOrder = dateOrder;
        this.category = category;
        this.brand = brand;
        this.supplier = supplier;
        this.tags = tags;
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

    public @NotNull @Positive Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Positive Double price) {
        this.price = price;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public @PastOrPresent Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(@PastOrPresent Date dateOrder) {
        this.dateOrder = dateOrder;
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

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }

    public Set<TagModel> getTags() {
        return tags;
    }

    public void setTags(Set<TagModel> tags) {
        this.tags = tags;
    }
}

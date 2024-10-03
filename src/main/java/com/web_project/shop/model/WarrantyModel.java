package com.web_project.shop.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "warranties")
public class WarrantyModel {
    @Id
    @GeneratedValue
    private UUID id;

    private String warrantyDetails;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    public WarrantyModel() {
    }

    public WarrantyModel(ProductModel product, String warrantyDetails, UUID id) {
        this.product = product;
        this.warrantyDetails = warrantyDetails;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWarrantyDetails() {
        return warrantyDetails;
    }

    public void setWarrantyDetails(String warrantyDetails) {
        this.warrantyDetails = warrantyDetails;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}

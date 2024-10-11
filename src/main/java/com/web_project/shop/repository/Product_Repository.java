package com.web_project.shop.repository;

import com.web_project.shop.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface Product_Repository extends JpaRepository<ProductModel, UUID> {
    List<ProductModel> findByNameContainingIgnoreCase(String name);
}

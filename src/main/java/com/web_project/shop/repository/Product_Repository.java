package com.web_project.shop.repository;

import com.web_project.shop.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_Repository extends JpaRepository<ProductModel, Long> {
}

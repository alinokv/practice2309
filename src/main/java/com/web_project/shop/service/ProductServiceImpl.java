package com.web_project.shop.service;

import com.web_project.shop.model.ProductModel;
import com.web_project.shop.repository.Product_Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

import java.util.List;

@Service
public class ProductServiceImpl extends GenericServiceImpl<ProductModel, UUID> implements ProductService {
    private final Product_Repository repository;

    public ProductServiceImpl(Product_Repository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<ProductModel> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}

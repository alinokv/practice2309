package com.web_project.shop.service;

import com.web_project.shop.model.ProductModel;
import com.web_project.shop.repository.Product_Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl extends GenericServiceImpl<ProductModel, UUID> implements ProductService {
    public ProductServiceImpl(Product_Repository repository) {
        super(repository);
    }
}

package com.web_project.shop.service;
import com.web_project.shop.model.ProductModel;

import java.util.List;

public interface ProductService {
    public List<ProductModel> findAllProducts();

    public ProductModel findProductById(int id);

    public ProductModel addProduct(ProductModel product);

    public ProductModel updateProduct(ProductModel product);

    public void deleteProduct(int id);
}

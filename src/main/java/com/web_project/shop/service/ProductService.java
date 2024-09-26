package com.web_project.shop.service;

import com.web_project.shop.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> findAllProducts();
    List<ProductModel> findProductsPaginated(int page, int size);
    ProductModel findProductById(int id);
    ProductModel addProduct(ProductModel product);
    ProductModel updateProduct(ProductModel product);
    void deleteProduct(int id);
    int countProducts();  // Для получения общего числа продуктов
}

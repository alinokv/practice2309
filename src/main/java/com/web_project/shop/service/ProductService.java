package com.web_project.shop.service;

import com.web_project.shop.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> findAllProducts();

    //    List<ProductModel> findProductsPaginated(int page, int size);
    public ProductModel findProductById(Long id);

    public ProductModel addProduct(ProductModel product);

    public ProductModel updateProduct(ProductModel product);

    public void deleteProduct(Long id);
//    int countProducts();  // Для получения общего числа продуктов
//    void deleteMultipleProducts(List<Integer> ids);
}

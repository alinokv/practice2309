package com.web_project.shop.repository;

import com.web_project.shop.model.ProductModel;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class ProductRepository {
    private List<ProductModel> prducts = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<ProductModel> findAllProducts() {
        return new ArrayList<>(prducts);
    }

    public ProductModel addProduct(ProductModel product) {
        product.setId(idCounter.getAndIncrement());
        prducts.add(product);
        return product;
    }

    public ProductModel updateProduct(ProductModel product) {
        for (int i = 0; i < prducts.size(); i++) {
            if (prducts.get(i).getId() == product.getId()) {
                prducts.set(i, product);
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        prducts.removeIf(product -> product.getId() == id);
    }

    public ProductModel findProductById(int id) {
        return prducts.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public int countProducts() {
        return prducts.size();
    }
}

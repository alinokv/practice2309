package com.web_project.shop.service;

import com.web_project.shop.model.ProductModel;
import com.web_project.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSeviceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductSeviceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> findAllProducts(){
        return productRepository.findAllProducts();
    }

    @Override
    public ProductModel findProductById(int id){
        return productRepository.findProductById(id);
    }

    @Override
    public ProductModel addProduct(ProductModel product){
        return productRepository.addProduct(product);
    }

    @Override
    public ProductModel updateProduct(ProductModel product){
        return productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id){
        productRepository.deleteProduct(id);
    }

}

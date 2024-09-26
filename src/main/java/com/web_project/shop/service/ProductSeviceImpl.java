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
    public List<ProductModel> findProductsPaginated(int page, int size) {
        int fromIndex = (page - 1) * size;
        int toIndex = Math.min(fromIndex + size, productRepository.countProducts());
        return productRepository.findAllProducts().subList(fromIndex, toIndex);
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

    @Override
    public int countProducts() {
        return productRepository.countProducts();
    }
    @Override
    public void deleteMultipleProducts(List<Integer> ids) {
        ids.forEach(productRepository::deleteProduct);
    }
}

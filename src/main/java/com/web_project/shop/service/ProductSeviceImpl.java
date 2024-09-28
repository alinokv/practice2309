package com.web_project.shop.service;

import com.web_project.shop.model.ProductModel;
import com.web_project.shop.repository.Product_Repository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSeviceImpl implements ProductService {
    private final Product_Repository productRepository;

    public ProductSeviceImpl(Product_Repository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> findAllProducts() {
        return productRepository.findAll(Sort.by("id"));
    }

//    @Override
//    public List<ProductModel> findProductsPaginated(int page, int size) {
//        int fromIndex = (page - 1) * size;
//        int toIndex = Math.min(fromIndex + size, productRepository.countProducts());
//        return productRepository.findAllProducts().subList(fromIndex, toIndex);
//    }

    @Override
    public ProductModel findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductModel addProduct(ProductModel product) {
        return productRepository.save(product);
    }

    @Override
    public ProductModel updateProduct(ProductModel product) {
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
    }

//    @Override
//    public int countProducts() {
//        return productRepository.countProducts();
//    }
//
//    @Override
//    public void deleteMultipleProducts(List<Integer> ids) {
//        ids.forEach(productRepository::deleteProduct);
//    }
}

/*
package com.web_project.shop.service;

import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.model.ProductModel;
import com.web_project.shop.model.StudentModel;
import com.web_project.shop.repository.Category_Repository;
import com.web_project.shop.repository.Product_Repository;
import com.web_project.shop.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class UnifiedServiceImpl {


    @Service
    public static class CategoryServiceImpl extends GenericServiceImpl<CategoryModel, Long> {
        public CategoryServiceImpl(Category_Repository repository) {
            super(repository);
        }
    }

    @Service
    public static class ProductServiceImpl extends GenericServiceImpl<ProductModel, Long> implements ProductService {
        public ProductServiceImpl(Product_Repository repository) {
            super(repository);
        }
    }

    @Service
    public static class StudentServiceImpl extends GenericServiceImpl<StudentModel, Long> implements StudentService {
        private final StudentRepository studentRepository;

        public StudentServiceImpl(StudentRepository studentRepository) {
            super(studentRepository);
            this.studentRepository = studentRepository;
        }

        @Override
        public StudentModel findByName(String name) {
            return studentRepository.findByName(name);
        }
    }
}
*/

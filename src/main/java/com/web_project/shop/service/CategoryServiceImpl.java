package com.web_project.shop.service;
import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.repository.CategoryRepository;
import com.web_project.shop.repository.InMemoryStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> findAllCategories(){
        return categoryRepository.findAllCategories();
    }

    @Override
    public CategoryModel findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public CategoryModel addCategory(CategoryModel student){
        return categoryRepository.addCategory(student);
    }

    @Override
    public CategoryModel updateCategory(CategoryModel student){
        return categoryRepository.updateCategory(student);
    }

    @Override
    public void deleteCategory(int id){
        categoryRepository.deleteCategory(id);
    }
}

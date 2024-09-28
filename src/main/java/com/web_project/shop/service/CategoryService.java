package com.web_project.shop.service;

import com.web_project.shop.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    public List<CategoryModel> findAllCategories();

    public CategoryModel findCategoryById(Long id);

    public CategoryModel addCategory(CategoryModel category);

    public CategoryModel updateCategory(CategoryModel category);

    public void deleteCategory(Long id);
}
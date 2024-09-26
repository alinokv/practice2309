package com.web_project.shop.repository;

import com.web_project.shop.model.CategoryModel;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CategoryRepository {
    private List<CategoryModel> categories = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<CategoryModel> findAllCategories() {
        return new ArrayList<>(categories);
    }

    public CategoryModel addCategory(CategoryModel category) {
        category.setId(idCounter.getAndIncrement());
        categories.add(category);
        return category;
    }

    public CategoryModel updateCategory(CategoryModel category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == category.getId()) {
                categories.set(i, category);
                return category;
            }
        }
        return null;
    }

    public void deleteCategory(int id) {
        categories.removeIf(category -> category.getId() == id);
    }

    public CategoryModel findCategoryById(int id) {
        return categories.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
    }

}

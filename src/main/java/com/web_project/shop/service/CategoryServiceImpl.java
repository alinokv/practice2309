//package com.web_project.shop.service;
//import com.web_project.shop.model.CategoryModel;
//import com.web_project.shop.repository.Category_Repository;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategoryServiceImpl implements CategoryService{
//    private final Category_Repository categoryRepository;
//
//    public CategoryServiceImpl(Category_Repository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public List<CategoryModel> findAllCategories(){
//        return categoryRepository.findAll(Sort.by("id"));
//    }
//
//    @Override
//    public CategoryModel findCategoryById(Long id) {
//        return categoryRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public CategoryModel addCategory(CategoryModel category){
//        return categoryRepository.save(category);
//    }
//
//    @Override
//    public CategoryModel updateCategory(CategoryModel category){
//        if (categoryRepository.existsById(category.getId())) {
//            return categoryRepository.save(category);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteCategory(Long id){
//        if (categoryRepository.existsById(id)){
//            categoryRepository.deleteById(id);
//        }
//    }
//}
package com.web_project.shop.service;

import com.web_project.shop.model.CategoryModel;
import com.web_project.shop.repository.Category_Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<CategoryModel, UUID> implements CategoryService {
    public CategoryServiceImpl(Category_Repository repository) {
        super(repository);
    }
}


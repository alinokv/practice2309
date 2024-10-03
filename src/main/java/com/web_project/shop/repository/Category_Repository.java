package com.web_project.shop.repository;

import com.web_project.shop.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Category_Repository extends JpaRepository<CategoryModel, UUID> {

}

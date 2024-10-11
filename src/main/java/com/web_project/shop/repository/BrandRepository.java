package com.web_project.shop.repository;

import com.web_project.shop.model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<BrandModel, UUID> {
}

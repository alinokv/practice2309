package com.web_project.shop.repository;

import com.web_project.shop.model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<SupplierModel, UUID> {
}

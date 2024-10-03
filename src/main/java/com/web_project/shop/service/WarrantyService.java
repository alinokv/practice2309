package com.web_project.shop.service;

import com.web_project.shop.model.WarrantyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarrantyService extends GenericService<WarrantyModel, UUID> {
}

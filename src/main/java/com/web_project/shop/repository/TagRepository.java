package com.web_project.shop.repository;

import com.web_project.shop.model.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<TagModel, UUID> {
}

package com.web_project.shop.repository;

import com.web_project.shop.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
//    StudentModel findByName(String name);
}

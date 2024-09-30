package com.web_project.shop.service;

import com.web_project.shop.model.UniversityModel;
import com.web_project.shop.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UniversityServiceIMPL extends GenericServiceImpl<UniversityModel, UUID> implements UniversityService{
    public UniversityServiceIMPL(UniversityRepository repository) {super(repository);}
}

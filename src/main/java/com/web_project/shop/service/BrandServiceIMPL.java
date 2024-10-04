package com.web_project.shop.service;

import com.web_project.shop.model.BrandModel;
import com.web_project.shop.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BrandServiceIMPL extends GenericServiceImpl<BrandModel, UUID> implements BrandService {
    public BrandServiceIMPL(BrandRepository repository) {super(repository);}
}

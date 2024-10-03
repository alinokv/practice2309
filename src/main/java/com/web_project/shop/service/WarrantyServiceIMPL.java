package com.web_project.shop.service;

import com.web_project.shop.model.WarrantyModel;
import com.web_project.shop.repository.WarrantyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WarrantyServiceIMPL extends GenericServiceImpl<WarrantyModel,UUID> implements WarrantyService {
    public WarrantyServiceIMPL(WarrantyRepository repository) {super(repository);}
}

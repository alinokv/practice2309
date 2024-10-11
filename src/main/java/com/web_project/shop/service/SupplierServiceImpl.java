package com.web_project.shop.service;

import com.web_project.shop.model.SupplierModel;
import com.web_project.shop.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SupplierServiceImpl extends GenericServiceImpl<SupplierModel, UUID> implements SupplierService {
    public SupplierServiceImpl(SupplierRepository repository) {super(repository);}
}

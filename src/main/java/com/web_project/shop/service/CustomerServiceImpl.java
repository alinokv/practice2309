package com.web_project.shop.service;

import com.web_project.shop.model.BrandModel;
import com.web_project.shop.model.CustomerModel;
import com.web_project.shop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<CustomerModel, UUID> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}

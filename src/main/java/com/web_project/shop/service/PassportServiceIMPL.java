package com.web_project.shop.service;

import com.web_project.shop.model.PassportModel;
import com.web_project.shop.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PassportServiceIMPL extends GenericServiceImpl<PassportModel, UUID> implements PassportService{
    public PassportServiceIMPL(PassportRepository repository) {super(repository);}
}

package com.web_project.shop.service;

import com.web_project.shop.model.HolidayModel;
import com.web_project.shop.repository.HolidayRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HolidayServireIMPL extends GenericServiceImpl<HolidayModel, UUID> implements HolidayService {
    public HolidayServireIMPL(HolidayRepository repository) {super(repository);}
}

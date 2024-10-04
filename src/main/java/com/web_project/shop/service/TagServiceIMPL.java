package com.web_project.shop.service;

import com.web_project.shop.model.TagModel;
import com.web_project.shop.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TagServiceIMPL extends GenericServiceImpl<TagModel, UUID> implements TagService {
    public TagServiceIMPL(TagRepository repository) {super(repository);}
}

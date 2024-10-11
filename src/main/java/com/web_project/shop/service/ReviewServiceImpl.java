package com.web_project.shop.service;

import com.web_project.shop.model.ReviewModel;
import com.web_project.shop.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewServiceImpl extends GenericServiceImpl<ReviewModel, UUID> implements ReviewService {
    public ReviewServiceImpl(ReviewRepository repository) {super(repository);}
}

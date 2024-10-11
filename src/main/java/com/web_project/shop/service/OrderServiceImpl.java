package com.web_project.shop.service;

import com.web_project.shop.model.OrderModel;
import com.web_project.shop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl extends GenericServiceImpl<OrderModel, UUID> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {super(repository);}
}

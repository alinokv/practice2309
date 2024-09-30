package com.web_project.shop.service;

import java.util.List;

public interface GenericService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T add(T entity);
    T update(T entity);
    void delete(ID id);
}

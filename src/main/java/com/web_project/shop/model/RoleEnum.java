package com.web_project.shop.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER, ADMIN, SUPERVISOR;

    @Override
    public String getAuthority() {
        return name();
    }
}

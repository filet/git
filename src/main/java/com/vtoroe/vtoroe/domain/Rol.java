package com.vtoroe.vtoroe.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Rol implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
package br.gov.sp.campinas.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ANONYMOUS;

    @Override
    public String getAuthority() {
        return this.name();
    }

}

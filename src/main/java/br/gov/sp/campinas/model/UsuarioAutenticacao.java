package br.gov.sp.campinas.model;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class UsuarioAutenticacao implements Authentication {

    private static final long serialVersionUID = -7170337143687707450L;

    private final Usuario usuario;
    private boolean authenticated = true;

    public UsuarioAutenticacao(final Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return usuario.getSenha();
    }

    @Override
    public Object getDetails() {
        return usuario;
    }

    @Override
    public Object getPrincipal() {
        return usuario.getEmail();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(final boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return usuario.getEmail();
    }

    public Usuario getUser() {
        return usuario;
    }
}
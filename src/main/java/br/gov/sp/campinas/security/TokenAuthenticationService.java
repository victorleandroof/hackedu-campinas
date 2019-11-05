package br.gov.sp.campinas.security;

import br.gov.sp.campinas.model.Usuario;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface TokenAuthenticationService {

    Authentication authenticate(HttpServletRequest request);
    Usuario getUsuarioLogado();

}

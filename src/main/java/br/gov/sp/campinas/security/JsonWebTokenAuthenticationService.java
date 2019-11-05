package br.gov.sp.campinas.security;

import br.gov.sp.campinas.exception.AuthenticationException;
import br.gov.sp.campinas.model.SecurityConstants;
import br.gov.sp.campinas.model.Usuario;
import br.gov.sp.campinas.model.UsuarioAutenticacao;
import br.gov.sp.campinas.service.UsuarioService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JsonWebTokenAuthenticationService implements TokenAuthenticationService {

    @Value("${security.token.secret.key}")
    private String secretKey;
    private final UsuarioService usuarioService;
    private Usuario usuarioLogado;

    @Autowired
    public JsonWebTokenAuthenticationService(final UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public Authentication authenticate(final HttpServletRequest request) {
        final String token = request.getHeader(SecurityConstants.AUTH_HEADER_NAME);
        final Jws<Claims> tokenData = parseToken(token);
        if (tokenData != null) {
            final Usuario usuario = getUserFromToken(tokenData);
            this.usuarioLogado = usuario;
            if (usuario != null) {
                return new UsuarioAutenticacao(usuario);
            }
        }
        return null;
    }

    private Jws<Claims> parseToken(final String token) {
        if (token != null) {
            try {
                return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
                    | SignatureException | IllegalArgumentException e) {
                throw new AuthenticationException("usuario nao autenticado");
            }
        }
        return null;
    }

    private Usuario getUserFromToken(final Jws<Claims> tokenData) {
        try {
            final String username = tokenData.getBody().get("email").toString();
            return usuarioService.findByEmail(username).block();
        } catch (Exception e) {
            throw  new AuthenticationException("usuario nao localizado na base de dados");
        }
    }


    @Override
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}

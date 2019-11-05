package br.gov.sp.campinas.service;

import br.gov.sp.campinas.model.Usuario;
import br.gov.sp.campinas.repository.UsuarioRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;
    private static int tokenExpirationTime = 100;
    private String tokenKey;

    @Autowired
    public UsuarioServiceImpl(@Value("${security.token.secret.key}") String tokenKey, UsuarioRepository repository) {
        this.repository = repository;
        this.tokenKey = tokenKey;
    }

    @Override
    public Mono<Usuario> save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Flux<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public String findByEmailAndSenha(String email, String senha) {
        Mono<Usuario> usuario = repository.findByEmailAndSenha(email,senha);
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put("tipo", usuario.block().getTipoUsuario().tipoPerfil);
        tokenData.put("email", usuario.block().getEmail());
        tokenData.put("token_create_date", LocalDateTime.now());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, tokenExpirationTime);
        tokenData.put("token_expiration_date", calendar.getTime());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, tokenKey).compact();
    }

    @Override
    public Mono<Usuario> findById(String id) {
        return null;
    }

    @Override
    public Mono<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

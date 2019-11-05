package br.gov.sp.campinas.service;

import br.gov.sp.campinas.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {

    Mono<Usuario> save(Usuario usuario);

    Flux<Usuario> findAll();

   String findByEmailAndSenha(String email,String senha);

    Mono<Usuario> findById(String id);


    Mono<Usuario> findByEmail(String email);

}

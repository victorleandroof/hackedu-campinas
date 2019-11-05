package br.gov.sp.campinas.repository;

import br.gov.sp.campinas.model.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario,String> {

    Mono<Usuario> save(Usuario usuario);

    Flux<Usuario> findAll();

    Mono<Usuario> findByEmailAndSenha(String email,String senha);

    Mono<Usuario> findById(String id);

    Mono<Usuario> findByEmail(String email);

}

package br.gov.sp.campinas.service;

import br.gov.sp.campinas.model.Mensagem;
import br.gov.sp.campinas.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MensagemService {

    Mono<Mensagem> save(Mensagem mensagem);
    Flux<Mensagem> findByProfessor(String idProfessor);
    Flux<Mensagem> findByResponsavel(String idResponsavel);
    Flux<Mensagem> findMessages(Usuario usuario);
}

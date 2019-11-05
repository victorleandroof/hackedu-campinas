package br.gov.sp.campinas.service;


import br.gov.sp.campinas.model.Professor;
import br.gov.sp.campinas.model.Responsavel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ResponsavelService {

    Mono<Responsavel> save(Responsavel responsavel);
    Flux<Responsavel> findAll();
    Mono<Responsavel> findById(String id);
    

}

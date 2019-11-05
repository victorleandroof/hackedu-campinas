package br.gov.sp.campinas.service;


import br.gov.sp.campinas.model.Professor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfessorService {

    Mono<Professor> save(Professor professor);
    Flux<Professor> findAll();
    Mono<Professor> findById(String id);


}

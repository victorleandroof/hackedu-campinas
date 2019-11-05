package br.gov.sp.campinas.service;

import br.gov.sp.campinas.model.Professor;
import br.gov.sp.campinas.model.Responsavel;
import br.gov.sp.campinas.repository.ProfessorRepository;
import br.gov.sp.campinas.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ResponsavelServiceImpl implements  ResponsavelService{

    private final ResponsavelRepository repository;

    @Autowired
    public ResponsavelServiceImpl(ResponsavelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Responsavel> save(Responsavel responsavel) {
        return repository.save(responsavel);
    }

    @Override
    public Flux<Responsavel> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Responsavel> findById(String id) {
        return this.repository.findById(id);
    }


}

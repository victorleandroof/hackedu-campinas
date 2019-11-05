package br.gov.sp.campinas.service;

import br.gov.sp.campinas.model.Professor;
import br.gov.sp.campinas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfessorServiceImpl implements  ProfessorService{

    private final ProfessorRepository repository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Professor> save(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public Flux<Professor> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Professor> findById(String id) {
        return this.repository.findById(id);
    }


}

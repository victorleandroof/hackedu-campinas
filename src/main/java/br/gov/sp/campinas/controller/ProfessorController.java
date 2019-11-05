package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Professor;
import br.gov.sp.campinas.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public Flux<Professor> findAll() {
        return professorService.findAll();
    }
    
    @PostMapping
    public Mono<Professor> create(@RequestBody @Valid Professor professor) {
        return this.professorService.save(professor);
    }

    @GetMapping(path = "/{id}")
    public Mono<Professor> findById(@PathVariable("id")String id) {
        return this.professorService.findById(id);
    }





}

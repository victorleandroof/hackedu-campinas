package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Responsavel;
import br.gov.sp.campinas.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/responsavel")
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    @Autowired
    public ResponsavelController(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @GetMapping
    public Flux<Responsavel> findAll() {
        return responsavelService.findAll();
    }
    
    @PostMapping
    public Mono<Responsavel> create(@RequestBody @Valid Responsavel responsavel) {
        return this.responsavelService.save(responsavel);
    }

    @GetMapping(path = "/{id}")
    public Mono<Responsavel> findById(@PathVariable("id")String id) {
        return this.responsavelService.findById(id);
    }





}

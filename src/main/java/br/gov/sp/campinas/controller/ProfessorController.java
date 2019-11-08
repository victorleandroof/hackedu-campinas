package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Professor;
import br.gov.sp.campinas.service.ProfessorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "listar professor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna lista professor"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Flux<Professor> findAll() {
        return professorService.findAll();
    }
    
    @PostMapping
    @ApiOperation(value = "criar professor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna professor salvo"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Mono<Professor> create(@RequestBody @Valid Professor professor) {
        return this.professorService.save(professor);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "busca por id o professor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna professor"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Mono<Professor> findById(@PathVariable("id")String id) {
        return this.professorService.findById(id);
    }





}

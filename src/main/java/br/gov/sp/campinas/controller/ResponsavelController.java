package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Responsavel;
import br.gov.sp.campinas.service.ResponsavelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "listar todos os resposnavel")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna lista de responsavel"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Flux<Responsavel> findAll() {
        return responsavelService.findAll();
    }
    
    @PostMapping
    @ApiOperation(value = "cria um responsavel")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "criado com sucesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Mono<Responsavel> create(@RequestBody @Valid Responsavel responsavel) {
        return this.responsavelService.save(responsavel);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "busca por id o responsavel")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna responsavel"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Mono<Responsavel> findById(@PathVariable("id")String id) {
        return this.responsavelService.findById(id);
    }





}

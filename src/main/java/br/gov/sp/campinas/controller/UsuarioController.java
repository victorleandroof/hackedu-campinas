package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Usuario;
import br.gov.sp.campinas.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ApiOperation(value = "criar um novo usuario")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "usuario criado"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Mono<Usuario> create(@RequestBody @Valid Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    @PostMapping(path = "/auth/")
    @ApiOperation(value = "autenticacao")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna token acesso"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Mono<String> login(@RequestBody @Valid Usuario usuario) {
        return Mono.just(this.usuarioService.findByEmailAndSenha(usuario.getEmail(),usuario.getSenha()));
    }





}

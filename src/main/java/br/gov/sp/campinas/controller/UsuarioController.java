package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Usuario;
import br.gov.sp.campinas.service.UsuarioService;
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
    public Mono<Usuario> create(@RequestBody @Valid Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    @PostMapping(path = "/auth/")
    public Mono<String> login(@RequestBody @Valid Usuario usuario) {
        return Mono.just(this.usuarioService.findByEmailAndSenha(usuario.getEmail(),usuario.getSenha()));
    }





}

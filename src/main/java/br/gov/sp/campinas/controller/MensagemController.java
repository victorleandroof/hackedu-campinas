package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Mensagem;
import br.gov.sp.campinas.model.Usuario;
import br.gov.sp.campinas.security.TokenAuthenticationService;
import br.gov.sp.campinas.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/mensagem")
public class MensagemController {

    private final MensagemService mensagemService;
    private final TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public MensagemController(MensagemService mensagemService, TokenAuthenticationService tokenAuthenticationService) {
        this.mensagemService = mensagemService;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @PostMapping
    public Mono<Mensagem> create(@RequestBody @Valid Mensagem mensagem) {
        return this.mensagemService.save(mensagem);
    }

    @GetMapping()
    public Flux<Mensagem> findMensagem() {
        Usuario usuario = tokenAuthenticationService.getUsuarioLogado();
        return this.mensagemService.findMessages(usuario);
    }





}

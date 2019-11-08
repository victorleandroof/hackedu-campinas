package br.gov.sp.campinas.controller;

import br.gov.sp.campinas.model.Mensagem;
import br.gov.sp.campinas.model.Usuario;
import br.gov.sp.campinas.security.TokenAuthenticationService;
import br.gov.sp.campinas.service.MensagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/mensagem")
@Api(value = "/v1/password", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MensagemController {

    private final MensagemService mensagemService;
    private final TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public MensagemController(MensagemService mensagemService, TokenAuthenticationService tokenAuthenticationService) {
        this.mensagemService = mensagemService;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @PostMapping
    @ApiOperation(value = "enviar mensagem")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna mensagem salva"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Mono<Mensagem> create(@RequestBody @Valid Mensagem mensagem) {
        return this.mensagemService.save(mensagem);
    }

    @GetMapping
    @ApiOperation(value = "listar mensagem")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "retorna lista de mensagem"),
            @ApiResponse(code = 408, message = "Request timeout"),
            @ApiResponse(code = 422, message = "Validation error"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public Flux<Mensagem> findMensagem() {
        Usuario usuario = tokenAuthenticationService.getUsuarioLogado();
        return this.mensagemService.findMessages(usuario);
    }





}

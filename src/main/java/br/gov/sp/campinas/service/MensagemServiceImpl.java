package br.gov.sp.campinas.service;

import br.gov.sp.campinas.model.Mensagem;
import br.gov.sp.campinas.model.Usuario;
import br.gov.sp.campinas.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MensagemServiceImpl implements MensagemService {

    private MensagemRepository repository;

    @Autowired
    public MensagemServiceImpl(MensagemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Mensagem> save(Mensagem mensagem) {
        return repository.save(mensagem);
    }

    @Override
    public Flux<Mensagem> findByProfessor(String idProfessor) {
        return repository.findAll().filter(mensagem -> mensagem.getProfessor().block().equals(idProfessor));

    }
    @Override
    public Flux<Mensagem> findByResponsavel(String idReponsavel) {
        return repository.findAll().filter(mensagem -> mensagem.getResponsavel().block().equals(idReponsavel));
    }

    @Override
    public Flux<Mensagem> findMessages(Usuario usuario) {
        if(usuario.getProfessor() != null){
            return findByProfessor(usuario.getProfessor().getId());
        } else {
            return findByProfessor(usuario.getResponsavel().getId());
        }
    }
}

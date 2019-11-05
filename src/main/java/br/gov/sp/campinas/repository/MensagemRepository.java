package br.gov.sp.campinas.repository;

import br.gov.sp.campinas.model.Mensagem;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MensagemRepository extends ReactiveCrudRepository<Mensagem,String> {

    Flux<Mensagem> findByProfessor();

}

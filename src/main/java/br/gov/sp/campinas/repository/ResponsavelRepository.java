package br.gov.sp.campinas.repository;

import br.gov.sp.campinas.model.Responsavel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends ReactiveCrudRepository<Responsavel,String> {
}

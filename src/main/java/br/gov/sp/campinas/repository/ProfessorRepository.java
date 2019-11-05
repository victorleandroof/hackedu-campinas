package br.gov.sp.campinas.repository;

import br.gov.sp.campinas.model.Professor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends ReactiveCrudRepository<Professor,String> {

}

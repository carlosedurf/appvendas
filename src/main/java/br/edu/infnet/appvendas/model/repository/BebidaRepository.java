package br.edu.infnet.appvendas.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvendas.model.domain.Bebida;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida,Integer> {

}

package br.edu.infnet.appvendas.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvendas.model.domain.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor,Integer> {
	Vendedor findByCpf(String cpf);
	
	List<Vendedor> findAll(Sort sort);
}

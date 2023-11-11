package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.repository.VendedorRepository;

@Service
@Transactional
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	public void incluir(Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista() {
		System.out.println(vendedorRepository.findAll());
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}
	
	public long obterQuantidade() {
		return vendedorRepository.count();
	}
}

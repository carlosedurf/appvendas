package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Bebida;
import br.edu.infnet.appvendas.model.repository.BebidaRepository;

@Service
public class BebidaService {
	
	@Autowired
	private BebidaRepository bebidaRepository;
	
	public void incluir(Bebida bebida) {
		bebidaRepository.save(bebida);
	}
	
	public Collection<Bebida> obterLista() {
		return (Collection<Bebida>) bebidaRepository.findAll();
	}
	
	public long obterQuantidade() {
		return bebidaRepository.count();
	}
}

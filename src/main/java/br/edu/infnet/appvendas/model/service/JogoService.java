package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Jogo;
import br.edu.infnet.appvendas.model.repository.JogoRepository;

@Service
public class JogoService {
	@Autowired
	private JogoRepository jogoRepository;
	
	public void incluir(Jogo jogo) {
		jogoRepository.save(jogo);
	}
	
	public Collection<Jogo> obterLista() {
		return (Collection<Jogo>) jogoRepository.findAll();
	}
}

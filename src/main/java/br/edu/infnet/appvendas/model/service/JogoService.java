package br.edu.infnet.appvendas.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Jogo;

@Service
public class JogoService {
	private Map<Integer, Jogo> mapaJogo = new HashMap<Integer, Jogo>();
	
	public void incluir(Jogo jogo) {
		mapaJogo.put(jogo.getCodigo(), jogo);
	}
	
	public Collection<Jogo> obterLista() {
		return mapaJogo.values();
	}
}

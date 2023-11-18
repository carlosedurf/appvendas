package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appvendas.model.domain.Informacao;
import br.edu.infnet.appvendas.model.service.InformacaoService;

@Controller
public class InformacaoController {
	@Autowired
	private InformacaoService informacaoService;
	
	@PostMapping(value = "/informacao/incluir")
	public String incluir(Informacao informacao) {
		Informacao result = informacaoService.incluir(informacao);
		System.out.println("[RESULT]: " + result);
		return "redirect:/";
	}
	
	@GetMapping(value = "/informacao/{id}/excluir")
	public String excluir(@PathVariable  Integer id) {
		System.out.println("[ID]: " + id);
		informacaoService.excluir(id);
		return "redirect:/";
	}
}

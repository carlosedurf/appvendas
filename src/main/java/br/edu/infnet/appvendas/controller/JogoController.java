package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvendas.model.domain.Jogo;
import br.edu.infnet.appvendas.model.service.JogoService;

@Controller
public class JogoController {
	@Autowired
	private AppController appController;

	@Autowired
	private JogoService jogoService;

	@GetMapping(value = "/jogo/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		jogoService.excluir(id);
		return "redirect:/jogo/lista";
	}
	
	@GetMapping(value = "/jogo/lista")
	public String obterListaJogo(Model model) {
		model.addAttribute("titulo", "Jogos:");
		model.addAttribute("rota", "jogo");
		model.addAttribute("listagem", jogoService.obterLista());
		return appController.showHome(model);
	}
	
	@GetMapping(value = "/jogo/pesquisar")
	public String pesquisar(Model model, String campoBusca) {
		Jogo jogo = jogoService.pesquisar(Integer.parseInt(campoBusca));
		if (jogo != null) {
			model.addAttribute("objeto", jogo);
			return appController.showHome(model);
		}
		return "redirect:/jogo/lista";
	}
}

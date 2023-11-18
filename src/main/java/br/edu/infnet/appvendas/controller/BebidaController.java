package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvendas.model.domain.Bebida;
import br.edu.infnet.appvendas.model.service.BebidaService;

@Controller
public class BebidaController {
	@Autowired
	private AppController appController;

	@Autowired
	private BebidaService bebidaService;

	@GetMapping(value = "/bebida/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		bebidaService.excluir(id);
		return "redirect:/bebida/lista";
	}

	@GetMapping(value = "/bebida/lista")
	public String obterListaJogo(Model model) {
		model.addAttribute("titulo", "Bebidas:");
		model.addAttribute("rota", "bebida");
		model.addAttribute("listagem", bebidaService.obterLista());
		return appController.showHome(model);
	}
	
	@GetMapping(value = "/bebida/pesquisar")
	public String pesquisar(Model model, String campoBusca) {
		Bebida bebida = bebidaService.pesquisar(Integer.parseInt(campoBusca));
		if (bebida != null) {
			model.addAttribute("objeto", bebida);
			return appController.showHome(model);
		}
		return "redirect:/bebida/lista";
	}
}

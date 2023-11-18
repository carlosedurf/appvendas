package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.service.ProdutoService;

@Controller
public class ProdutoController {
	@Autowired
	private AppController appController;

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
		return "redirect:/produto/lista";
	}

	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("rota", "produto");
		model.addAttribute("listagem", produtoService.obterLista());
		return appController.showHome(model);
	}
	
	@GetMapping(value = "/produto/pesquisar")
	public String pesquisar(Model model, String campoBusca) {
		Produto produto = produtoService.pesquisar(Integer.parseInt(campoBusca));
		if (produto != null) {
			model.addAttribute("objeto", produto);
			return appController.showHome(model);
		}
		return "redirect:/produto/lista";
	}
}

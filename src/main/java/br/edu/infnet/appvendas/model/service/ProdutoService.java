package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public Collection<Produto> obterLista() {
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Collection<Produto> obterLista(Vendedor vendedor) {
		return (Collection<Produto>) produtoRepository.obterLista(vendedor.getId());
	}
	
	public Collection<Produto> obterLista(Integer id) {
		return (Collection<Produto>) produtoRepository.obterLista(id);
	}
	
	public long obterQuantidade() {
		return produtoRepository.count();
	}

	public Produto pesquisar(Integer codigo) {
		return produtoRepository.findByCodigo(codigo);
	}
}

package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.appvendas.clients.IEnderecoClient;
import br.edu.infnet.appvendas.model.domain.Endereco;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.repository.VendedorRepository;

@Service
@Transactional
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public void incluir(Vendedor vendedor) {
		Endereco endereco = enderecoClient.buscarCep(vendedor.getEndereco().getCep());
		vendedor.setEndereco(endereco);
		vendedorRepository.save(vendedor);
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
	
	public Collection<Vendedor> obterLista() {
		return (Collection<Vendedor>) vendedorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public long obterQuantidade() {
		return vendedorRepository.count();
	}
	
	public Vendedor pesquisar(String cpf) {
		return vendedorRepository.findByCpf(cpf);
	}
}

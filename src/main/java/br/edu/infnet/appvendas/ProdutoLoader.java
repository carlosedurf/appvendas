package br.edu.infnet.appvendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Bebida;
import br.edu.infnet.appvendas.model.domain.Jogo;
import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.ProdutoService;
import br.edu.infnet.appvendas.model.service.VendedorService;

@Component
@Order(2)
public class ProdutoLoader implements ApplicationRunner {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("arquivos/produto.txt");
		BufferedReader leitura = new BufferedReader(file);
		String linha = leitura.readLine();
		String[] campos = null;
		Vendedor vendedor = new Vendedor();
		while(linha != null) {
			campos = linha.split(";");
			switch(campos[6]) {
				case "J":
					Jogo jogo = new Jogo();
					jogo.setDescricao(campos[0]);
					jogo.setCodigo(Integer.valueOf(campos[1]));
					jogo.setPreco(Float.valueOf(campos[2]));
					jogo.setEstoque(Boolean.valueOf(campos[3]));
					jogo.setEletronico(Boolean.valueOf(campos[4]));
					jogo.setPlataforma(campos[5]);
					vendedor.setId(Integer.valueOf(campos[7]));
					produtoService.incluir(jogo);
					break;
				case "B":
					Bebida bebida = new Bebida();
					bebida.setDescricao(campos[0]);
					bebida.setCodigo(Integer.valueOf(campos[1]));
					bebida.setPreco(Float.valueOf(campos[2]));
					bebida.setEstoque(Boolean.valueOf(campos[3]));
					bebida.setMarca(campos[4]);
					bebida.setAlcoolico(Boolean.valueOf(campos[5]));
					vendedor.setId(Integer.valueOf(campos[7]));
					produtoService.incluir(bebida);
					break;
				default:
					break;
			}
			linha = leitura.readLine();
		}
		System.out.println("Processamento finalizado com sucesso!");
		System.out.println("Produtos do Vendedor " + vendedor.getId());
		for (Vendedor v: vendedorService.obterLista()) {
			System.out.println("[VENDEDOR] " + v.getId());
			for(Produto produto: produtoService.obterLista(v)) {
				System.out.println("[Produto] " + produto);
			}
		}
		leitura.close();
	}
}

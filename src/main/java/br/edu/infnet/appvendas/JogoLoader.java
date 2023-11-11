package br.edu.infnet.appvendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Jogo;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.JogoService;

@Order(3)
@Component
public class JogoLoader implements ApplicationRunner {
	@Autowired
	private JogoService jogoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("arquivos/jogo.txt");
		BufferedReader leitura = new BufferedReader(file);
		String linha = leitura.readLine();
		String[] campos = null;
		while(linha != null) {
			campos = linha.split(";");
			Jogo jogo = new Jogo();
			jogo.setDescricao(campos[0]);
			jogo.setCodigo(Integer.valueOf(campos[1]));
			jogo.setPreco(Float.valueOf(campos[2]));
			jogo.setEstoque(Boolean.valueOf(campos[3]));
			jogo.setEletronico(Boolean.valueOf(campos[4]));
			jogo.setPlataforma(campos[5]);
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));
			jogo.setVendedor(vendedor);
			jogoService.incluir(jogo);
			linha = leitura.readLine();
		}
		System.out.println("Processamento finalizado com sucesso!");
		for (Jogo jogo : jogoService.obterLista()) {
			System.out.println("[Jogo] " + jogo.toString());
		}
		leitura.close();
	}

}

package br.edu.infnet.appvendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Bebida;
import br.edu.infnet.appvendas.model.service.BebidaService;

@Component
@Order(4)
public class BebidaLoader implements ApplicationRunner {
	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("arquivos/bebida.txt");
		BufferedReader leitura = new BufferedReader(file);
		String linha = leitura.readLine();
		String[] campos = null;
		while(linha != null) {
			campos = linha.split(";");
			Bebida bebida = new Bebida();
			bebida.setDescricao(campos[0]);
			bebida.setCodigo(Integer.valueOf(campos[1]));
			bebida.setPreco(Float.valueOf(campos[2]));
			bebida.setEstoque(Boolean.valueOf(campos[3]));
			bebida.setMarca(campos[4]);
			bebida.setAlcoolico(Boolean.valueOf(campos[5]));
			bebidaService.incluir(bebida);
			linha = leitura.readLine();
		}
		System.out.println("Processamento finalizado com sucesso!");
		for (Bebida bebida : bebidaService.obterLista()) {
			System.out.println("[Bebida] " + bebida);
		}
		leitura.close();
	}

}

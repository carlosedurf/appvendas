package br.edu.infnet.appvendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.VendedorService;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {	
	@Autowired
	private VendedorService vendedorService;
		
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("arquivos/vendedor.txt");
		BufferedReader leitura = new BufferedReader(file);
		String linha = leitura.readLine();
		String[] campos = null;
		while(linha != null) {
			campos = linha.split(";");
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(campos[0]);
			vendedor.setCpf(campos[1]);
			vendedor.setEmail(campos[2]);
			vendedorService.incluir(vendedor);
			linha = leitura.readLine();
		}
		System.out.println("Processamento finalizado com sucesso!");
		for (Vendedor vendedor : vendedorService.obterLista()) {
			System.out.println("[Vendedor] " + vendedor.toString());
		}
		leitura.close();
	}
}

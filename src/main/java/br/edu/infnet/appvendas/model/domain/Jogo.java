package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TJogo")
public class Jogo extends Produto {
	private boolean eletronico;
	private String plataforma;
	
	@Override
	public String toString() {
		return String.format("%s \nÉ Eletrônico: %s\nPlataforma: %s\n", super.toString(), eletronico, plataforma);
	}
	
	public boolean isEletronico() {
		return eletronico;
	}
	
	public void setEletronico(boolean eletronico) {
		this.eletronico = eletronico;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
}

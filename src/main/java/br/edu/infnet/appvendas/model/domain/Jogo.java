package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TJogo")
public class Jogo extends Produto {
	@NotNull
	private boolean eletronico;
	
	@Size(min = 2, max = 20, message = "a plataforma precisa ter no minimo {min} e maximo {max} caracteres")
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

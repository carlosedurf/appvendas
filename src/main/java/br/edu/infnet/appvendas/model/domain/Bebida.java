package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "TBebida")
public class Bebida extends Produto {
	@Size(min = 2, max = 50)
	private String marca;
	
	@NotNull
	private boolean alcoolico;
	
	@Override
	public String toString() {
		return String.format("%s - (%s) - (%s)", super.toString(), marca, alcoolico);
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public boolean isAlcoolico() {
		return alcoolico;
	}
	
	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}
}

package br.edu.infnet.appvendas.model.domain;

public class Bebida extends Produto {
	private String marca;
	private boolean alcoolico;
	
	@Override
	public String toString() {
		return String.format("%s \nMarca: %s\nÉ Alcoólico: %s\n", super.toString(), marca, alcoolico);
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

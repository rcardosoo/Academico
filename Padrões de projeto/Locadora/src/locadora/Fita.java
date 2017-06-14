package locadora;

import tipo.Tipo;

public class Fita {
	private Tipo tipo;
	private String titulo;
	
	
	public Fita(String título, Tipo tipo) {
		this.titulo = título;
		this.tipo = tipo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
}


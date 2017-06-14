package locadora;

import java.util.*;
public class Cliente {
	private int pontos;
	private String nome;
	private Collection<Aluguel> fitasAlugadas = new ArrayList<Aluguel>();

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void adicionaAluguel(Aluguel aluguel) {
		fitasAlugadas.add(aluguel);
	}
	
	public String pontosAlugador() {
		for(Aluguel a : fitasAlugadas) {
			this.pontos++;
			this.pontos += a.verificarBonus();
		}
		return "Voce acumulou " +pontos+
				" pontos de alugador frequente";
	}
	
	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
	
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
		
		for (Aluguel aluguel : fitasAlugadas) {
			double valorCorrente = 0.0;
			
			valorCorrente = aluguel.valorAluguel();
			resultado += "\t" + aluguel.getFita().getTitulo() + "\t" + valorCorrente + fimDeLinha;
			valorTotal += valorCorrente;
		}
	
		// adiciona rodapé
		resultado += "Valor total devido: " + valorTotal + fimDeLinha;
		return resultado;
	}
}


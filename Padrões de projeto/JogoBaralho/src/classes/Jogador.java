package classes;

public class Jogador {
	private String nome;
	private int pontos;
	private Carta carta;
	
	public Jogador(String nome) {
		super();
		this.nome = nome;
	}
	public Carta getCarta() {
		return carta;
	}
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}

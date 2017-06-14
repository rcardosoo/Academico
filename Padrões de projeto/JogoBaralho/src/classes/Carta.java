package classes;

public class Carta {
	private int numero;
	private String naipe;
	
	public Carta(int numero, String naipe) {
		super();
		this.numero = numero;
		this.naipe = naipe;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNaipe() {
		return naipe;
	}
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	@Override
	public String toString() {
		return "Carta [numero=" + numero + ", naipe=" + naipe + "]";
	}
	
}

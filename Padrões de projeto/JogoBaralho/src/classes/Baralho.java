package classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	private List<Carta> cartas = new ArrayList<Carta>();
	
	public void adicionarCarta(Carta c) {
		cartas.add(c);
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public void embaralhar() {
		Collections.shuffle(this.cartas);
	}
	
}

package classes.distribuicao;

import java.util.List;

import classes.Baralho;
import classes.Carta;

public interface Distribuicao {
	
	public List<Carta> distribuir(Baralho b);
}

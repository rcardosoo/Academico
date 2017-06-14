package classes.distribuicao;

import java.util.ArrayList;
import java.util.List;

import classes.Baralho;
import classes.Carta;

public class Dist1 implements Distribuicao{

	@Override
	public List<Carta> distribuir(Baralho b) {
		// TODO Auto-generated method stub
		List<Carta> c = new ArrayList<Carta>();
		List<Carta> cartas = b.getCartas();
		
		c.add(cartas.get(0));
		c.add(cartas.get(1));
		
		return c;
	}

}

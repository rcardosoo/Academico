package classes.distribuicao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import classes.Baralho;
import classes.Carta;

public class Dist3 implements Distribuicao {

	@Override
	public List<Carta> distribuir(Baralho b) {
		// TODO Auto-generated method stub
		Random r = new Random();
		List<Carta> c = new ArrayList<Carta>();
		List<Carta> cartas = b.getCartas();
		int tam = cartas.size()-1;
		
		int n1 = r.nextInt((tam-0)+1);
		int n2 = r.nextInt((tam-0)+1);
		
		c.add(cartas.get(n1));
		c.add(cartas.get(n2));
		
		return c;
	}

}

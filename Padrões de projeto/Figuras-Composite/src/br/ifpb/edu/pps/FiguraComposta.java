package br.ifpb.edu.pps;

import java.util.ArrayList;

public abstract class FiguraComposta extends Figura {
	private ArrayList<Figura> figuras = new ArrayList<Figura>();
	
	public void adicionarFigura(Figura f) {
		figuras.add(f);
	}

	public ArrayList<Figura> getFiguras() {
		return figuras;
	}
 
	
}

package br.ifpb.edu.pps.app;

import br.ifpb.edu.pps.*;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reta reta = new Reta();
		Ponto ponto = new Ponto();
		Quadrilatero quadrado = new Quadrilatero();
		quadrado.adicionarFigura(ponto);
		
		System.out.println(reta);
		ponto.desenharFigura();
		System.out.println(quadrado);
		Triangulo triangulo = new Triangulo();
		quadrado.adicionarFigura(triangulo);
		System.out.println(quadrado);
		quadrado.desenharFigura();
		
		Circulo circulo = new Circulo();
		FiguraAdapter circuloAdapter = new FiguraAdapter(circulo);
		circuloAdapter.desenharFigura();
	}

}

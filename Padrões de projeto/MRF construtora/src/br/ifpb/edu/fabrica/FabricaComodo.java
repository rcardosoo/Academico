package br.ifpb.edu.fabrica;

import br.ifpb.edu.comodo.*;

public class FabricaComodo {
	public static Comodo criarComodo(String nome) {
		if (nome.equals("sala")) {
			return new Sala();
		} else if (nome.equals("banheiro")) {
			return new Banheiro();
		} else {
			return null;
		}
	}
}

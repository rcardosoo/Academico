package br.ifpb.edu.casa;

import java.util.ArrayList;
import br.ifpb.edu.comodo.*;

public class Casa {
	private ArrayList<Comodo> comodos = new ArrayList<Comodo>();
	
	public void adicionarComodo(Comodo comodo) {
		this.comodos.add(comodo);
	}

	@Override
	public String toString() {
		return "Casa [\n"+ comodos + "]";
	}
	

}

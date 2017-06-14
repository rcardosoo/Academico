package br.ifpb.edu.comodo;

import br.ifpb.edu.componentes.louca.Louca;
import br.ifpb.edu.componentes.metal.Metal;
import br.ifpb.edu.componentes.parede.Parede;
import br.ifpb.edu.componentes.porta.Porta;

public class Banheiro extends Comodo {
	
	
	@Override
	public String toString() {
		String texto =  "Banheiro [\n" + getPiso() + "\n" + getTinta()+"\n";
		
		for(Parede parede : this.getParedes()) {
			texto += parede.toString()+"\n";
		}
		
		for(Porta porta : this.getPortas()) {
			texto += porta.toString()+"\n";
		}
		
		for(Metal metal : this.getMetais()) {
			texto += metal.toString()+"\n";
		}
		
		for(Louca louca : this.getLoucas()) {
			texto += louca.toString()+"\n";
		}
		
		return "]"+texto;
	}

}

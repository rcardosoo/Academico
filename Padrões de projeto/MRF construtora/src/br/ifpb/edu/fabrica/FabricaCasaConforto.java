package br.ifpb.edu.fabrica;

import br.ifpb.edu.componentes.louca.*;
import br.ifpb.edu.componentes.metal.*;
import br.ifpb.edu.componentes.parede.*;
import br.ifpb.edu.componentes.piso.*;
import br.ifpb.edu.componentes.porta.*;
import br.ifpb.edu.componentes.tinta.*;

public class FabricaCasaConforto implements FabricaCasa {

	@Override
	public Piso montarPiso() {
		// TODO Auto-generated method stub
		return new CeramicaEsmaltada();
	}

	@Override
	public Tinta montarTinta() {
		// TODO Auto-generated method stub
		return new Acrilica();
	}

	@Override
	public Parede montarParede() {
		// TODO Auto-generated method stub
		return new Alvenaria();
	}

	@Override
	public Porta montarPorta() {
		// TODO Auto-generated method stub
		return new Madeira();
	}

	@Override
	public Metal montarMetal() {
		// TODO Auto-generated method stub
		return new Aluminio();
	}

	@Override
	public Louca montarLouca() {
		// TODO Auto-generated method stub
		return new Elizabeth();
	}

}

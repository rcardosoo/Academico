package br.ifpb.edu.fabrica;

import br.ifpb.edu.componentes.louca.*;
import br.ifpb.edu.componentes.metal.*;
import br.ifpb.edu.componentes.parede.*;
import br.ifpb.edu.componentes.piso.*;
import br.ifpb.edu.componentes.porta.*;
import br.ifpb.edu.componentes.tinta.*;

public class FabricaCasaBasica implements FabricaCasa {

	@Override
	public Piso montarPiso() {
		// TODO Auto-generated method stub
		return new Ceramica();
	}

	@Override
	public Tinta montarTinta() {
		// TODO Auto-generated method stub
		return new Latex();
	}

	@Override
	public Parede montarParede() {
		// TODO Auto-generated method stub
		return new Gesso();
	}

	@Override
	public Porta montarPorta() {
		// TODO Auto-generated method stub
		return new MDF();
	}

	@Override
	public Metal montarMetal() {
		// TODO Auto-generated method stub
		return new Ferro();
	}

	@Override
	public Louca montarLouca() {
		// TODO Auto-generated method stub
		return new MaisBarata();
	}

}

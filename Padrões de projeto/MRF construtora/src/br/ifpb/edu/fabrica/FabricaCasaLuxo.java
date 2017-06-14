package br.ifpb.edu.fabrica;

import java.util.ArrayList;

import br.ifpb.edu.comodo.Comodo;
import br.ifpb.edu.comodo.Sala;
import br.ifpb.edu.componentes.louca.*;
import br.ifpb.edu.componentes.metal.*;
import br.ifpb.edu.componentes.parede.*;
import br.ifpb.edu.componentes.piso.*;
import br.ifpb.edu.componentes.porta.*;
import br.ifpb.edu.componentes.tinta.*;

public class FabricaCasaLuxo implements FabricaCasa {
	
	public Piso montarPiso() {
		return new Porcelanato();
	}
	
	public Tinta montarTinta() {
		return new SuperLavavel();
	}
	
	public Parede montarParede() {
		return new AlvenariaDryWall();
	}
	
	public Porta montarPorta() {
		return new MadeiraLei();
	}
	
	public Metal montarMetal() {
		return new Inox();
	}
	
	public Louca montarLouca() {
		return new Deca();
	}
}

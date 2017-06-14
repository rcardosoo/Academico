package br.ifpb.edu.fabrica;

import br.ifpb.edu.componentes.louca.Deca;
import br.ifpb.edu.componentes.louca.Louca;
import br.ifpb.edu.componentes.metal.Inox;
import br.ifpb.edu.componentes.metal.Metal;
import br.ifpb.edu.componentes.parede.AlvenariaDryWall;
import br.ifpb.edu.componentes.parede.Parede;
import br.ifpb.edu.componentes.piso.Piso;
import br.ifpb.edu.componentes.piso.Porcelanato;
import br.ifpb.edu.componentes.porta.MadeiraLei;
import br.ifpb.edu.componentes.porta.Porta;
import br.ifpb.edu.componentes.tinta.SuperLavavel;
import br.ifpb.edu.componentes.tinta.Tinta;

public interface FabricaCasa {
	public Piso montarPiso();
	public Tinta montarTinta();
	public Parede montarParede();
	public Porta montarPorta();
	public Metal montarMetal();
	public Louca montarLouca();
}

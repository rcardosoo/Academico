package br.ifpb.edu.comodo;

import java.util.ArrayList;

import br.ifpb.edu.componentes.louca.Louca;
import br.ifpb.edu.componentes.metal.Metal;
import br.ifpb.edu.componentes.parede.Parede;
import br.ifpb.edu.componentes.piso.Piso;
import br.ifpb.edu.componentes.porta.Porta;
import br.ifpb.edu.componentes.tinta.Tinta;

public abstract class Comodo {
	private Piso piso;
	private Tinta tinta;
	private ArrayList<Parede> paredes = new ArrayList<Parede>();
	private ArrayList<Porta> portas = new ArrayList<Porta>();
	private ArrayList<Metal> metais = new ArrayList<Metal>();
	private ArrayList<Louca> loucas = new ArrayList<Louca>();
	
	
	public Piso getPiso() {
		return piso;
	}
	
	public void setPiso(Piso piso) {
		this.piso = piso;
	}
	
	public Tinta getTinta() {
		return tinta;
	}
	
	public void setTinta(Tinta tinta) {
		this.tinta = tinta;
	}
	
	public ArrayList<Parede> getParedes() {
		return paredes;
	}
	
	public void setParedes(ArrayList<Parede> paredes) {
		this.paredes = paredes;
	}
	
	public ArrayList<Porta> getPortas() {
		return portas;
	}
	
	public void setPortas(ArrayList<Porta> portas) {
		this.portas = portas;
	}
	
	public ArrayList<Metal> getMetais() {
		return metais;
	}
	
	public void setMetais(ArrayList<Metal> metais) {
		this.metais = metais;
	}
	
	public ArrayList<Louca> getLoucas() {
		return loucas;
	}
	
	public void setLoucas(ArrayList<Louca> loucas) {
		this.loucas = loucas;
	}
	
	public void adicionarParede(Parede p) {
		this.paredes.add(p);
	}
	
	public void adicionarPorta(Porta p) {
		this.portas.add(p);
	}
	
	public void adicionarMetal(Metal m) {
		this.metais.add(m);
	}
	
	public void adicionarLouca(Louca l) {
		this.loucas.add(l);
	}
	
	
}

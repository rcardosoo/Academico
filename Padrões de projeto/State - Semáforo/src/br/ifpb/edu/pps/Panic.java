package br.ifpb.edu.pps;

public class Panic implements SemaforoState {

	@Override
	public SemaforoState tick() {
		// TODO Auto-generated method stub
		return new Panic();
		//ignora o tick em estado de panico
	}

	@Override
	public SemaforoState panic() {
		// TODO Auto-generated method stub
		return new Panic();
	}

	@Override
	public SemaforoState on() {
		// TODO Auto-generated method stub
		return new Vermelho();
	}

	@Override
	public SemaforoState off() {
		// TODO Auto-generated method stub
		return new Panic();
		//ignora o off em estado de panico
	}

	@Override
	public String toString() {
		return "Panic";
	}
	
}

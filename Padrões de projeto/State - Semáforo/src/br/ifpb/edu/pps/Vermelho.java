package br.ifpb.edu.pps;

public class Vermelho implements SemaforoState {

	@Override
	public SemaforoState tick() {
		// TODO Auto-generated method stub
		return new Verde();
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
		return new AmareloIntermitente();
	}
	
	@Override
	public String toString() {
		return "Vermelho";
	}
}

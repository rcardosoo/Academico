package br.ifpb.edu.pps;

public interface SemaforoState {
	public SemaforoState tick();
	public SemaforoState panic();
	public SemaforoState on();
	public SemaforoState off();
}

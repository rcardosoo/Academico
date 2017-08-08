package br.ifpb.edu.pps;

public class Semaforo {
	private SemaforoState estado;

	public Semaforo() {
		super();
		this.estado = new AmareloIntermitente();
	}
	
	public void tick() {
		this.estado = this.estado.tick();
		System.out.println("-- tick -- ");
		this.status();
	}
	
	public void panic() {
		this.estado = this.estado.panic();
		System.out.println("-- panic -- ");
		this.status();
	}
	
	public void on() {
		this.estado = this.estado.on();
		System.out.println("-- on -- ");
		this.status();
	}
	
	public void off() {
		this.estado = this.estado.off();
		System.out.println("-- off -- ");
		this.status();
	}
	
	public void status() {
		System.out.println("Estado atual do semáforo: "+this.estado+"\n");
	}
}

package br.ifpb.edu.pps;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Sistema iniciado === \n");
		Semaforo semaforo = new Semaforo();
		semaforo.status();
		semaforo.on();
		semaforo.tick();
		semaforo.tick();
		semaforo.panic();
		semaforo.tick();
		semaforo.on();
		semaforo.tick();
		semaforo.tick();
		semaforo.off();
		semaforo.tick();
		semaforo.on();
		
	}

}

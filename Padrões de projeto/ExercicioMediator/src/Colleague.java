
public abstract class Colleague {
	protected Mediator mediator;
	
	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public abstract void transferir(Double valor, Colleague destino);
	
	public abstract void receber(Double valor, Colleague origem);
}

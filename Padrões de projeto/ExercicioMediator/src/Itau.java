
public class Itau extends Colleague {

	public Itau(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receber(Double valor, Colleague origem) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName()+" Transferência recebida de "+origem.getClass().getSimpleName()+", valor: "+valor);
	}

	@Override
	public void transferir(Double valor, Colleague destino) {
		// TODO Auto-generated method stub
		mediator.transferir(valor, destino, this);
	}

}

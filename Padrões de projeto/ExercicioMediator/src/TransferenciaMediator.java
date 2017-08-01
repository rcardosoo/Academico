import java.util.ArrayList;

public class TransferenciaMediator implements Mediator {
	private ArrayList<Colleague> bancos;
	
	public TransferenciaMediator() {
		this.bancos = new ArrayList<Colleague>();
	}
	
	public void addColleague(Colleague c) {
		this.bancos.add(c);
	}
	
	@Override
	public void transferir(Double valor, Colleague destino, Colleague colleague) {
		// TODO Auto-generated method stub
		for(Colleague c : this.bancos) {
			if (c.equals(destino)) {
				c.receber(valor, colleague);
			} 
		}
	}

}

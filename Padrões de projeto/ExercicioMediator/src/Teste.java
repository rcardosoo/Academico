
public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransferenciaMediator mediator = new TransferenciaMediator();
		Colleague itau = new Itau(mediator);
		Colleague bb = new BB(mediator);
		Colleague bradesco = new Bradesco(mediator);
		Colleague cef = new CEF(mediator);
		
		mediator.addColleague(itau);
		mediator.addColleague(bb);
		mediator.addColleague(bradesco);
		mediator.addColleague(cef);
		
		itau.transferir(1200.00, bradesco);
		bb.transferir(2000.00, cef);
	}

}

package tipo;

public class Lancamento implements Tipo {
	private Double precoFixo=0.0;
	
	@Override
	public Double calcularValor(int dias) {
		// TODO Auto-generated method stub
		return dias*3.0;
	}

	@Override
	public int bonus(int dias) {
		// TODO Auto-generated method stub
		if (dias > 1)
			return 1;
		else
			return 0;
	}

}

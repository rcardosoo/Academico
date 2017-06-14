package tipo;

public class Normal implements Tipo {
	private Double precoFixo=2.0;
	
	@Override
	public Double calcularValor(int dias) {
		// TODO Auto-generated method stub
		if (dias > 2)
			return ((dias-2)*1.5)+precoFixo;
		else
			return precoFixo;
	}

	@Override
	public int bonus(int dias) {
		// TODO Auto-generated method stub
		return 0;
	}

}

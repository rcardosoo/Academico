package tipo;

public class Infantil implements Tipo {
	private Double precoFixo=1.5;
	
	@Override
	public Double calcularValor(int dias) {
		// TODO Auto-generated method stub
		if (dias > 3)
			return ((dias-3)*1.5)+precoFixo;
		else
			return precoFixo;
	}

	@Override
	public int bonus(int dias) {
		// TODO Auto-generated method stub
		return 0;
	}

}

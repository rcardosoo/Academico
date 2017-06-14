
public class FabricaNome {
	public static Nome getNome(String nome) {
		if (nome.contains(","))
			return new NomeInvertido(nome);
		else
			return new NomeComum(nome);
	}
}

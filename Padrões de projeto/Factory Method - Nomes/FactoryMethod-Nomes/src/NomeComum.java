
public class NomeComum implements Nome {
	private String nome;
	
	public NomeComum(String nome) {
		this.nome = nome;
	}

	@Override
	public String organizaNome() {
		return this.nome;
	}
}

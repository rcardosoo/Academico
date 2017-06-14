
public class NomeInvertido implements Nome {
	private String nome;
	
	public NomeInvertido(String nome) {
		this.nome = nome;
	}

	@Override
	public String organizaNome() {
		String aux[];
		String nome, sobrenome;
		
		aux= this.nome.split(",");
		sobrenome = aux[0];
		nome = aux[1];
		this.nome = nome+" "+sobrenome;
		
		return this.nome;
	}
}

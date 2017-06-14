
public class Teste {

	public static void main(String[] args) {
		Nome nome1 = FabricaNome.getNome("McNealy, Scott");
		Nome nome2 = FabricaNome.getNome("James Gosling");
		Nome nome3 = FabricaNome.getNome("Naughton, Patrick");
		
		System.out.println(nome1.organizaNome());
		System.out.println(nome2.organizaNome());
		System.out.println(nome3.organizaNome());
	}

}

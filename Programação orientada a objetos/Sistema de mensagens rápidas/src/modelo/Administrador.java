package modelo;

public class Administrador extends Funcionario {

	public Administrador(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Administrador [Nome: " + getNome() + ", Email: " + getEmail()
				+ ", Departamento: " + getDepartamento() + "]";
	}

}

package modelo;

public class Funcionario extends Pessoa {
	String departamento;

	public String getDepartamento() {
		return departamento;
	}

	@Override
	public String toString() {
		return "Funcionario [Nome: "+getNome() + ", Email: " + getEmail()
				+ ", Departamento: " + getDepartamento() + "]";
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Funcionario(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}

}

package modelo;

public class Aluno extends Pessoa {
	String curso;
	
	@Override
	public String toString() {
		return "Aluno [Nome: " + getNome() + ", Email: " + getEmail()
				+ ", Curso: " + getCurso() + "]";
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Aluno(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}

}

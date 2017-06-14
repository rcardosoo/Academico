package modelo;

public class Mensagem {
	private int id;
	private Pessoa emitente;
	private Pessoa destinatario;
	private String texto;
	private String data;
	private boolean lida;
	
	public Mensagem(int id, String texto, String data, boolean lida) {
		super();
		this.id = id;
		this.texto = texto;
		this.data = data;
		this.lida = lida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	}
	
	//-------------------------------
	
	public Pessoa getEmitente() {
		return emitente;
	}

	public void setEmitente(Pessoa emitente) {
		this.emitente = emitente;
	}

	public Pessoa getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Pessoa destinatario) {
		this.destinatario = destinatario;
	}

	@Override
	public String toString() {
		return "Mensagem: \n---------------------------------"
				+ "\nid=" + id +
				", " + (emitente != null ? "emitente=" + emitente.getNome() + "" : "Sem emitente")+
				", " + (destinatario != null ? "destinatario=" + destinatario.getNome() + "" : "Sem destinatario")+
				", " + (texto != null ? "\ntexto=" + texto + "" : "")+
				"\n" + (data != null ? "data=" + data + "" : "")+
				"\nlida=" + lida+"\n---------------------------------";
	}

	
	
}

package fachada;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

import dao.DAO;
import dao.DAOPassageiro;
import dao.DAOPassagem;
import dao.DAOPoltrona;
import dao.DAOVoo;
import modelo.Passageiro;
import modelo.Passagem;
import modelo.Poltrona;
import modelo.Voo;

public class Sistema {
	private static DAOPassagem daopassagem = new DAOPassagem();
	private static DAOPoltrona daopoltrona = new DAOPoltrona();
	private static DAOPassageiro daopassageiro = new DAOPassageiro();
	private static DAOVoo daovoo = new DAOVoo();

	public static void inicializar(){
		DAO.abrir();
	}

	public static void finalizar(){
		DAO.fechar();
	}


	// Cadastrar passageiro
	public static Passageiro cadastrarPassageiro(String nome, int cpf)
			throws Exception {
		DAO.iniciar();
		Passageiro p = daopassageiro.localizarPeloCpf(cpf);
		if (p!=null)
			throw new Exception("Passageiro cadastrado: " + nome);

		p = new Passageiro(nome, cpf);
		daopassageiro.persistir(p);
		DAO.efetivar();
		return p;
	}		

	// Cadastrar voo
	public static Voo cadastrarVoo(int numero, String origem, String destino, GregorianCalendar dataViagem )
			throws Exception {
		DAO.iniciar();
		Voo v = daovoo.localizarVoo(numero);
		if (v!=null)
			throw new Exception("Voo nao cadastrado: " + numero);

		v = new Voo(numero, origem , destino, dataViagem);
	
		
		daovoo.persistir(v);
		DAO.efetivar();
		criarPoltronas(v.getNumero());
		return v;
	}
	
	public static void criarPoltronas(int voo) {
		//criar poltronas
		DAO.iniciar();
		Voo v = daovoo.localizarVoo(voo);
		
		for (int i=1; i <= 5;i++) {
			Poltrona p = new Poltrona(null, false);
			v.addPoltrona(p);
			daovoo.atualizar(v);
			daopoltrona.persistir(p);
		}
		DAO.efetivar();
	}

	//Comprar passagem | D�vida: como fazer para a poltrona receber o valor true? 	
	public static Passagem comprarPassagem(double valor, int cpf, int numVoo) 
			throws  Exception {
		DAO.iniciar();
		Passageiro p = daopassageiro.localizarPeloCpf(cpf);
		if(p == null) 
			throw new Exception("Passageiro nao cadastrado:" + cpf);

		Voo v = daovoo.localizarVoo(numVoo);
		if(v == null)
			throw new Exception("Voo inexistente:" + numVoo);
		
		if (v.getPoltronaVazia() == -1)
			throw new Exception("Nao tem poltrona disponivel");
		
		Poltrona pt = daopoltrona.localizarPeloNumero(v.getPoltronaVazia());
		pt.setPassageiro(p);
		pt.setOcupacao(true);
	
		
		// PV � abreviacao de passagem vendida
		Passagem pv = new Passagem(valor, p, v);
		p.addPassagem(pv);
		v.addPassagem(pv);
		
		//daopoltrona.atualizar(pt);
		//daovoo.atualizar(v);
		daopassagem.persistir(pv);
		DAO.efetivar();
		return pv;
	}

	
	public static void alterarPassagem(int numPassagem, double valorNovo, int numVoo, int cpf) 
			throws  Exception {
		DAO.iniciar();
		Passagem p = daopassagem.localizarPeloNumero(numPassagem);
		if(p == null) 
			throw new Exception("Passagem nao cadastrado:" + numPassagem);
		
		Passageiro ps = daopassageiro.localizarPeloCpf(cpf);
		if(ps == null)
			throw new Exception("Passageiro inexistente");
		
		Voo vantigo = daovoo.localizarVoo(p.getVoo().getNumero());
		vantigo.removerPassagem(p);
		Poltrona pantiga = daopoltrona.poltronadePassageiro(ps.getCpf());
		pantiga.setPassageiro(null);
		pantiga.setOcupacao(false);
		
		Voo v = daovoo.localizarVoo(numVoo);
		if(v == null)
			throw new Exception("Voo inexistente");
	
		if (v.getPoltronaVazia() == -1)
			throw new Exception("Nao tem poltrona disponivel");
		
		p.setPassageiro(ps);
		v.addPassagem(p);
		p.setValor(valorNovo);
		p.setVoo(v);
		
		Poltrona pt = daopoltrona.localizarPeloNumero(v.getPoltronaVazia());
		pt.setPassageiro(ps);
		pt.setOcupacao(true);
		v.addPoltrona(pt);
		
		daovoo.atualizar(vantigo);
		daopoltrona.atualizar(pantiga);
		daopoltrona.atualizar(pt);
		daovoo.atualizar(v);
		daopassagem.atualizar(p);
		DAO.efetivar();
	}

	
	public static void cancelarPassagem(int numPassagem) 
			throws  Exception {
		DAO.iniciar();
		Passagem p = daopassagem.localizarPeloNumero(numPassagem);
		if(p == null) 
			throw new Exception("Passagem nao encontrada:" + numPassagem);
		
		Voo v = p.getVoo();
		
		
		v.removerPassagem(p);		
		Passageiro ps = p.getPassageiro();
		
		Poltrona pt = daopoltrona.poltronadePassageiro(ps.getCpf());
		if (pt != null) {
			pt.setOcupacao(false);
			pt.setPassageiro(null);
		}
		ps.removerPassagem(p);
		
		p.setVoo(null);
		p.setPassageiro(null);

		daopoltrona.atualizar(pt);
		daopassageiro.atualizar(ps);
		daovoo.atualizar(v);
		daopassagem.apagar(p);
		DAO.efetivar();
	}

	
	public static void cancelarVoo(int numVoo) 
			throws  Exception {
		DAO.iniciar();
		Voo v = daovoo.localizarVoo(numVoo);
		if(v == null) 
			throw new Exception("Voo nao encontrado:" + numVoo);
	

		daovoo.apagar(v);
		DAO.efetivar();
	}
	
	public static void excluirPassageiro(int cpf) 
			throws  Exception {
		DAO.iniciar();
		Passageiro p = daopassageiro.localizarPeloCpf(cpf);
		if(p == null) 
			throw new Exception("Passageiro nao encontrado:" + cpf);
		for (Passagem ps : p.getPassagens()) {
			cancelarPassagem(ps.getNumPassagem());
			daopassagem.apagar(ps);
		}
		p.setPassagens(null);
		daopassageiro.atualizar(p);
		daopassageiro.apagar(p);
		DAO.efetivar();
	}

	//Alterar data do voo
	public static void alterarVoo(int numVoo, GregorianCalendar dataNova) 
			throws  Exception {
		DAO.iniciar();
		Voo v = daovoo.localizarVoo(numVoo);
		if(v == null) 
			throw new Exception("Voo nao encontrado:" + numVoo);

		v.setDataViagem(dataNova);
		daovoo.atualizar(v);
		DAO.efetivar();
	}
	
	public static String listarPassagens() {
		List<Passagem> aux = daopassagem.listar();
		String texto = "Listagem de passagens: \n";
		if (aux.isEmpty())
			texto += "n�o tem passagens";
		else {	
			for(Passagem p: aux) {
				texto += "\n" + p; 
			}
		}

		return texto;		
	}
	
	public static String listarVoo() {
		List<Voo> aux = daovoo.listar();
		String texto = "Listagem de voos: \n";
		if (aux.isEmpty())
			texto += "n�o tem voos";
		else {	
			for(Voo v: aux) {
				texto += "\n" + v; 
			}
		}

		return texto;		
	}
	
	public static String listarPassageiros() {
		List<Passageiro> aux = daopassageiro.listar();
		String texto = "Listagem de passageiros: \n";
		if (aux.isEmpty())
			texto += "n�o tem passageiros";
		else {	
			for(Passageiro p: aux) {
				texto += "\n" + p; 
			}
		}

		return texto;		
	}
	
	public static String listarPoltronas() {
		List<Poltrona> aux = daopoltrona.listar();
		String texto = "Listagem de poltronas: \n";
		if (aux.isEmpty())
			texto += "n�o tem poltronas";
		else {	
			for(Poltrona p: aux) {
				texto += "\n" + p; 
			}
		}

		return texto;		
	}
	
	//outras consultas:
	
	public static String consultarPassageirosdoVoo(int num) {
		String texto = "Passageiros do voo "+num+": \n";
		return texto += daopassageiro.consultarPassageirosdoVoo(num);
	
	}
	
	public static String consultarVoosparaCidade(String cidade) {
		String texto = "Voos para "+cidade+": \n";
		return texto += daovoo.consultarVoosparaCidade(cidade);
	}
	
	public static String consultarVagasemVoo(int num) {
		String texto = "Vagas no voo "+num+": \n";
		return texto += daopoltrona.consultarVagasemVoo(num);
	}
	
	public static String consultarPassageirosSemVoo() {
		String texto = "Passageiros sem voo: \n";
		return texto += daopassageiro.consultarPassageirosSemVoo();
	}
	
}

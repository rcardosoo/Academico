package aplicacao;
/* 
 	Projeto SMR - Rafael Cardoso
 	Matricula: 20151370286
*/
import java.util.Scanner;

import fachada.Sistema;
import modelo.Pessoa;
import modelo.Mensagem;

public class AplicacaoInterativa {
	private Scanner teclado = new Scanner(System.in);

	public AplicacaoInterativa() {   
		processarMenu();
	}

	public  void processarMenu() {
		String entrada;
		int opcao;
		System.out.println("\n=========== Bem vindo ao SMR ===========");
		try {	
			// dados criados para teste
			Pessoa p1, p2, p3, p4, p5;//cadastro de 4 pessoas
			p1 = Sistema.cadastrarPessoa("Jose", "jose@gmail.com", "123", "Sistemas", 1);
			p2 = Sistema.cadastrarPessoa("Maria", "maria@gmail.com", "123", "Redes", 1);
			p3 = Sistema.cadastrarPessoa("Joana", "joana@gmail.com", "123", "DP1", 2);
			p4 = Sistema.cadastrarPessoa("Marcelo", "marcelo@gmail.com", "123", "DP2", 2);
			p5 = Sistema.cadastrarPessoa("admin", "admin@ifpb.com", "007", "DTI", 3);

			Pessoa pjose = Sistema.login("jose@gmail.com", "123");
			Mensagem m1 = Sistema.enviarMensagem("maria@gmail.com", "Ola maria, tudo bem?");
			Sistema.logoff();

			Pessoa pmaria = Sistema.login("maria@gmail.com", "123");
			Mensagem m2 = Sistema.enviarMensagem("jose@gmail.com", "Ola jose, estou bem e voce?");
			Mensagem m3 = Sistema.enviarMensagem("joana@gmail.com", "Lorem ipsum dolor sit amet,"
					+ " consectetur adipiscing elit. Donec at egestas mauris. Nam eget congue felis.");
			Sistema.logoff();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		do {
			
			if (Sistema.temLogado() == false) {
				exibirMenu();
				try{
					entrada = teclado.nextLine();
					opcao = Integer.parseInt(entrada);
					switch (opcao) {
					case 0:	break;
					case 1:	tarefa_login();	break;
					default: System.out.println("Opcaoo Invalida !! \n");
					}
				}
				catch(NumberFormatException e)	{
					System.out.println("Digite somente numero! \n");
					opcao=-1;
				}
				catch(Exception e)	{
					System.out.println("erro:" + e.getMessage());
					//e.printStackTrace();
					opcao=-1;
				}
			} else {
				exibirMenu2();
				try{
					entrada = teclado.nextLine();
					opcao = Integer.parseInt(entrada);
					switch (opcao) {
					case 0:	break;
					case 1:	tarefa_login();							break;
					case 2:	tarefa_logoff();						break;
					case 3:	tarefa_cadastrarPessoa();				break;
					case 4: tarefa_listarPessoas();					break;
					case 5: tarefa_enviarMensagem();				break;
					case 6: tarefa_listarCaixaEntrada();			break;
					case 7: tarefa_listarCaixaSaida();				break;
					case 8: tarefa_lerMensagem();					break;
					case 9: tarefa_totalNaoLidas();					break;
					case 10:tarefa_apagarMensagem();				break;
					case 11:tarefa_consultar();				        break;
					default: System.out.println("Opcaoo Invalida !! \n");
					}
				}
				catch(NumberFormatException e)	{
					System.out.println("Digite somente n�mero! \n");
					opcao=-1;
				}
				catch(Exception e)	{
					System.out.println("erro:" + e.getMessage());
					//e.printStackTrace();
					opcao=-1;
				}
			}		
		}while (opcao != 0);
		System.out.println("\n <-- Ate Breve -->");
	}


	public void exibirMenu() {
		System.out.println("\n\n| - - - - - - -  Menu  - - - - - - - - -");
		System.out.println("|  [0]- Sair                             ");
		System.out.println("|  [1]- Login			         	     ");
		System.out.println("| - - - - - - - - - - - - - - - - - - - -");
		System.out.print("  Opcao :");
	}

	public void exibirMenu2() {
		System.out.println("\n\n| - - - - - - -  Menu  - - - - - - - - -");
		System.out.println("|  [0]- Sair                             ");
		System.out.println("|  [1]- Login			         	     ");
		System.out.println("|  [2]- Logoff				             ");
		System.out.println("|  [3]- Cadastrar pessoa			     ");
		System.out.println("|  [4]- Listar pessoas                   ");
		System.out.println("|  [5]- Enviar mensagem	                 ");
		System.out.println("|  [6]- Listar caixa de entrada          ");
		System.out.println("|  [7]- Listar caixa de saida            ");
		System.out.println("|  [8]- Ler mensagem                     ");
		System.out.println("|  [9]- Total de mensagens nao lidas     ");
		System.out.println("|  [10]- Apagar mensagem                 ");
		System.out.println("|  [11]- Consultar                       ");
		System.out.println("| - - - - - - - - - - - - - - - - - - - -");
		System.out.print("  Opcao :");
	}

	//	---------------------------------------	
	public void tarefa_login(){
		//	---------------------------------------			
		Pessoa p;
		String email;
		String senha;
		System.out.println("\n=== LOGIN ===");
		System.out.print("Informe o email: ");
		email = teclado.nextLine();	
		System.out.print("Informe a senha: ");
		senha = teclado.nextLine();

		try {
			p = Sistema.login(email,senha);
			System.out.println("\n\n--- Bem vindo(a), "+ p.getNome() +" ---");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//	---------------------------------------	
	public void tarefa_logoff(){
		//	---------------------------------------			
		try {
			Sistema.logoff();
			System.out.println("\nLogoff realizado com sucesso!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	//	---------------------------------------	
	public void tarefa_cadastrarPessoa(){
		//	---------------------------------------			
		Pessoa p;
		int ident;
		int aux = 0;
		String nome;
		String email;
		String senha;
		String curso = null;
		String departamento = null;
		System.out.println("\n=== CADASTRAR ===");
		System.out.println("Deseja cadastrar aluno ou funcionario? [1-aluno 2-funcionario 3-administrador]");
		ident = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Informe o nome: ");
		nome = teclado.nextLine();
		System.out.println("Informe o email: ");
		email = teclado.nextLine();
		System.out.println("Informe a senha: ");
		senha = teclado.nextLine();
		if (ident == 1) {
			System.out.println("Informe o curso: ");
			curso = teclado.nextLine();
		} else {
			System.out.println("Informe o departamento: ");
			departamento = teclado.nextLine();
		}

		try {
			if (ident == 1) {
				p = Sistema.cadastrarPessoa(nome, email, senha, curso, ident);
			} else {
				p = Sistema.cadastrarPessoa(nome, email, senha, departamento, ident);
			}
			System.out.println(p.getNome()+" cadastrado(a) com sucesso!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//	---------------------------------------	
	public void tarefa_listarPessoas(){
		//	---------------------------------------	

		String lista;
		String nome;
		System.out.println("\n=== LISTAR PESSOA ===");
		System.out.println("Informe o nome para listagem: ");
		nome = teclado.nextLine();

		try {
			lista = Sistema.listarPessoas(nome);
			System.out.println(lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//	---------------------------------------	
	public void tarefa_enviarMensagem(){
		//	---------------------------------------	

		String email;
		String texto;
		Mensagem msg;
		System.out.println("\n=== ENVIAR MENSAGEM ===");
		System.out.println("Informe o email do destinatario: ");
		email = teclado.nextLine();
		System.out.println("Digite a mensagem: ");
		texto = teclado.nextLine();

		try {
			msg = Sistema.enviarMensagem(email, texto);
			System.out.println("Mensagem enviada com sucesso!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//	---------------------------------------	
	public void tarefa_listarCaixaEntrada() {
		//	---------------------------------------		
		String lista;
		System.out.println("\n=== LISTAR ENTRADA ===");
		try {
			lista = Sistema.listarMensagensEntrada();
			System.out.println(lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	//	---------------------------------------	
	public void tarefa_listarCaixaSaida() {
		//	---------------------------------------		
		String lista;
		System.out.println("\n=== LISTAR SAIDA ===");
		try {
			lista = Sistema.listarMensagensSaida();
			System.out.println(lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	//	---------------------------------------	
	public void tarefa_lerMensagem() {
		//	---------------------------------------		
		String id;
		Mensagem m;
		System.out.println("\n=== LER MENSAGEM ===");
		System.out.println("Informe o codigo da mensagem: ");
		id = teclado.nextLine();

		try {
			int i = Integer.parseInt(id);
			m = Sistema.lerMensagem((i));
			System.out.println(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	//	---------------------------------------	
	public void tarefa_totalNaoLidas() {
		//	---------------------------------------		

		int total;
		System.out.println("\n=== TOTAL NAO LIDAS ===");

		try {
			total = Sistema.totalMensagensNaoLidas();
			System.out.println("Voce tem "+total+" mensagens nao lidas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
	
//	---------------------------------------	
	public void tarefa_apagarMensagem() {
//	---------------------------------------		

		
		String id;
		System.out.println("\n=== APAGAR MENSAGEM ===");
		System.out.println("Informe o codigo da mensagem: ");
		id = teclado.nextLine();

		try {
			int i = Integer.parseInt(id);
			Sistema.apagarMensagem((i));
			System.out.println("Mensagem ["+ i +"] apagada com sucesso1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	


	}
	
//	---------------------------------------	
	public void tarefa_consultar(){
		//	---------------------------------------	

		String lista;
		String busca;
		System.out.println("\n=== CONSULTAR MENSAGEM ===");
		System.out.println("Digite algo para buscar: ");
		busca = teclado.nextLine();

		try {
			lista = Sistema.buscarMensagem(busca);
			System.out.println(lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new AplicacaoInterativa();
	}

}

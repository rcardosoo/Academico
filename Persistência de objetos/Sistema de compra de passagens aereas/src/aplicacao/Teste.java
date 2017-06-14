package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;

import fachada.Sistema;
import modelo.*;

public class Teste {

	public Teste() {
		Sistema.inicializar();

		try {
//			Passageiro p1, p2, p3, p4, p5, p6, p7;
//			p1 = Sistema.cadastrarPassageiro("Joao", 1);
//			p2 = Sistema.cadastrarPassageiro("Maria", 2);
//			p3 = Sistema.cadastrarPassageiro("Jose", 3);
//			p4 = Sistema.cadastrarPassageiro("Paulo", 4);
//			p5 = Sistema.cadastrarPassageiro("Marta", 5);
//			p6 = Sistema.cadastrarPassageiro("Luiz", 6);
//			p7 = Sistema.cadastrarPassageiro("Marcos", 7);
//			
//			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//			GregorianCalendar cal = new GregorianCalendar();
//			Voo v1, v2;
//			v1 = Sistema.cadastrarVoo(1, "Joao Pessoa", "Sao Paulo", cal);
//			v1 = Sistema.cadastrarVoo(2, "Joao Pessoa", "Manaus", cal);
//			
//		
//			Passagem ps1, ps2, ps3, ps4, ps5, ps6;
//			ps1 = Sistema.comprarPassagem(250.0, 1, 1);
//			ps2 = Sistema.comprarPassagem(200.0, 4, 1);
//			ps3 = Sistema.comprarPassagem(120.0, 5, 1);
//			ps4 = Sistema.comprarPassagem(420.5, 6, 2);
//			ps5 = Sistema.comprarPassagem(390.0, 3, 2);
//			ps6 = Sistema.comprarPassagem(500.0, 2, 2);
			
//			String texto;
//			texto = Sistema.listarPassageiros();
//			System.out.println(texto);
//			
//			texto="";
//			texto = Sistema.listarPassagens();
//			System.out.println(texto);
//			
//			texto="";
//			texto = Sistema.listarVoos();
//			System.out.println(texto);
//			
			
//			System.out.println(Sistema.consultarPassageirosdoVoo(1));
//			System.out.println(Sistema.consultarVoosparaCidade("Manaus"));
//			System.out.println(Sistema.consultarVagasemVoo(2));
//			System.out.println(Sistema.consultarPassageirosSemVoo());
//			System.out.println(Sistema.poltronadePassageiro(1));
			
			System.out.println("\n\n----------------------\n\n");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Sistema.finalizar();
		
		System.out.println("fim do programa");
	}


	//  ***********************************************
	public static void main (String[] args)
	//  ***********************************************
	{
		Teste ap1 = new Teste();
	}

}

package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import java.time.LocalDate;

import fachada.Sistema;
import modelo.*;

public class Teste2 {

	public Teste2() {
		Sistema.inicializar();

		try {
			//consultas e testes
			
			
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
		Teste2 ap1 = new Teste2();
	}

}

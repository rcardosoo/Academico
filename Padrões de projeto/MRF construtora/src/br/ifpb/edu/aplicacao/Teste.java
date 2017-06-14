package br.ifpb.edu.aplicacao;

import java.util.Scanner;

import br.ifpb.edu.casa.*;
import br.ifpb.edu.comodo.*;
import br.ifpb.edu.fabrica.*;

public class Teste {

	public static FabricaCasa obterFabricaCasa(String tipo) {
		FabricaCasa fc;
		switch(tipo) {
		case "luxo":
			fc = new FabricaCasaLuxo();
			break;
		case "conforto":
			fc = new FabricaCasaConforto();
			break;
		case "basica":
			fc = new FabricaCasaBasica();
			break;
		default:
			fc = new FabricaCasaBasica();
		}
		return fc;
	}

	public static Comodo criarComodo(String nome) {
		Comodo comodo = FabricaComodo.criarComodo(nome);
		if (comodo == null) {
			System.out.println("Não foi possivel criar o comodo!");
			return null;
		} else {
			return comodo;
		}
	}

	public static void main(String[] args) {
	
		System.out.println("Iniciando projeção da casa..\n");
		System.out.println("\n----------------------------\n");
		
		/* 
		 * A operação de criação dos componentes esta no main porque a criação
		 * deve ser dimamica, com base no tipo e quantidade que o arquiteto informa
		*/
		FabricaCasa FabricaCasa = obterFabricaCasa("conforto");
		Comodo comodo = criarComodo("banheiro");
		comodo.setPiso(FabricaCasa.montarPiso());
		comodo.setTinta(FabricaCasa.montarTinta());
		comodo.adicionarParede(FabricaCasa.montarParede());
		comodo.adicionarParede(FabricaCasa.montarParede());
		comodo.adicionarParede(FabricaCasa.montarParede());
		comodo.adicionarParede(FabricaCasa.montarParede());
		comodo.adicionarPorta(FabricaCasa.montarPorta());
		comodo.adicionarPorta(FabricaCasa.montarPorta());
		comodo.adicionarMetal(FabricaCasa.montarMetal());
		comodo.adicionarMetal(FabricaCasa.montarMetal());
		comodo.adicionarLouca(FabricaCasa.montarLouca());
		
		Casa casa = new Casa();
		casa.adicionarComodo(comodo);
		System.out.println("Casa criada:\n");
		System.out.println(casa);
		
	}

}

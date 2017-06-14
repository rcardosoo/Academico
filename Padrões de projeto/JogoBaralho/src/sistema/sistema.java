package sistema;

import java.util.Scanner;

import classes.Baralho;
import classes.Jogador;
import classes.Jogo;
import classes.distribuicao.*;

public class sistema {
	
	public static void jogar(int modo, Jogador j1, Jogador j2, Baralho b) {
		Jogo jogo = new Jogo();
		boolean flagRodada;
		int exit;
		Scanner teclado = new Scanner(System.in);
		
		//definir modo de jogo
		if (modo == 1) {
			jogo.setAlgoritmo(new Dist1());
		} else if (modo == 2) {
			jogo.setAlgoritmo(new Dist2());
		} else {
			jogo.setAlgoritmo(new Dist3());
		}
		
		//setar baralho e jogadores
		jogo.setB(b);
		jogo.setJogador1(j1);
		jogo.setJogador2(j2);
		
		//rodadas..
		do {
			
			//distribui cartas
			jogo.distribuir();
			flagRodada = jogo.checar();
			System.out.println("========== Rodada "+(jogo.getRodada())+" ===========");
			System.out.println("Jogador 1 ["+jogo.getJogador1().getNome()+"] - Pontos: "+jogo.getJogador1().getPontos());
			System.out.println("Jogador 2 ["+jogo.getJogador2().getNome()+"] - Pontos: "+jogo.getJogador2().getPontos());
			if (!flagRodada)
				break;
			System.out.println("Proxima rodada? [1-rodar 2-sair]");
			exit = teclado.nextInt();
		} while (flagRodada && exit==1);
		
		if (flagRodada)
			System.out.println("..Finalizando");
		
		System.out.println("======== Fim do jogo =========");
	}
	
}

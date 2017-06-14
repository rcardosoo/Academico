package Teste;

import locadora.Aluguel;
import locadora.Cliente;
import locadora.Fita;
import tipo.*;

public class Locadora {
	public static void main(String[] args) {
		Cliente c1 = new Cliente("Juliana");
		c1.adicionaAluguel(new Aluguel(new Fita("O Exorcista                   ", new Normal()), 3));
		c1.adicionaAluguel(new Aluguel(new Fita("Men in Black                  ", new Normal()), 2));
		c1.adicionaAluguel(new Aluguel(new Fita("Jurassic Park III             ", new Lancamento()), 3));
		c1.adicionaAluguel(new Aluguel(new Fita("Planeta dos Macacos           ", new Lancamento()), 4));
		c1.adicionaAluguel(new Aluguel(new Fita("Pateta no Planeta dos Macacos ", new Infantil()), 10));
		c1.adicionaAluguel(new Aluguel(new Fita("O Rei Leao                    ", new Infantil()), 30));

		System.out.println(c1.extrato());
		System.out.println(c1.pontosAlugador());
	}
}

//===================================

//Refatoração Locadora de filmes
//
//- Criar interface TIPO de fita
//	- método calcularValor
//	- método Bonus
//
//- Criar classes tipo de fita e implementar interface
//
//Obs: A interface foi criada pois, caso seja criado outro tipo de fita, irá funcionar isoladamente.
//E caso seja criada alguma característica de pontos por tipo, irá funcionar isoladamente.
//
//- Construtor de fita recebe tipo
//
//- Criando fitas com tipo no Teste
//
//- Adicionando calculo de valor por Tipo
//
//- Adicionado chamada p/ valorAluguel em extrato
//
//- Novo método em cliente: pontosAlugador
//	- atributo pontos para classe cliente
//
//- Novo método em Aluguel: verificarBonus

//==================================
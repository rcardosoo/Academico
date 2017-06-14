/*
    PROJETO FINAL
    ESTRUTURA DE DADOS

    EQUIPE:
        -> RAFAEL CARDOSO 20151370286
        -> MANOEL ANGELO  20151370340
        -> WALTER GUEDES  ---

*/
#include "funcoes.h"

int main() {
	tarv t1;

	abbcriar(&t1); //CRIA ARVORE
	indexar(&t1); //ESCREVE REGISTROS DO ARQUIVO (SE EXISTIR) NA ARVORE

    sockservidor(t1); //OBTEM DADOS VIA SOCKET E CONTINUA O PROGRAMA COM BASE NA FLAG.

	return 0;
}



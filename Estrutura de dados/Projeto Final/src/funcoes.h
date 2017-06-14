#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <winsock.h>
#include <winsock2.h>
#include <strings.h>

typedef struct {
	int mat;
	char nome[20];
	double sal;
}tfunc;

typedef struct no {
	struct no *esq;
	struct no *dir;
	int matricula;
	int indice;
}tno;

typedef tno *tarv;

void showmenu();
void sockservidor(tarv t1);
void filtro(tfunc dados, tarv t1, int op);

//FUNCOES DE ARQUIVO:
void inserirdado(tarv *t, tfunc d);
void buscarfunc(tarv t, tfunc d);
void listar();
void indexar(tarv *t);
void alterasal(tarv t, tfunc d);
void reorganizar(tarv t);

//FUNCOES DA ARVORE:
void abbcriar(tarv *t);
int abbinserir(tarv *t, int mat, int id);
int abbbuscar(tarv t, int mat);
void abbexibir(tarv t);
void abbremove(tarv *t, int mat);
void abbesvaziar(tarv *t);



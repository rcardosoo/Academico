#include "funcoes.h"

void showmenu() {
        system("cls");
    	printf("\n#############################################\n\n");
		printf(" [1] - Inserir um novo funcionario\n");
		printf(" [2] - Alterar salario de um funcionario\n");
		printf(" [3] - Excluir um funcionario\n");
		printf(" [4] - Listar dados de um funcionario\n");
		printf(" [5] - Listar todos os funcionarios\n");
		printf(" [6] - Listar a estrutura de indices\n");
		printf(" [7] - Reindexar\n");
		printf(" [8] - Excluir todos os registros do arquivo\n");
		printf(" [9] - Fechar conexao\n");
		printf("\n#############################################\n");
}

void filtro(tfunc dados, tarv t1, int op) {
        int matremove;
    	switch (op) {
		case 1:
		    system("cls");
			inserirdado(&t1, dados);
			op = 0;;
			break;
		case 2:
		    system("cls");
            alterasal(t1, dados);
			op = 0;
			break;
		case 3:
		    system("cls");
		    printf("Digite a matricula para remover: ");
		    scanf("%d", &matremove);
            abbremove(&t1, matremove);
			op = 0;
			break;
		case 4:
		    system("cls");
            buscarfunc(t1, dados);
			op = 0;
			break;
        case 5:
		    system("cls");
            listar();
			op = 0;
			break;
        case 6:
		    system("cls");
            abbexibir(t1);
			op = 0;
			break;
        case 7:
		    system("cls");
		    reorganizar(t1);
		    abbesvaziar(&t1);
		    indexar(&t1);
			op = 0;
			break;
        case 8:
		    system("cls");
            abbesvaziar(&t1);
            reorganizar(t1);
			op = 0;
			break;
         case 9:
		    system("cls");
            reorganizar(t1);
			exit(0);
			break;
    	}
}

void inserirdado(tarv *t, tfunc d) {
	int aux;
	int pos;
	FILE *arq;

	arq = fopen("dados.bin", "a+b");
	if (arq == NULL) {
		printf("problema ao abrir arquivo!\n");
		return;
	}

    fwrite(&d,sizeof(tfunc),1,arq); //ESCREVE O DADO NO ARQUIVO
    fseek(arq,0,SEEK_END); //COLOCA O PONTEIRO DO ARQUIVO NO FINAL
	pos = ftell(arq); //OBTEM O TAMANHO DO ARQUIVO EM BYTES
	aux = abbinserir(t,d.mat,pos/sizeof(tfunc)); //INSERE A MATRICULA E O INDICE NA ARVORE
	if (aux == 0) {
        system("cls");
		printf("Dados inseridos com sucesso!\n");
	} else {
	    system("cls");
		printf("Problema ao indexar dado!\n");
	}
	fclose(arq);
}

void buscarfunc(tarv t, tfunc d) {
    int mat;
    int indice;
    FILE *arq;

    mat = d.mat;
    indice = abbbuscar(t,mat); //PROCURA A MATRICULA NA ARVORE
    if (indice == -1) {
        printf("Funcionario nao existe");
    } else {
        arq = fopen("dados.bin", "rb");
        if (arq == NULL){
            printf("Problema ao abrir arquivo!");
            return;
    }
        fseek(arq,(indice-1)*sizeof(tfunc),SEEK_SET); //COLOCA O PONTEIRO DO ARQUIVO ANTES DO REGISTRO
        fread(&d,sizeof(tfunc),1,arq);
        printf("\n");
		printf("Nome: %s\n", d.nome);
		printf("Matricula: %d\n", d.mat);
		printf("Salario: %.2lf\n", d.sal);
		printf("\n_____________________\n\n");
		fclose(arq);
    }

}

void listar() {
	tfunc d;
	int res;
	FILE *arq, *arq2;
	arq = fopen("dados.bin", "rb");
	arq2 = fopen("lista.txt", "w");
	if (arq == NULL) {
		printf("Arquivo inexistente!\n");
		return;
	}

	while(fread(&d,sizeof(tfunc),1,arq)) {
		printf("\n");
		printf("Nome: %s\n", d.nome);
		printf("Matricula: %d\n", d.mat);
		printf("Salario: %.2lf\n", d.sal);
		printf("\n_____________________\n\n");
	}

    printf("Deseja salvar a listagem em um arquivo texto? 1-sim 2-nao");
    scanf("%d", &res);
    if (res == 1) {
        rewind(arq);
        while(fread(&d,sizeof(tfunc),1,arq)) {
		fprintf(arq2,"\nNome: %s\n", d.nome);
		fprintf(arq2,"Matricula: %d\n", d.mat);
		fprintf(arq2,"Salario: %.2lf\n", d.sal);
        printf("\n_____________________\n\n");
	}
    }
    fclose(arq);
	fclose(arq2);
}

void indexar(tarv *t) {
    FILE *arq;
    tfunc d;
    int i = 1;
    int aux;

    arq = fopen("dados.bin", "rb");
    while (fread(&d,sizeof(tfunc),1,arq)) { //LER OS REGISTROS DO ARQUIVO E OS INSERE NA ARVORE
        aux = abbinserir(t,d.mat,i);
        if (aux != 0) {
            printf("Problema ao indexar!\n");
        } else {
            i++;
        }
    }
    fclose(arq);
}

void alterasal(tarv t, tfunc d) {
    tfunc d1;
    double novosal;
    int indice, mat;
    FILE *arq;

    mat = d.mat;

    printf("Digite o novo salario: ");
    scanf("%lf", &novosal);

    indice = abbbuscar(t,mat); //BUSCA REGISTRO NA ARVORE E OBTEM INDICE
    if (indice == -1) {
        printf("Funcionario nao existe\n");
        return;
    } else {
        arq = fopen("dados.bin", "rb+");
        if (arq == NULL){
            printf("Problema ao abrir arquivo!\n");
            return;
        }
        fseek(arq,(indice-1)*sizeof(tfunc),SEEK_SET);
        fread(&d,sizeof(tfunc),1,arq);
        d1.mat = d.mat;
        d1.sal = novosal;
        strcpy(d1.nome,d.nome);
        fseek(arq,(indice-1)*sizeof(tfunc),SEEK_SET);
        fwrite(&d1,sizeof(tfunc),1,arq); //SUBSTITUI OS DADOS DO REGISTRO ADICIONANDO UM NOVO SALARIO
    }
    fclose(arq);
}

void reorganizar(tarv t) {
    FILE *arq;
    FILE *arq2;
    tfunc d, d1;
    int indice, i=0;
    rename("dados.bin", "temp.bin"); //RENOMEIA O ARQUIVO ORIGINAL PARA TEMPORARIO
    arq = fopen("temp.bin", "rb+");
    arq2 = fopen("dados.bin", "wb"); //CRIA ARQUIVO COM O NOME DO ARQUIVO ORIGINAL

    /*
        O TRECHO ABAIXO BUSCA OS REGISTROS DO ARQUIVO NA ARVORE,
        SE O REGISTRO EXISTIR É INSERIDO NO NOVO ARQUIVO.
        AO FINAL EXISTIRÁ UM NOVO DADOS.BIN CORRESPONDENTE AOS REGISTROS DA ARVORE
        E O ARQUIVO ANTIGO TEMP.BIN É APAGADO.
    */
    while (fread(&d,sizeof(tfunc),1,arq)) {
        indice = abbbuscar(t,d.mat);
        if (indice != -1) {
            d1.mat = d.mat;
            strcpy(d1.nome,d.nome);
            d1.sal = d.sal;
            fseek(arq2,i*sizeof(tfunc),SEEK_SET);
            fwrite(&d1,sizeof(tfunc),1,arq2);
            i++;
        }
    }

    fclose(arq);
    fclose(arq2);
    remove("temp.bin");
}

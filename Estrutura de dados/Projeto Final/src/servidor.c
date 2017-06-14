#include "funcoes.h"

#define MINHA_PORTA     9090
#define BACKLOG         5

void sockservidor(tarv t1){
	int Meusocket, novosocket;
	tfunc dados;
	struct sockaddr_in local, remoto;
	int tamanho,op;
	char buffer[1024];
	char buf[1024];

	#ifdef _WIN32
	 WSADATA wsaData;

	if (WSAStartup(MAKEWORD(2,2), &wsaData) != 0) {
		//TrataErro(s, WSTARTUP);
		exit(1);
		}
    #endif

	Meusocket = socket(AF_INET,SOCK_STREAM,0);
	local.sin_family = AF_INET;
	local.sin_port = htons(MINHA_PORTA);
	local.sin_addr.s_addr = INADDR_ANY;//inet_addr("192.168.25.69");
	memset(&(local.sin_zero),0,8);

	bind(Meusocket,(struct sockaddr *)&local,sizeof(struct sockaddr));

	if((listen(Meusocket, BACKLOG)) == -1){
        //perror("listen");
        exit(1);
    }

	tamanho = sizeof(struct sockaddr_in); //apenas para melhorar o código;

	while(1){
        showmenu(); //MOSTRA MENU DE OPÇÕES
        printf("\nEsperando dados do cliente...\n");
		if((novosocket = accept(Meusocket, (struct sockaddr *)&remoto, &tamanho)) == -1){
            perror("accept");
            continue;
        }
		memset(buf,0,sizeof(buf));
		//read(novosocket, buf, sizeof(buf));
        if ((recv(novosocket, buf, sizeof(buf)-1, 0)) > 0){
            memset(buffer,0,sizeof(buffer));
            strncpy(buffer, buf+0, 3);
            dados.mat = atoi(buffer);

            //__________________________

            memset(dados.nome,0,sizeof(dados.nome));
            strncpy(dados.nome, buf+3, 20);
            dados.nome[20] = '\0';

            //__________________________

            memset(buffer,0,sizeof(buffer));
            strncpy(buffer, buf+23, 7);
            dados.sal = atof(buffer);

            //__________________________

            memset(buffer,0,sizeof(buffer));
            strncpy(buffer, buf+30, 1);
            op = atoi(buffer);

            if (op == 9) {
                printf("Conexao encerrada!\n");
                exit(0);
            } else {
                filtro(dados,t1,op);
            }

        }

        //perror("recv");

	}
}

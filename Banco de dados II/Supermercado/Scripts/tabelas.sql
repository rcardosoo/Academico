CREATE TABLE pessoa (
	CPF		Varchar2(14) NOT NULL,
	Nome		Varchar2(30) NOT NULL,
	Email		Varchar2(120),
	Telefone	Number
);

CREATE TABLE cliente (
	Codigo		Number         NOT NULL,
	CPF		Varchar2(14) NOT NULL
);

CREATE TABLE funcionario (
	Matricula	Number 	NOT NULL,
	Senha		Number 	NOT NULL,
	Salario		Number 	NOT NULL,
	Cidade		Varchar2(2)    NOT NULL,
	CPF		Varchar2(14)  NOT NULL
);

CREATE TABLE supervisiona (
	MatSupervisor          Number NOT NULL,
	MatSupervisionado  Number NOT NULL
);

CREATE TABLE pedido (
	Numero	Number NOT NULL,
	CodCli		Number NOT NULL
);

CREATE TABLE composto (
	NumPed	Number NOT NULL,
	CodProd	Number NOT NULL
);

CREATE TABLE produto (
	Codigo		Number 	NOT NULL,
	CodCateg	Number 	NOT NULL,
	Quantidade	Number,
	Validade	Date,
	Nome		Varchar2(30)  NOT NULL,
	Preco		Number(5,2)  NOT NULL
);

CREATE TABLE categoria (
	Codigo		Number         NOT NULL,
	Nome		Varchar2(30) NOT NULL
);


CREATE TABLE fornecido (
	CodProd	Number NOT NULL,
	CNPJForn	Number NOT NULL,
	Quantidade	Number NOT NULL
);

CREATE TABLE fornecedor (
	CNPJ		Number           NOT NULL,
	Nome		Varchar2(30)   NOT NULL,
	Email		Varchar2(120) NOT NULL
);


ALTER TABLE pessoa ADD CONSTRAINT pk_pes PRIMARY KEY (CPF);
ALTER TABLE cliente ADD CONSTRAINT pk_pcli PRIMARY KEY (codigo);
ALTER TABLE cliente ADD CONSTRAINT fk_cli FOREIGN KEY (CPF) 
REFERENCES pessoa;
ALTER TABLE funcionario ADD CONSTRAINT pk_funcio PRIMARY KEY (Matricula);
ALTER TABLE funcionario ADD CONSTRAINT fk_funcio FOREIGN KEY (CPF)
REFERENCES pessoa;
ALTER TABLE funcionario ADD CONSTRAINT cid_func CHECK (cidade in ('JP','CB'));
ALTER TABLE funcionario ADD CONSTRAINT sal_func CHECK (salario > = 800.00);
ALTER TABLE pedido ADD CONSTRAINT pk_ped PRIMARY KEY (Numero);
ALTER TABLE pedido ADD CONSTRAINT fk_ped FOREIGN KEY (CodCli)
REFERENCES cliente;
ALTER TABLE categoria ADD CONSTRAINT pk_categ PRIMARY KEY (codigo);
ALTER TABLE produto ADD CONSTRAINT pk_prod PRIMARY KEY (codigo);
ALTER TABLE produto ADD CONSTRAINT fk_prod FOREIGN KEY (codCateg)
REFERENCES categoria;
ALTER TABLE fornecedor ADD CONSTRAINT pk_forn PRIMARY KEY (CNPJ);
ALTER TABLE composto ADD CONSTRAINT pk_comp PRIMARY KEY (NumPed, CodProd);
ALTER TABLE composto ADD CONSTRAINT fk_comp FOREIGN KEY (NumPed)
REFERENCES pedido;
ALTER TABLE composto ADD CONSTRAINT fk_comp2 FOREIGN KEY (CodProd)
REFERENCES produto;
ALTER TABLE supervisiona ADD CONSTRAINT pk_sup PRIMARY KEY (matsupervisor, matsupervisionado);
ALTER TABLE supervisiona ADD CONSTRAINT fk_sup FOREIGN KEY (matsupervisor)
REFERENCES funcionario;
ALTER TABLE supervisiona ADD CONSTRAINT fk_sup2 FOREIGN KEY (matsupervisionado)
REFERENCES funcionario;
ALTER TABLE fornecido ADD CONSTRAINT pk_forncd PRIMARY KEY (codProd, CNPJForn);
ALTER TABLE fornecido ADD CONSTRAINT fk_forncd FOREIGN KEY (codProd)
REFERENCES produto;
ALTER TABLE fornecido ADD CONSTRAINT fk_forncd2 FOREIGN KEY (CNPJForn)
REFERENCES fornecedor;


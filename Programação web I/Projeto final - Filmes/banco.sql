create database filme2bd;
use filme2bd;


create table filme (
    codigo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    sinopse VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    genero VARCHAR(100) NOT NULL
);

create table comentario (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    texto VARCHAR(200) NOT NULL,
    codigo INT NOT NULL,
    cpf INT NOT NULL
);

create table filmesassistidos (
    filme INT NOT NULL,
    usuario INT NOT NULL,
    PRIMARY KEY(filme, usuario)
);

create table comentarista (
    cpf INT PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(40) NOT NULL,
    senha VARCHAR(40) NOT NULL,
    CONSTRAINT uniq_coment UNIQUE (login)
);

create table administrador (
    cpf INT PRIMARY KEY NOT NULL DEFAULT 0,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(40) NOT NULL,
    senha VARCHAR(40) NOT NULL,
    CONSTRAINT uniq_adm UNIQUE (login)
);

ALTER TABLE comentario ADD CONSTRAINT FOREIGN KEY (codigo) REFERENCES filme(codigo);
ALTER TABLE comentario ADD CONSTRAINT FOREIGN KEY (cpf) REFERENCES comentarista(cpf);
ALTER TABLE filmesassistidos ADD CONSTRAINT FOREIGN KEY (filme) REFERENCES filme(codigo);
ALTER TABLE filmesassistidos ADD CONSTRAINT FOREIGN KEY (usuario) REFERENCES comentarista(cpf);
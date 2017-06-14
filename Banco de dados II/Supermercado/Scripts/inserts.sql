INSERT INTO pessoa VALUES ('765.665.384-34','Joana','joanajp@gmail.com','87893002');
INSERT INTO pessoa VALUES ('887.934.288-28','Ricardo','ricardo123@gmail.com','98763442');
INSERT INTO pessoa VALUES ('453.765.314-14','Marcos','marcos321@hotmail.com',NULL);
INSERT INTO pessoa VALUES ('276.255.459-44','Larissa', 'larissa10@oi.com.br','86365511');
INSERT INTO pessoa VALUES ('811.444.345-24','Maria','mari94@gmail.com','93221987');
INSERT INTO pessoa VALUES ('911.432.111-87','Luiz','luizjp@hotmail.com','84331198');
INSERT INTO pessoa VALUES ('103.665.309-29','Fernanda','fernandapb@gmail.com','98878767');
INSERT INTO pessoa VALUES ('218.955.223-23','Claudio','claudio123@gmail.com','91641123');


INSERT INTO cliente VALUES (seq_cliente.nextval,'765.665.384-34');
INSERT INTO cliente VALUES (seq_cliente.nextval,'887.934.288-28');
INSERT INTO cliente VALUES (seq_cliente.nextval,'453.765.314-14');
INSERT INTO cliente VALUES (seq_cliente.nextval,'276.255.459-44');


INSERT INTO funcionario VALUES (seq_mat.nextval,131,900.00,'JP','276.255.459-44');
INSERT INTO funcionario VALUES (seq_mat.nextval,443,1100.00,'CB','811.444.345-24');
INSERT INTO funcionario VALUES (seq_mat.nextval,227,860.00,'CB','911.432.111-87');
INSERT INTO funcionario VALUES (seq_mat.nextval,533,2200.00,'JP','103.665.309-29');


INSERT INTO supervisiona VALUES (4,1);
INSERT INTO supervisiona VALUES (4,2);
INSERT INTO supervisiona VALUES (4,3);


INSERT INTO pedido VALUES (1,2);
INSERT INTO pedido VALUES (2,1);
INSERT INTO pedido VALUES (3,2);
INSERT INTO pedido VALUES (4,3);
INSERT INTO pedido VALUES (5,4);


INSERT INTO categoria VALUES (1,'Perecivel');
INSERT INTO categoria VALUES (2,'Eletronico');
INSERT INTO categoria VALUES (3,'Textil');


INSERT INTO produto VALUES (seq_prod.nextval,1,120,'22/04/2016','Carne',14.00);
INSERT INTO produto VALUES (seq_prod.nextval,1,98,'30/04/2016','Salsicha',4.00);
INSERT INTO produto VALUES (seq_prod.nextval,3,14,NULL,'Toalha',14.00);
INSERT INTO produto VALUES (seq_prod.nextval,2,3,NULL,'Lanterna',35.00);
INSERT INTO produto VALUES (seq_prod.nextval,3,11,NULL,'Bermuda',28.00);


INSERT INTO composto VALUES (1,2);
INSERT INTO composto VALUES (2,5);
INSERT INTO composto VALUES (1,1);
INSERT INTO composto VALUES (3,4);
INSERT INTO composto VALUES (4,3);



INSERT INTO fornecedor VALUES (3442,'Alimentos S/A', 'alimentos.a@gmail.com');
INSERT INTO fornecedor VALUES (5233,'Forntec', 'forntec@gmail.com');
INSERT INTO fornecedor VALUES (9342,'Ftextil', 'f.textil@gmail.com');
INSERT INTO fornecedor VALUES (1055,'FriosF', 'frios.f@gmail.com');


INSERT INTO fornecido VALUES (1,3442,4);
INSERT INTO fornecido VALUES (2,3442,5);
INSERT INTO fornecido VALUES (4,5233,9);
INSERT INTO fornecido VALUES (3,9342,12);
INSERT INTO fornecido VALUES (5,9342,7);

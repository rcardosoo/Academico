CREATE OR REPLACE PROCEDURE insert_pessoa (
	cpf in pessoa.cpf%type,
	nome in pessoa.nome%type,
	email in pessoa.email%type,
	telefone number
) IS
BEGIN
	INSERT INTO pessoa VALUES(cpf, nome, email, telefone);
END;

/---

CREATE OR REPLACE PROCEDURE insert_cliente (
	cpf in pessoa.cpf%type
) IS
BEGIN
	INSERT INTO cliente VALUES(seq_cliente.nextval, cpf);
END;

/---

CREATE OR REPLACE PROCEDURE insert_prod (
	quantidade in produto.quantidade%type,
	codCateg in produto.codcateg%type,
	validade in produto.validade%type,
	nome in produto.nome%type,
	preco in produto.preco%type
) IS
BEGIN
	INSERT INTO Produto VALUES (seq_prod.nextval, codcateg, quantidade, validade, nome, preco);
END;

/---

CREATE OR REPLACE PROCEDURE insert_fornecedor (
	cnpj in fornecedor.cnpj%type,
	nome in fornecedor.nome%type,
	email in fornecedor.email%type
) IS
BEGIN
	INSERT INTO fornecedor VALUES (cnpj, nome, email);
END;

/---

CREATE OR REPLACE PROCEDURE insert_func (
	senha in funcionario.senha%type,
	salario in funcionario.salario%type,
	cidade in funcionario.cidade%type,
	cpf in funcionario.cpf%type
) IS
BEGIN
	INSERT INTO funcionario VALUES (seq_mat.nextval, senha, salario, cidade, cpf);
END;

/---

/* Procedure para atualização */
CREATE OR REPLACE PROCEDURE aumentar_preco (
	codprod number, 
	porcentagem number
) IS
BEGIN
	UPDATE produto SET preco = preco + (preco*(porcentagem/100)) 
	WHERE codigo = codprod;
EXCEPTION 
	WHEN no_data_found THEN
		dbms_output.put_line('Produto inexistente');
END;

/---

/* Procedure envolvendo cursor e dbms */
CREATE OR REPLACE PROCEDURE produto_cat (
	cat in categoria.nome%type
) IS
  semestoque EXCEPTION;
BEGIN
	for v_cursor in (SELECT p.nome, p.preco, p.quantidade FROM Produto p JOIN categoria c
                      ON p.codCateg = c.codigo
                        WHERE c.nome = cat) LOOP

		if v_cursor.quantidade = 0 then
			RAISE semestoque;
		end if;
 
		 dbms_output.put_line('Produto: ' || v_cursor.nome || ' - Preco: R$ ' || v_cursor.preco || ',00');

	END LOOP;
EXCEPTION
	WHEN semestoque THEN
	dbms_output.put_line('Estoque vazio');	
END;


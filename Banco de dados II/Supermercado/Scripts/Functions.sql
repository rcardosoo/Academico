CREATE OR REPLACE FUNCTION media_cat (
	cat in categoria.nome%type
) return number IS
valor number;
BEGIN
	SELECT AVG(preco) INTO valor FROM Produto p JOIN categoria c ON
	p.codCateg = c.codigo
	WHERE c.nome = cat;

	return valor;
END;

/---

CREATE OR REPLACE FUNCTION qtd_cat(
	nome_cat in categoria.nome%type
) return number
IS
  semestoque EXCEPTION;
	qtd number;
BEGIN
	SELECT COUNT(*) INTO qtd FROM Produto p JOIN categoria c 
	ON p.codCateg = c.codigo 
	WHERE c.nome = nome_cat;
	if qtd = 0 then
		RAISE semestoque;
	else
		return qtd;
	end if;

EXCEPTION
	WHEN semestoque THEN 
		dbms_output.put_line('Categoria nao possui produtos ou nao existe');
		return 0;
END;

/---

CREATE OR REPLACE FUNCTION verifica_func (
	cpfenv in funcionario.cpf%type
) return number 
IS
	mat number;
BEGIN
	SELECT matricula INTO mat FROM funcionario f JOIN pessoa p
	ON f.cpf = p.cpf
	WHERE f.cpf = cpfenv;

	return mat;
EXCEPTION
		WHEN no_data_found THEN
			dbms_output.put_line('O cpf informado nao pertence a um funcionario');
			return 0;
END;

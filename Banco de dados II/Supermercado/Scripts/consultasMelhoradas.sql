SELECT p.nome, p.cpf FROM pessoa p
WHERE p.cpf in (SELECT f.cpf FROM funcionario f
			WHERE f.salario > 1000);
        
/* melhorada: */

SELECT p.nome, p.cpf FROM pessoa p JOIN
funcionario f ON p.cpf = f.cpf
WHERE f.salario > 1000;


/---


SELECT f.nome FROM fornecedor f
WHERE f.CNPJ IN (SELECT d.CNPJForn FROM fornecido d
			WHERE d.CodProd IN (SELECT p.codigo FROM produto p
						WHERE p.preco > (SELECT AVG(preco) FROM Produto)));

/* melhorada: */

SELECT f.nome FROM fornecedor f
JOIN fornecido d ON f.CNPJ = d.CNPJForn JOIN
Produto p ON d.CodProd = p.codigo
WHERE p.preco > (SELECT AVG(preco) FROM Produto);

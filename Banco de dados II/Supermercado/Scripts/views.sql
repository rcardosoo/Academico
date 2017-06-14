/* View que permite inserção */
CREATE OR REPLACE VIEW pr_eletro AS
SELECT p.codigo, p.codCateg, p.quantidade, p.nome, p.preco
FROM produto p JOIN categoria c ON
p.codCateg = c.codigo WHERE
c.codigo = 2;

/* View com read only */
CREATE OR REPLACE VIEW view_func AS
SELECT p.nome, p.email, f.matricula
FROM pessoa p JOIN funcionario f
ON p.cpf = f.cpf
WITH READ ONLY;


CREATE OR REPLACE VIEW view_fornpr AS
SELECT f.nome as nome_func, d.quantidade, p.nome as nome_prod, c.nome as nome_cat 
FROM fornecedor f JOIN fornecido d ON
f.CNPJ = d.CNPJForn JOIN produto p
ON d.CodProd = p.codigo JOIN
categoria c ON p.codCateg = c.codigo;

CREATE OR REPLACE TRIGGER t_validade
BEFORE INSERT ON Produto
FOR EACH ROW
DECLARE
	v_ano number;
	v_mes number;
	v_dia number;
BEGIN
	v_ano := to_number(to_char(sysdate, 'yyyy'));
	v_mes := to_number(to_char(sysdate, 'mm'));
	v_dia := to_number(to_char(sysdate, 'dd'));
	if to_number(to_char(:NEW.validade, 'yyyy')) < v_ano then
		Raise_application_error(-20400, 'Data de validade inferior a data atual');
	end if;
	if to_number(to_char(:NEW.validade, 'mm')) < v_mes then
		Raise_application_error(-20400, 'Data de validade inferior a data atual');
	end if;
	if to_number(to_char(:NEW.validade, 'dd')) < v_dia then
		Raise_application_error(-20400, 'Data de validade inferior a data atual'); 					
	end if;
		
END;

/---

CREATE OR REPLACE TRIGGER qtdzero
BEFORE INSERT ON Fornecido
FOR EACH ROW
BEGIN
	if :NEW.quantidade = 0 then
		Raise_application_error(-20800, 'Nenhum produto fornecido');	
	end if;
END;

/---

CREATE OR REPLACE TRIGGER preco_zero
BEFORE INSERT ON produto
FOR EACH ROW
BEGIN
  IF :NEW.preco < 0.1 THEN
    Raise_application_error(-20800, 'Produto inserido com preço vazio');
  END IF;
END;

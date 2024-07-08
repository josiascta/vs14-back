--Task 02

SELECT * FROM PAIS ORDER BY nome DESC;

SELECT logradouro, cep FROM ENDERECO WHERE UPPER(SUBSTR(logradouro, 1, 1)) = 'A';

SELECT * FROM ENDERECO WHERE SUBSTR(cep, -1) = '0';

SELECT * FROM ENDERECO WHERE numero BETWEEN 1 AND 100;

SELECT * FROM ENDERECO WHERE UPPER(SUBSTR(logradouro, 1, 3)) = 'RUA' ORDER BY cep DESC;

select count(*) from ENDERECO; 

SELECT id_cidade, COUNT(*) AS quantidade_enderecos FROM ENDERECO GROUP BY id_cidade;

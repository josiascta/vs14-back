CREATE SEQUENCE SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO PAIS (id_pais, nome)
VALUES (SEQ_PAIS.NEXTVAL, 'Brasil');

INSERT INTO PAIS (id_pais, nome)
VALUES (SEQ_PAIS.NEXTVAL, 'Estados Unidos');

INSERT INTO ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 1, 'São Paulo');

INSERT INTO ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 1, 'Rio de Janeiro');

INSERT INTO ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 2, 'California');

INSERT INTO ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 2, 'Texas');

--São Paulo
INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 1, 'São Paulo');

INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 1, 'Campinas');
--Rio de Janeiro
INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 2, 'Rio de Janeiro');

INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 2, 'Angra dos Reis');
--California
INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 3, 'Los Angeles');

INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 3, 'São Francisco');

--Texas
INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 4, 'Houston');

INSERT INTO CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 4, 'Dallas');

-- Bairros de São Paulo
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 1, 'Vila Mariana');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 1, 'Moema');

-- Bairros de Campinas
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 1, 'Centro');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 1, 'Cambuí');

-- Bairros do Rio de Janeiro
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 2, 'Copacabana');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 2, 'Ipanema');

-- Bairros de Angra dos Reis
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis'), 2, 'Praia do Anil');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis'), 2, 'Frade');

-- Bairros de Los Angeles
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles'), 3, 'Hollywood');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles'), 3, 'Santa Monica');

-- Bairros de São Francisco
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco'), 3, 'Fisherman''s Wharf');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco'), 3, 'Mission District');


-- Bairros de Houston
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston'), 4, 'Sawyer Yards');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston'), 4, 'Chinatown');

-- Bairros de Dallas
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas'), 4, 'Oak Lawn');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas'), 4, 'Deep Ellum');

-- Endereços para o bairro Oak Lawn, Dallas
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Oak Lawn' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas'), 'Maple Ave', 100, 'Apt 1', '75219');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Oak Lawn' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas'), 'Cedar Springs Rd', 500, 'House 2', '75220');

-- Endereços para o bairro Deep Ellum, Dallas
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Deep Ellum' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas'), 'Elm St', 200, NULL, '75221');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Deep Ellum' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Dallas'), 'Main St', 600, 'Suite 101', '75222');

-- Endereços para o bairro Sawyer Yards, Houston
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Sawyer Yards' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston'), 'Sawyer St', 100, 'Apt 1', '77007');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Sawyer Yards' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston'), 'Heights Blvd', 500, 'House 2', '77008');

-- Endereços para o bairro Chinatown, Houston
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Chinatown' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston'), 'Bellaire Blvd', 200, NULL, '77009');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Chinatown' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Houston'), 'Dairy Ashford Rd', 600, 'Suite 101', '77010');

-- Endereços para o bairro Hollywood, Los Angeles
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Hollywood' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles'), 'Sunset Blvd', 100, 'Apt 1', '90028');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Hollywood' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles'), 'Hollywood Blvd', 500, 'House 2', '90029');

-- Endereços para o bairro Santa Monica, Los Angeles
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Santa Monica' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles'), 'Ocean Ave', 200, NULL, '90401');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Santa Monica' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Angeles'), 'Main St', 600, 'Suite 101', '90402');

-- Endereços para o bairro Fisherman's Wharf, São Francisco
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Fisherman''s Wharf' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco'), 'Jefferson St', 100, 'Apt 1', '94133');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Fisherman''s Wharf' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco'), 'Beach St', 500, 'House 2', '94134');

-- Endereços para o bairro Mission District, São Francisco
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Mission District' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco'), 'Valencia St', 200, NULL, '94110');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Mission District' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Francisco'), '24th St', 600, 'Suite 101', '94114');

-- Endereços para o bairro Vila Mariana, São Paulo
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Vila Mariana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Rua Vergueiro', 1000, 'Apt 101', '04101-000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Vila Mariana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Avenida Conselheiro Rodrigues Alves', 500, NULL, '04014-002');

-- Endereços para o bairro Moema, São Paulo
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Moema' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Alameda dos Jurupis', 800, 'Casa 2', '04587-030');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Moema' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Avenida Rouxinol', 123, NULL, '04516-030');

-- Endereços para o bairro Centro, Campinas
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Rua 13 de Maio', 789, 'Sala 102', '13010-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Avenida Anchieta', 432, NULL, '13015-001');

-- Endereços para o bairro Cambuí, Campinas
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Cambuí' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Rua Coronel Quirino', 200, 'Loja 1', '13025-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Cambuí' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Avenida Norte-Sul', 600, NULL, '13020-001');

-- Endereços para o bairro Copacabana, Rio de Janeiro
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Copacabana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Avenida Atlântica', 1500, 'Apt 501', '22021-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Copacabana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Rua Barata Ribeiro', 500, NULL, '22011-002');

-- Endereços para o bairro Ipanema, Rio de Janeiro
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Ipanema' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Rua Visconde de Pirajá', 987, 'Casa 1', '22410-003');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Ipanema' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Avenida Vieira Souto', 123, NULL, '22420-002');

-- Endereços para o bairro Praia do Anil, Angra dos Reis
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Praia do Anil' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis'), 'Rua dos Coqueiros', 321, 'Casa 2', '23907-000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Praia do Anil' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis'), 'Estrada do Contorno', 456, NULL, '23906-001');

-- Endereços para o bairro Frade, Angra dos Reis
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Frade' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis'), 'Avenida Beira-Mar', 789, 'Casa 101', '23905-002');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Frade' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Angra dos Reis'), 'Rua das Palmeiras', 987, NULL, '23904-003');


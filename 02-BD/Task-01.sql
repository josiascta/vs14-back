--Task 1

CREATE TABLE ESTUDANTE(
id_estudante NUMBER PRIMARY KEY,
nome VARCHAR2(200) NOT NULL,
data_nascimento DATE NOT NULL,
nr_matricula NUMBER(10) NOT NULL UNIQUE,
ativo char(1) CHECK (ativo IN ('S', 'N')) NOT NULL
);

CREATE SEQUENCE SEQ_ESTUDANTE
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Josias', TO_DATE('29-09-2003', 'dd/mm/yy'), 2022150200, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Ian', TO_DATE('17-03-1997', 'dd/mm/yy'), 2022150201, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Daniel', TO_DATE('09-09-2003', 'dd/mm/yy'), 2022150202, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Davi', TO_DATE('26-07-2001', 'dd/mm/yy'), 2022150203, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Vitoria', TO_DATE('09-12-1879', 'dd/mm/yy'), 2022150204, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Lucas', TO_DATE('02-02-2002', 'dd/mm/yy'), 2022150205, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'João', TO_DATE('10-07-1980', 'dd/mm/yy'), 2022150206, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Maria', TO_DATE('20-04-2001', 'dd/mm/yy'), 2022150207, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Eduardo', TO_DATE('05-03-2000', 'dd/mm/yy'), 2022150208, 'S');

INSERT INTO ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES
(SEQ_ESTUDANTE.nextval, 'Rafael', TO_DATE('04-07-1999', 'dd/mm/yy'), 2022150209, 'S');

SELECT *FROM ESTUDANTE;
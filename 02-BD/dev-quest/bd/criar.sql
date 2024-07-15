--DROP USER DEV_QUEST CASCADE;

DECLARE
    v_count INTEGER;
BEGIN

    SELECT COUNT(*)
    INTO v_count
    FROM dba_users
    WHERE username = 'DEV_QUEST';

    IF v_count > 0 THEN
        EXECUTE IMMEDIATE 'DROP USER DEV_QUEST CASCADE';
    END IF;
END;

CREATE USER DEV_QUEST IDENTIFIED BY oracle;

ALTER SESSION SET CURRENT_SCHEMA=DEV_QUEST;

GRANT CONNECT TO DEV_QUEST;

GRANT CONNECT, RESOURCE, DBA TO DEV_QUEST;

GRANT CREATE SESSION TO DEV_QUEST;

GRANT DBA TO DEV_QUEST;

GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE TO DEV_QUEST;

GRANT UNLIMITED TABLESPACE TO DEV_QUEST;
GRANT CREATE MATERIALIZED VIEW TO DEV_QUEST;
GRANT CREATE TABLE TO DEV_QUEST;
GRANT GLOBAL QUERY REWRITE TO DEV_QUEST;
GRANT SELECT ANY TABLE TO DEV_QUEST;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'PLAYER_PROJECT';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'QUESTION_OPTION';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'QUESTION';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'QUESTION_TYPE';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'PROJECT';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'AREA';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE ' || 'PLAYER';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

CREATE TABLE DEV_QUEST.AREA (
    id INTEGER PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);


CREATE TABLE DEV_QUEST.PROJECT (
    id INTEGER PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    max_errors INTEGER NOT NULL,
    score INTEGER NOT NULL,
    area_id INTEGER NOT NULL,
    CONSTRAINT FK_PROJECT_AREA FOREIGN KEY (area_id) REFERENCES AREA(id)
);


CREATE TABLE DEV_QUEST.PLAYER (
	id INTEGER PRIMARY KEY,
	nickname VARCHAR2(255) NOT NULL,
	score INTEGER NOT NULL
);


CREATE TABLE DEV_QUEST.PLAYER_PROJECT (
    player_id INTEGER NOT NULL,
    project_id INTEGER NOT NULL,
    completed_at DATE,
    PRIMARY KEY (player_id, project_id),
    CONSTRAINT FK_PLAYER_PROJECT_PLAYER FOREIGN KEY (player_id) REFERENCES PLAYER(id),
    CONSTRAINT FK_PLAYER_PROJECT_PROJECT FOREIGN KEY (project_id) REFERENCES PROJECT(id)
);


CREATE TABLE DEV_QUEST.QUESTION_TYPE (
    id INTEGER PRIMARY KEY,
    identifier VARCHAR(255) NOT NULL
);


CREATE TABLE DEV_QUEST.QUESTION (
    id INTEGER PRIMARY KEY,
    statement VARCHAR(255) NOT NULL,
    answer_secret_word VARCHAR(255),
    score INTEGER NOT NULL,
    project_id INTEGER NOT NULL,
    question_type_id INTEGER NOT NULL,
    CONSTRAINT FK_QUESTION_PROJECT FOREIGN KEY (project_id) REFERENCES PROJECT(id),
    CONSTRAINT FK_QUESTION_QUESTION_TYPE FOREIGN KEY (question_type_id) REFERENCES QUESTION_TYPE(id)
);


CREATE TABLE DEV_QUEST.QUESTION_OPTION (
    id INTEGER PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    correct NUMBER(1) NOT NULL,
    question_id INTEGER NOT NULL,
    CONSTRAINT FK_QUESTION_OPTION_QUESTION FOREIGN KEY (question_id) REFERENCES QUESTION(id)
);

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_PLAYER';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_PROJECT';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_QUESTION';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE ' || 'SEQ_QUESTION_OPTION';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;

CREATE SEQUENCE SEQ_PLAYER
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE SEQUENCE SEQ_PROJECT
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE SEQUENCE SEQ_QUESTION
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE SEQUENCE SEQ_QUESTION_OPTION
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;



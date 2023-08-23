CREATE TABLE TBL_CLIENTE
(
    ID_CLIENTE        NUMBER GENERATED ALWAYS AS IDENTITY,
    TX_NOME           VARCHAR2(45) NOT NULL,
    TX_DOCUMENTO      VARCHAR2(14),
    TX_TIPO_DOCUMENTO VARCHAR2(4) NOT NULL,
    TX_AREA_FONE      VARCHAR2(2),
    TX_FONE           VARCHAR2(9),
    TX_TIPO_FONE      VARCHAR2(11),
    TX_EMAIL          VARCHAR2(50),
    CONSTRAINT ID_CLIENTE PRIMARY KEY (ID_CLIENTE)
);

INSERT INTO TBL_CLIENTE(TX_NOME, TX_DOCUMENTO, TX_TIPO_DOCUMENTO, TX_AREA_FONE, TX_FONE, TX_TIPO_FONE, TX_EMAIL) VALUES ('Caio Rodrigo Reis dos Santos', '26743821713', 'CPF', '11', '991947594', 'WHATSAPP', 'caio.rodrigo.reis@gmail.com');
INSERT INTO TBL_CLIENTE(TX_NOME, TX_DOCUMENTO, TX_TIPO_DOCUMENTO, TX_AREA_FONE, TX_FONE, TX_TIPO_FONE, TX_EMAIL) VALUES ('Fabio Mendes Castelhano', '92205806408', 'CPF', '11', '983764789', 'WHATSAPP', 'fabio.mendes.castelhano@gmail.com');

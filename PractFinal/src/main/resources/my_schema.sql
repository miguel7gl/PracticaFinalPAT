
DROP TABLE IF EXISTS ELECTRODOMESTICOS;
DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS PRECIOS;

CREATE TABLE ELECTRODOMESTICOS (
    ELECTRO_ID INTEGER IDENTITY(1,1) PRIMARY KEY NOT NULL,
    ELECTRO_TIPO VARCHAR(255) NOT NULL,
    CUSTOMER_ID INTEGER NOT NULL,
    TIEMPO_USO INTEGER
);

CREATE TABLE CUSTOMERS (
    CUSTOMER_ID INTEGER IDENTITY (1,1) PRIMARY KEY NOT NULL,
    CUSTOMER_NAME VARCHAR(255) NOT NULL,
    CONTRASENA VARCHAR(255) NOT NULL
);

CREATE TABLE PRECIOS (
    ELECTRO_TIPO VARCHAR(255) PRIMARY KEY NOT NULL,
    CONSUMO_MEDIO_HORA NUMBER NOT NULL,
    PRECIO_CONSUMO FLOAT NOT NULL
);
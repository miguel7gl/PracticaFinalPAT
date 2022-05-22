
DROP TABLE IF EXISTS ELECTRODOMESTICOS;
DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS PRECIOS;
DROP TABLE IF EXISTS DOMICILIOS;

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

CREATE TABLE DOMICILIOS (
    CUSTOMER_ID INTEGER IDENTITY (1,1) PRIMARY KEY NOT NULL,
    CALLE VARCHAR(255) NOT NULL,
    NUM_PISO VARCHAR(255) NOT NULL,
    PROVINCIA VARCHAR(255) NOT NULL,
    CIUDAD VARCHAR(255) NOT NULL,
    CODIGO_POSTAL INTEGER NOT NULL,
    PAIS VARCHAR(255) NOT NULL
);

CREATE TABLE INFO_ELECTRODOMESTICOS (
    ELECTRO_ID INTEGER PRIMARY KEY NOT NULL,
    MARCA VARCHAR(255) NOT NULL,
    EFICIENCIA VARCHAR(255) NOT NULL
)
create database db_pizzaria;
use db_pizzaria;

CREATE TABLE produto (
    id_produto INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40),
    descricacao VARCHAR(100),
    preco FLOAT(5,2)
);

CREATE TABLE funcionario (
    id_funcionario INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(11),
    data_nascimento DATE,
    salario FLOAT(7,2),
    funcao VARCHAR(40)
);

CREATE TABLE cliente (
    id_cliente INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(11),
    data_nascimento DATE
);

CREATE TABLE pedido (
    id_pedido INTEGER AUTO_INCREMENT PRIMARY KEY,
    data_hora TIMESTAMP,
    status VARCHAR(50),
    valor FLOAT(6,2),
    id_cliente INTEGER
);

CREATE TABLE pedido_produto (
    id_pedido INTEGER,
    id_produto INTEGER
);

CREATE TABLE cliente_funcionario (
    id_cliente INTEGER,
    id_funcionario INTEGER
);
 
 /*
ALTER TABLE pedido ADD CONSTRAINT FK_pedido_2
    FOREIGN KEY (id_cliente)
    REFERENCES cliente (id_cliente)
    ON DELETE RESTRICT;
 
ALTER TABLE pedido_produto ADD CONSTRAINT FK_pedido_produto_1
    FOREIGN KEY (id_pedido)
    REFERENCES pedido (id_pedido)
    ON DELETE RESTRICT;
 
ALTER TABLE pedido_produto ADD CONSTRAINT FK_pedido_produto_2
    FOREIGN KEY (id_produto)
    REFERENCES produto (id_produto)
    ON DELETE RESTRICT;
 
ALTER TABLE cliente_funcionario ADD CONSTRAINT FK_cliente_funcionario_1
    FOREIGN KEY (id_cliente)
    REFERENCES cliente (id_cliente)
    ON DELETE RESTRICT;
 
ALTER TABLE cliente_funcionario ADD CONSTRAINT FK_cliente_funcionario_2
    FOREIGN KEY (id_funcionario)
    REFERENCES funcionario (id_funcionario)
    ON DELETE RESTRICT;
    
*/
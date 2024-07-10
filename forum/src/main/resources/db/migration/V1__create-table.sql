DROP DATABASE IF EXISTS forum_db;

CREATE DATABASE forum_db;

USE forum_db;

CREATE TABLE Curso (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Perfil (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Usuario_Perfil (
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (perfil_id) REFERENCES Perfil(id)
);

CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    dtcriacao DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    resposta TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

CREATE TABLE Resposta (
    id BIGINT AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    topico_id BIGINT NOT NULL,
    dtcriacao DATETIME NOT NULL,
    autor_id BIGINT NOT NULL,
    solucao BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (topico_id) REFERENCES Topico(id),
    FOREIGN KEY (autor_id) REFERENCES Usuario(id)
);

/**
 * Projeto de um sistema para gestão de estoque
 * @author Professor José de Assis
 * @version 1.0
 */
 
 create database dbestoque;
 use dbestoque;
 
 create table usuario (
	id int primary key auto_increment,
    usuario varchar(50) not null,
    login varchar(20) not null,
    senha varchar(250) not null
);

describe usuario;

-- Criar Tabela
show tables;


-- Cruid Creat (insert)
insert into usuario (usuario,login,senha) 
values ('sandro','sandro01','123@sandro');

insert into usuario (usuario,login,senha) 
values ('felipe','felipe01','123@felipe');

insert into usuario (usuario,login,senha) 
values ('ricardo','ricard01','123@ricardo');

insert into usuario (usuario,login,senha) 
values ('jose','jose01','123@jose');

insert into usuario (usuario,login,senha) 
values ('milena','milena01','123@milena');


-- a linha abaixo cria apelidos aos campos (cabeçalho) das tabelas - alterar nome na tabela
select id as Código, usuario as Nome, login as Login, senha as Senha from usuario;



-- cruid Update (importante usar a clausula where associada ao id) - alterar usuario pelo id
update usuario set usuario = 'Sandrosr' where id = 7;


-- cruid Delete (importante usar a clausula where associada ao id) - Deletar usuário pelo id
delete from usuario where id = 11;


-- ________________________________________________________________________________________________________________________________

-- a linha abaixo seleciona todos os registros da tabela - Visualizar tabela
select * from usuario;

-- a linha abaixo seleciona todos os registros da tabela - Visualizar usuario unico
select * from usuario where id = 7;

/************** CRUD *****************/

-- CREATE (inserir 5 usuários)

-- READ 1 (selecionar todos os usuários)

-- READ 2 (selecionar um usuário específico por id)

-- UPDATE (alterar todos os dados de um usuário específico)

-- DELETE (excluir um usuário específico)

-- Gerar a documentação - Modelo ER (engenharia reversa)
 
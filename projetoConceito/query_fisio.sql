create database controleatendimento;

use controleatendimento;

create table pessoa (
cpf int primary key,
nome varchar (200) not null,
data_nasc date not null,
telefone varchar (50) not null,
email varchar (200),
endereco varchar (400),
cidade varchar (200) not null,
bairro varchar (200) not null,
complemento varchar (200) not null,
cep int,
banco varchar (100),
agencia int,
conta int
);

create table terapeuta(
especialidade varchar (200),
fk_cpf int not null,
FOREIGN KEY (fk_cpf) REFERENCES PESSOA (cpf)
);

create table cliente(
idade int not null,
idade_corrigida int,
descricao_diagnostico varchar (500) not null,
fk_cpf int not null,
FOREIGN KEY (fk_cpf) REFERENCES PESSOA (cpf)
);

create table responsavel (
fk_cpf int not null,
FOREIGN KEY (fk_cpf) REFERENCES PESSOA (cpf)

);
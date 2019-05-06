create database controleatendimento;

use controleatendimento;

create table responsavel (
cpf_resp int primary key,
nome_resp varchar (200) not null,
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

create table terapeuta (
cpf_terapeuta int primary key,
nome_terapeuta varchar (200) not null,
especialidade varchar (150),
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

create table cliente(
cpf int primary key,
idade int not null,
idade_corrigida int,
descricao_diagnostico varchar (400)not null,
data_nasc date not null,
nome varchar (200),
fk_cpf_resp int,
FOREIGN KEY (fk_cpf_resp) REFERENCES responsavel (cpf_resp)
);

create table atendimento(
id_atendimento int AUTO_INCREMENT primary key,
valor int not null,
data_atendimento date not null,
hora_inicio time not null,
hora_fim time not null,
quantidade_sessoes int,
descricao_sessao varchar (500),
valor_sessao int,
fk_cpf_terapeuta int,
fk_cpf_cliente int,
FOREIGN KEY (fk_cpf_terapeuta) REFERENCES terapeuta (cpf_terapeuta),
FOREIGN KEY (fk_cpf_cliente) REFERENCES cliente (cpf)
);

-- preparando os Select de Responsável, Terapeuta e Cliente

select cpf_resp, nome_resp, data_nasc, telefone, email, endereco, cidade,
bairro, complemento, cep, banco, agencia, conta 
from responsavel as resp 
where resp.cpf_resp > 0;

select cpf_terapeuta, nome_terapeuta, especialidade, data_nasc, telefone, email, endereco, cidade,
bairro, complemento, cep, banco, agencia, conta 
from terapeuta as terapeuta
where terapeuta.cpf_terapeuta > 0;

select cpf, idade, idade_corrigida, descricao_diagnostico, data_nasc, nome, fk_cpf_resp
from cliente as cliente
where cliente.cpf > 0;

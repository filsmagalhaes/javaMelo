create database controleatendimento;

drop database controleatendimento;

use controleatendimento;

-- alter table responsavel 
-- modify column cpf_resp varchar (11)  primary key;

create table responsavel (
idResp int AUTO_INCREMENT primary key,
cpf_resp varchar (11),
nome_resp varchar (200) not null,
data_nasc date,
telefone varchar (50) not null,
email varchar (200),
endereco varchar (400),
cidade varchar (200) not null,
bairro varchar (200) not null,
complemento varchar (200),
cep int,
banco varchar (100),
agencia int,
conta int
);

create table terapeuta (
idTer int AUTO_INCREMENT primary key,
cpf_terapeuta varchar (11),
nome_terapeuta varchar (200) not null,
especialidade varchar (150),
data_nasc date,
telefone varchar (50) not null,
email varchar (200),
endereco varchar (400),
cidade varchar (200) not null,
bairro varchar (200) not null,
complemento varchar (200),
cep int,
banco varchar (100),
agencia int,
conta int
);

create table cliente(
idCli int AUTO_INCREMENT primary key,
cpf_cli varchar (11),
idade varchar(100) not null,
idade_corrigida varchar (100),
data_nasc date,
nome_cli varchar (200),
idResp int,
FOREIGN KEY (idResp) REFERENCES responsavel (idResp)
);

create table atendimento(
id_atendimento int AUTO_INCREMENT primary key,
data_atendimento date not null,
hora_inicio varchar (100),
hora_fim varchar (100),
quantidade_sessoes int,
descricao_diagnostico varchar (512),
descricao_sessao varchar (512),
valor_sessao decimal(10,2),
idTer int,
idCli int,
FOREIGN KEY (idTer) REFERENCES terapeuta (idTer),
FOREIGN KEY (idCli) REFERENCES cliente (idCli)
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

select cpf_cli, idade , idade_corrigida, data_nasc, nome_cli 
from cliente as cliente 
where cliente.cpf_cli > 0;

select a.data_atendimento, a.hora_inicio, a.hora_fim,
a.quantidade_sessoes, a.descricao_diagnostico, a.descricao_sessao, a.valor_sessao,
c.cpf_cli, c.idade, c.idade_corrigida, c.data_nasc, c.nome_cli
from atendimento as a
inner join cliente as c
on a.fk_cpf_cliente = c.cpf_cli
where a.id_atendimento > 0;

select * from Cliente;
select * from Responsavel;

-- preparando os Insert de Terapeuta

insert into terapeuta (cpf_terapeuta, nome_terapeuta, especialidade, data_nasc, 
telefone, email, endereco, cidade, bairro, complemento, cep, banco, agencia, conta)
values ('44455566878', 'Carla Lima', 'Fisioterapeuta', '1972/07/29', '81-998877662', 'clima@email.com', 
'R. Amanda Nunes, 776', 'Recife', 'Espinheiro', 'apto 1002', 55436786, 'Caixa', 87678, 545);

insert into terapeuta (cpf_terapeuta, nome_terapeuta, especialidade, data_nasc, 
telefone, email, endereco, cidade, bairro, complemento, cep, banco, agencia, conta)
values ('77676534290', 'Gabriela Vieira', 'Fisioterapeuta', '1978/12/14', '81-982113452', 'gaby3456@email.com', 
'R. N. S. da Piedade', 'Jaboatão', 'Piedade', 'apto 302', 78654234, 'Santander', 098765, 987);

-- preparando os Insert de Cliente

insert into cliente (cpf_cli, idade, idade_corrigida, 
data_nasc, nome_cli)
values ('98734567828', '6 meses', 'termo', '2019-02-12', 'João Pedro');

insert into cliente (cpf_cli, idade, idade_corrigida, 
data_nasc, nome_cli)
values ('54634564378', '1 ano e 3 meses', '1 ano e 5 meses', '2018-06-20', 'Maria Cecilia');

-- preparando os Insert de Resposnável

insert into responsavel (cpf_resp, nome_resp, data_nasc, 
telefone, email, endereco, cidade, bairro, complemento, cep, banco, agencia, conta)
values ('44455566878', 'Macia Fernanda', '1983/09/11', '81-984567862', 'fernandac@email.com', 
'R. carlos jose da silva, 35', 'Recife', 'Várzea', 'Casa n.2', 78543234, 'Banco do Brasil', 00009, 654536);

insert into responsavel (cpf_resp, nome_resp, data_nasc, 
telefone, email, endereco, cidade, bairro, complemento, cep, banco, agencia, conta)
values ('67653498767', 'Nilton Pereira Chaves', '1971/12/13', '81-972563412', 'niltonpc@email.com', 
'R. Vis. Albuquerque, 1112', 'Recife', 'Madalena', 'apto 102', 78543234, 'Banco do Brasil', 00012, 440000);

-- preparando os Insert de Atendimento

insert into atendimento (data_atendimento, hora_inicio, hora_fim,
quantidade_sessoes, descricao_diagnostico, descricao_sessao, valor_sessao)
values ('2019/02/14', '10:12:00', '11:20:00', 1, 'crise respiratória aguda','Atendimento respiratório com aspiração e manobras', 180);

insert into atendimento (data_atendimento, hora_inicio, hora_fim,
quantidade_sessoes, descricao_diagnostico, descricao_sessao, valor_sessao)
values ('2019/02/17', '16:24:00', '19:20:00', 2, 'crise respiratória crônica','Atendimento respiratório com aspiração e manobras e utilização de medicamento', 320);

-- preparando os Join de Responsável, Terapeuta e Cliente

SELECT r.cpf_resp, r.nome_resp, r.data_nasc, 
r.telefone, r.email, r.endereco, r.cidade, r.bairro, 
r.complemento, r.cep, r.banco, r.agencia, r.conta,
c.cpf_cli, c.idade, c.idade_corrigida, c.data_nasc, c.nome_cli, c.fk_cpf_resp
FROM responsavel as r
left JOIN cliente as c
ON r.cpf_resp = c.cpf_cli;

-- Select Atendimento

select atend.data_atendimento, atend.hora_inicio, atend.hora_fim,
atend.quantidade_sessoes, atend.descricao_diagnostico, atend.descricao_sessao, atend.valor_sessao, atend.fk_cpf_cliente, atend.fk_cpf_terapeuta,
c.cpf_cli, c.idade, c.idade_corrigida, c.data_nasc, c.nome_cli, t.nome_terapeuta
from atendimento as atend
inner join cliente as c
on atend.fk_cpf_cliente = c.cpf_cli
inner join terapeuta as t
on atend.fk_cpf_terapeuta = cpf_terapeuta
where atend.id_atendimento > 0;

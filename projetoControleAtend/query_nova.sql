create database controleatendimento;

-- drop database controleatendimento;

use controleatendimento;

-- drop table terapeuta;
-- drop table responsavel;
-- drop table cliente;
-- drop table atendimento;

create table responsavel (
cpf_resp bigint primary key,
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
cpf_terapeuta bigint primary key,
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
cpf_cli bigint primary key,
idade varchar(100) not null,
idade_corrigida varchar (100) ,
data_nasc date not null,
nome_cli varchar (200),
fk_cpf_resp bigint,
FOREIGN KEY (fk_cpf_resp) REFERENCES responsavel (cpf_resp)
);

create table atendimento(
id_atendimento int AUTO_INCREMENT primary key,
data_atendimento date not null,
hora_inicio time not null,
hora_fim time not null,
quantidade_sessoes int,
descricao_diagnostico varchar (400)not null,
descricao_sessao varchar (500),
valor_sessao decimal(10,2),
fk_cpf_terapeuta bigint,
fk_cpf_cliente bigint,
FOREIGN KEY (fk_cpf_terapeuta) REFERENCES terapeuta (cpf_terapeuta),
FOREIGN KEY (fk_cpf_cliente) REFERENCES cliente (cpf_cli)
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

-- preparando os Insert de Terapeuta

insert into terapeuta (cpf_terapeuta, nome_terapeuta, especialidade, data_nasc, 
telefone, email, endereco, cidade, bairro, complemento, cep, banco, agencia, conta)
values (44455566878, 'Carla Lima', 'Fisioterapeuta', '1972/07/29', '81-998877662', 'clima@email.com', 
'R. Amanda Nunes, 776', 'Recife', 'Espinheiro', 'apto 1002', 55436786, 'Caixa', 87678, 545);

insert into terapeuta
values (77676534290, 'Gabriela Vieira', 'Fisioterapeuta', '1978/12/14', '81-982113452', 'gaby3456@email.com', 
'R. N. S. da Piedade', 'Jaboatão', 'Piedade', 'apto 302', 78654234, 'Santander', 098765, 987);

-- preparando os Insert de Cliente

insert into cliente (cpf_cli, idade, idade_corrigida, 
data_nasc, nome_cli)
values (98734567828, '6 meses', 'termo', '2019-02-12', 'João Pedro');

insert into cliente (cpf_cli, idade, idade_corrigida, 
data_nasc, nome_cli)
values (54634564378, '1 ano e 3 meses', '1 ano e 5 meses', '2018-06-20', 'Maria Cecilia');

-- preparando os Insert de Resposnável

insert into responsavel (cpf_resp, nome_resp, data_nasc, 
telefone, email, endereco, cidade, bairro, complemento, cep, banco, agencia, conta)
values (44455566878, 'Macia Fernanda', '1983/09/11', '81-984567862', 'fernandac@email.com', 
'R. carlos jose da silva, 35', 'Recife', 'Várzea', 'Casa n.2', 78543234, 'Banco do Brasil', 00009, 654536);

insert into responsavel
values (67653498767, 'Nilton Pereira Chaves', '1971/12/13', '81-972563412', 'niltonpc@email.com', 
'R. Vis. Albuquerque, 1112', 'Recife', 'Madalena', 'apto 102', 78543234, 'Banco do Brasil', 00012, 440000);

-- preparando os Insert de Atendimento

insert into atendimento (data_atendimento, hora_inicio, hora_fim,
quantidade_sessoes, descricao_diagnostico, descricao_sessao, valor_sessao, fk_cpf_cliente, fk_cpf_terapeuta)
values ('2019/02/14', '10:12:00', '11:20:00', 1, 'crise respiratória aguda','Atendimento respiratório com aspiração e manobras', 180, 98734567828, 44455566878);

insert into atendimento (data_atendimento, hora_inicio, hora_fim,
quantidade_sessoes, descricao_diagnostico, descricao_sessao, valor_sessao, fk_cpf_cliente, fk_cpf_terapeuta)
values ('2019/02/17', '16:24:00', '19:20:00', 2, 'crise respiratória crônica','Atendimento respiratório com aspiração e manobras e utilização de medicamento', 320, 54634564378, 44455566878);

-- preparando os Join de Responsável, Terapeuta e Cliente

SELECT r.cpf_resp, r.nome_resp, r.data_nasc, 
r.telefone, r.email, r.endereco, r.cidade, r.bairro, 
r.complemento, r.cep, r.banco, r.agencia, r.conta,
c.cpf_cli, c.idade, c.idade_corrigida, c.data_nasc, c.nome_cli, c.fk_cpf_resp
FROM responsavel as r
left JOIN cliente as c
ON r.cpf_resp = c.cpf_cli
union all
SELECT r.cpf_resp, r.nome_resp, r.data_nasc, 
r.telefone, r.email, r.endereco, r.cidade, r.bairro, 
r.complemento, r.cep, r.banco, r.agencia, r.conta,
c.cpf_cli, c.idade, c.idade_corrigida, c.data_nasc, c.nome_cli, c.fk_cpf_resp
FROM responsavel as r
right JOIN cliente as c
ON r.cpf_resp = c.cpf_cli
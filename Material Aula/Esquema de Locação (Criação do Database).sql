-- Refazer tabelas rapidamente
drop table ator,categoria,endereco,genero,profissao,filme_ator,filme,
	locacao_filme,locacao,cliente,dependente,cli_endereco;

create database hibernate;

alter database hibernate;
create table ator
(
	COD_ATOR serial primary key,
	NOME varchar(60) not null
);

create table genero
(
	COD_GEN serial primary key,
	NOME varchar(60) not null
);

create table categoria
(
	COD_CAT serial primary key,
	NOME varchar(60)not null,
	VALOR numeric(15,2) not null
);

create table profissao
(
	COD_PROF serial primary key,
	NOME varchar(60) not null
);

create table endereco
(
	COD_END serial primary key,
	LOGRADOURO varchar(40) not null,
	TIPO_LOG varchar(40)not null,
	COMPLEMENTO varchar(40)not null,
	CIDADE varchar(60)not null,
	UF char(2)not null,
	CEP char(8)not null,
	NUMERO varchar(10)not null,
	BAIRRO varchar(60) not null
);

create table filme
(
	COD_FILME serial primary key,
	TITULO_ORIGINAL varchar(100) not null,
	TITULO varchar(100) not null,
	QUANTIDADE integer not null,
	COD_GEN integer not null,
	foreign key (COD_GEN) REFERENCES genero(COD_GEN),
	COD_CAT integer not null,
	foreign key (COD_CAT) REFERENCES categoria(COD_CAT)
);

create table cliente
(
	COD_CLI serial primary key,
	CPF varchar(11) not null,
	NOME varchar(60) not null,
	TELEFONE varchar(16) not null,
	COD_PROF integer not null,
	foreign key (COD_PROF) REFERENCES profissao(COD_PROF)
);


create table locacao
(
	COD_LOC serial primary key,
	DATA_LOC date not null,
	DESCONTO numeric(15,2) not null,
	MULTA numeric(15,2) not null,
	SUB_TOTAL numeric(15,2) not null,
	COD_CLI integer not null,
	foreign key (COD_CLI) REFERENCES cliente(COD_CLI)
);

create table dependente
(
	COD_CLI integer not null,
	foreign key (COD_CLI) REFERENCES cliente(COD_CLI),
	COD_DEP integer not null,
	foreign key (COD_DEP) REFERENCES cliente(COD_CLI),
	PARENTESCO varchar(20)
);

create table filme_ator
(
	primary key (COD_ATOR, COD_FILME),
	COD_ATOR integer not null,
	foreign key (COD_ATOR) REFERENCES ator(COD_ATOR),
	COD_FILME integer not null,
	foreign key (COD_FILME) REFERENCES filme(COD_FILME),
	ATOR char(1) not null,
	DIRETOR char(1) not null
);

create table locacao_filme
(
	primary key (COD_LOC, COD_FILME),
    COD_LOC integer not null,
    foreign key (COD_LOC) REFERENCES locacao(COD_LOC),
    COD_FILME integer not null,
    foreign key (COD_FILME) REFERENCES filme(COD_FILME),
    VALOR numeric(15,2) not null,
    NUM_DIAS integer not null,
    DATA_DEVOL date not null
);

create table cli_endereco
(
	primary key (COD_END, COD_CLI),
	COD_END integer not null,
	foreign key (COD_END) REFERENCES endereco(COD_END),
	COD_CLI integer not null,
	foreign key (COD_CLI) REFERENCES cliente(COD_CLI)
);

create table users(
    id int PRIMARY KEY unique NOT NULL,
    nome varchar(64),
    email varchar(64),
    telefone varchar(11),
    senha varchar(255),
    perfil varchar(32)
);

create table event(
    id int primary key unique not null,
    titulo varchar(128),
    descricao varchar(3000),
    capacidade int,
    data DATE,
    hora TIME,
    tipo varchar(32),
    id_admin int not null,
    foreign key (id_admin) references users(id)
);
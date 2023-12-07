create sequence sq_cliente
start 1
increment 1
owned by tb_cliente.id;


create table tb_cliente (
    id bigint,
    nome varchar(50) not null,
    cpf bigint not null,
    tel bigint not null,
    endereco varchar(50) not null,
    numero bigint not null,
    estado varchar(50) not null,
    constraint pk_id_cliente primary key (id)

);

select * from tb_cliente;
drop table tb_cliente;

insert into tb_cliente values ('Kezia', 102030);

create sequence sq_produto
start 1
increment 1
owned by tb_produto.id;

create table tb_produto (
  id bigint,
  nome varchar(50) not null,
  cpf bigint not null,
  tel bigint not null,
  endereco varchar(50) not null,
  numero bigint not null,
  estado varchar(50) not null,
  constraint pk_id_produto primary key (id)

);

select * from tb_produto;
drop table tb_produto;

insert int tb_produto values ('Bolsa', 102.00);
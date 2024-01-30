create table products(
    id bigint not null AUTO_INCREMENT,
    name varchar(255) not null,
    code varchar(255) not null,
    value varchar(255) not null,
    active tinyint not null,

    primary key(id)
)
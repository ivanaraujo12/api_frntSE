create table financial (
    id bigint not null AUTO_INCREMENT,
    description varchar(250) not null,
    value int not null,
    stock varchar(250) not null,
    active tinyint not null,

    primary key(id)
)
create table contacts(
    id bigint not null AUTO_INCREMENT,
    name varchar(255) not null,
    email varchar(255) not null,
    number varchar(15) not null,
    active tinyint not null,

    primary key(id)
)
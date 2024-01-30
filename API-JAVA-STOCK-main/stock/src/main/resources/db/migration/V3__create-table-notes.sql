create table notes(
    id bigint not null AUTO_INCREMENT,
    title varchar(230) not null,
    description varchar(230) not null,
    active tinyint not null,

    primary key(id)
)
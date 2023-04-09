create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    password varchar(64) not null,
    username varchar(64) not null unique
);

CREATE TABLE todo (
    id SERIAL PRIMARY KEY,
    title varchar(64) not null,
    completed BOOLEAN not null
);

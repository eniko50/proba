create database dbcountry;

use dbcountry;

create table country (
	id integer auto_increment,
	name varchar(100) not null,
	population int,
	primary key (id)
);

insert into country (name, population) values ('Serbia', 7098000);
insert into country (name, population) values ('France', 66810000);
insert into country (name, population) values ('Italy', 60800000);
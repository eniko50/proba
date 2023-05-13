create database db_jpa_places;

use db_jpa_places;

create table country (
	id integer auto_increment,
	name varchar(100) not null,
	population int,
	primary key (id)
);

create table place (
	id integer auto_increment,
	zip_code integer not null,
	name varchar(100) not null,
	country_id integer,
	foreign key (country_id) references councountrytry(id),
	primary key (id)
);


insert into country (name, population) values ('Serbia', 7098000);
insert into country (name, population) values ('France', 66810000);
insert into country (name, population) values ('Italy', 60800000);

insert into place (name, zip_code, country_id) values ('Beograd', 11000, 1);
insert into place (name, zip_code, country_id) values ('Novi Sad', 21000, 1);
insert into place (name, zip_code, country_id) values ('Paris', 75008, 2);
insert into place (name, zip_code, country_id) values ('Marseille', 13014, 2);
insert into place (name, zip_code, country_id) values ('Rome', 30149, 3);
insert into place (name, zip_code, country_id) values ('Bologna', 40121, 3);

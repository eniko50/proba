drop database drzave;
create database drzave;
use drzave;

create table country (
	id integer,
	name varchar(255),
	primary key (id)
);

create table place (
	place_id integer,
	name varchar(255),
	population integer,
	country_id integer,
	primary key(place_id),
	foreign key(country_id)
		references country(id)
);

insert into country values (1, 'Srbija');
insert into country values (2, 'Rumunija');
insert into country values (3, 'Grcka');

insert into place values (1, 'Novi Sad', 252459, 1);
insert into place values (2, 'Beograd', 1351000, 1);
insert into place values (3, 'Temisvar', 306462, 2);
insert into place values (4, 'Bukurest', 1913000, 2);
insert into place (place_id, name, population) values (5, 'Budimpesta', 1300000);

SELECT * FROM place JOIN country ON country_id=id;
SELECT * FROM place LEFT JOIN country ON country_id=id;
SELECT * FROM place RIGHT JOIN country ON country_id=id;

SELECT SUM(population) FROM place;

SELECT SUM(population), country.name 
FROM place LEFT JOIN country ON country_id=id 
GROUP BY country.name;




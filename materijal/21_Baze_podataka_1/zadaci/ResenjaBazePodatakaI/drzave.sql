-- 1.

create table country (
	code char(2),
	name varchar(255),
	population integer,
	primary key (code)
);

insert into country (code, name, population) values ('sr', 'Srbija', 7164000);
insert into country (code, name, population) values ('hu', 'Mađarska', 9897000);
insert into country (code, name, population) values ('it', 'Italija', 59830000);
insert into country (code, name, population) values ('gr', 'Grčka', 11030000);
insert into country values ('po', 'Poljska', 38530000); -- ako navodimo sve vrednosti polja, ne moramo navoditi imena polja

-- 1.1.
select code, name, population from country;
-- moze i ovako
-- select * from country;

-- 1.2.
select * from country where population > 20000000;

-- 1.3.
select * from country order by name asc; -- asc je default pa se moze i izostaviti

-- 1.4.
select * from country where population > 10000000 and population < 20000000;

-- 1.5.
select * from country where name like '%r%';

-- 1.6.
update country set population = 7165000 where code = 'sr';

-- 1.7.
delete from country where code = 'po';

-- 1.8.
alter table country modify name varchar(255) not null;

-- 1.9.	
select * from country where left(name, 2) = code; -- left funkcija vraca prvih N karaktera stringa


-- 2.
create table place (
	id integer auto_increment,
	zip_code integer,
	name varchar(255) not null,
	country_id char(2),
	primary key(id),
	foreign key(country_id)
		references country(code)
);

insert into place (zip_code, name, country_id) values (11000, 'Beograd', 'sr');
insert into place (zip_code, name, country_id) values (21000, 'Novi Sad', 'sr');
insert into place (zip_code, name, country_id) values (30601, 'Atina', 'gr');
insert into place (zip_code, name, country_id) values (54642, 'Solun', 'gr');
insert into place (zip_code, name, country_id) values (30149, 'Rim', 'it');
insert into place (zip_code, name) values (10013, 'Madrid');


-- 2.1.
select * from place where country_id = 'sr';

-- 2.2.
select * from place where country_id is null;

-- 2.3.
select * from place where country_id is not null order by country_id desc;

-- 2.4.
select * from place where country_id in (select code from country where population > 10000000);


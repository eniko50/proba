create table drzava (
	oznaka char(2),
	naziv varchar(100) not null,
	broj_stanovnika integer,
	primary key (oznaka)
);

insert into drzava (oznaka, naziv, broj_stanovnika)
	values ('sr', 'Srbija', 7164000);

select * from drzava;

select * from drzava where broj_stanovnika > 20000000;

select * from drzava order by naziv;
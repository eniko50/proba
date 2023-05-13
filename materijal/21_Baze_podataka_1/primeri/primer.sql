create database studentskasluzba;

use studentskasluzba;

create table grad (
	ptt_broj integer,
	naziv varchar(100),
	primary key (ptt_broj)
);

create table student (
	broj_indeksa varchar(10),
	ime varchar(50),
	prezime varchar(50),
	prebivaliste integer,
	primary key (broj_indeksa),
	foreign key (prebivaliste) references grad(ptt_broj) 
);

alter table grad modify naziv varchar(150);

insert into grad (ptt_broj, naziv) values (21000, 'Novi Sad');
insert into grad (ptt_broj, naziv) values (11000, 'Beograd');
insert into grad (ptt_broj, naziv) values (18000, 'Nis');
insert into grad (ptt_broj, naziv) values (24000, 'Subotica');
insert into grad (ptt_broj, naziv) values (34000, 'Kragujevac');

select ptt_broj, naziv from grad;

select * from grad;

select naziv from grad;

select * from grad where ptt_broj < 20000;

select * from grad where ptt_broj < 15000 OR 
	(ptt_broj > 20000 AND naziv like '%c%');

select * from grad order by naziv desc, ptt_broj asc;

update grad set naziv = ’Belgrade’ where ptt_broj = 11000;

delete from grad where ptt_broj = 11000;

drop database studentskasluzba;
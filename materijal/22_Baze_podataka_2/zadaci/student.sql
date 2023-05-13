DROP DATABASE vp;

CREATE DATABASE vp;

USE vp;

create table student (
	id integer auto_increment, 
	br_indeksa varchar(10) not null,
	ime varchar(100) not null,
	prezime varchar(100) not null,
	primary key (id)
);

create table predmet (
	id integer auto_increment,
	naziv varchar(200) not null,
	primary key(id)
);

create table ispit (
	id integer auto_increment,
	student_id integer,
	predmet_id integer,
	ocena integer,
	primary key (id),
	foreign key (student_id) references student(id),
	foreign key (predmet_id) references predmet(id)
);

insert into student (id, br_indeksa, ime, prezime) values (1, 'e12','Pera', 'Peric');
insert into student (id, br_indeksa, ime, prezime) values (2, 'e15','Steva', 'Stevic');
insert into student (id, br_indeksa, ime, prezime) values (3, 'e18','Marko', 'Markovic');
insert into student (id, br_indeksa, ime, prezime) values (4, 'e22','Mitar', 'Mitrovic');
insert into student (id, br_indeksa, ime, prezime) values (5, 'e25','Jovan', 'Jovanovic');

insert into predmet (id, naziv) values (1,'Matematicka analiza');
insert into predmet (id, naziv) values (2,'Web programiranje');
insert into predmet (id, naziv) values (3,'Objektno orjentisano programiranje');
insert into predmet (id, naziv) values (4,'Racunarska inteligencija');

insert into ispit (student_id, predmet_id, ocena) values (1,1,7);
insert into ispit (student_id, predmet_id, ocena) values (1,2,8);
insert into ispit (student_id, predmet_id, ocena) values (1,3,7);

insert into ispit (student_id, predmet_id, ocena) values (2,1,7);
insert into ispit (student_id, predmet_id, ocena) values (2,2,9);
insert into ispit (student_id, predmet_id, ocena) values (2,3,9);

insert into ispit (student_id, predmet_id, ocena) values (3,1,10);
insert into ispit (student_id, predmet_id, ocena) values (3,3,10);

insert into ispit (student_id, predmet_id, ocena) values (4,2,8);
insert into ispit (student_id, predmet_id, ocena) values (4,3,9);
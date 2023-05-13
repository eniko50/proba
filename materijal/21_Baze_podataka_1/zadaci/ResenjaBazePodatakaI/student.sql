-- 3.
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
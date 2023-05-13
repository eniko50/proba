create database db_jpa_students;

use db_jpa_students;

create table student (
	id integer auto_increment,
	card_number varchar(10) not null,
	first_name varchar(50),
	last_name varchar(50),
	primary key (id)
);

create table course (
	id integer auto_increment,
	name varchar(100) not null,
	espb integer,
	primary key (id)
);

create table exam (
	id integer auto_increment,
	student_id integer not null,
	course_id integer not null,
	grade integer,
	foreign key (student_id) references student(id),
	foreign key (course_id) references course(id),
	primary key (id)
);

insert into student (card_number, first_name, last_name) values ('e44', 'Zoran', 'Zoranovic');
insert into student (card_number, first_name, last_name) values ('e352', 'Ana', 'Krunic');
insert into student (card_number, first_name, last_name) values ('e20', 'Stevan', 'Stevic');
insert into student (card_number, first_name, last_name) values ('e22', 'Mihajlo', 'Mihajlovic');
insert into student (card_number, first_name, last_name) values ('e123', 'Mitar', 'Markovic');

insert into course (name, espb) values ('Web programiranje', 6);
insert into course (name, espb) values ('Testiranje softvera', 4);
insert into course (name, espb) values ('Algebra', 8);
insert into course (name, espb) values ('Algoritmi i strukture podataka', 6);
insert into course (name, espb) values ('Objektno orijentisano programiranje', 8);
insert into course (name, espb) values ('Klijentske tehnologije', 6);
insert into course (name, espb) values ('Sistemi bazirani na znanju', 5);

insert into exam (student_id, course_id, grade) values (1, 1, 8);
insert into exam (student_id, course_id, grade) values (1, 2, 7);
insert into exam (student_id, course_id, grade) values (2, 3, 10);
insert into exam (student_id, course_id, grade) values (3, 4, 9);
insert into exam (student_id, course_id, grade) values (4, 1, 9);
insert into exam (student_id, course_id, grade) values (4, 3, 10);
insert into exam (student_id, course_id, grade) values (5, 7, 10);
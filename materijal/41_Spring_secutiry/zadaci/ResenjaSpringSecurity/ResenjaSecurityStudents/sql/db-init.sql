create database db_security_students;
use db_security_students;

drop database dbcountrysecurity;
drop database dbcountry;
-- insert users
create table security_user(
	id integer auto_increment,
	username varchar(255),
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key(id)
);
-- password is 12345 (bcrypt encoded) 
insert into security_user (username, password, first_name, last_name) values 
	('admin', '$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi', 'Admin', 'Admin');
-- password is abcdef (bcrypt encoded)
insert into security_user (username, password, first_name, last_name) values 
	('petar', '$2a$04$Yr3QD6lbcemnrRNLbUMLBez2oEK15pdacIgfkvymQ9oMhqsEE56EK', 'Petar', 'Petrovic');

select*from security_user;

create table security_authority(
	id integer auto_increment,
    name varchar(255),
    primary key(id)
);
-- insert authorities
insert into security_authority (name) values ('ROLE_ADMIN'); -- super user
insert into security_authority (name) values ('ROLE_USER'); -- normal user

select*from security_authority;

create table security_user_authority(
	id integer auto_increment,
    user_id integer,
    authority_id integer,
    primary key(id),
    foreign key(user_id) references security_user(id),
    foreign key(authority_id) references security_authority(id)
);
-- insert mappings between users and authorities
insert into security_user_authority (user_id, authority_id) values (1, 1); -- admin has ROLE_ADMIN
insert into security_user_authority (user_id, authority_id) values (1, 2); -- admin has ROLE_USER too
insert into security_user_authority (user_id, authority_id) values (2, 2); -- petar has ROLE_USER

select*from security_user_authority;

create table student(
	id integer auto_increment,
    card_number varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key(id)
);
insert into student (card_number, first_name, last_name) values ('e44', 'Zoran', 'Zoranovic');
insert into student (card_number, first_name, last_name) values ('e352', 'Ana', 'Krunic');
insert into student (card_number, first_name, last_name) values ('e20', 'Stevan', 'Stevic');
insert into student (card_number, first_name, last_name) values ('e22', 'Mihajlo', 'Mihajlovic');
insert into student (card_number, first_name, last_name) values ('e123', 'Mitar', 'Markovic');

select*from student;

create table course(
	id integer auto_increment,
    name varchar(255),
    espb integer,
    primary key(id)
);
insert into course (name, espb) values ('Web programiranje', 6);
insert into course (name, espb) values ('Testiranje softvera', 4);
insert into course (name, espb) values ('Algebra', 8);
insert into course (name, espb) values ('Algoritmi i strukture podataka', 6);
insert into course (name, espb) values ('Objektno orijentisano programiranje', 8);
insert into course (name, espb) values ('Klijentske tehnologije', 6);
insert into course (name, espb) values ('Sistemi bazirani na znanju', 5);

select*from course;

create table exam(
	id integer auto_increment,
    student_id integer,
    course_id integer,
    grade integer,
    primary key(id),
    foreign key(student_id) references student(id),
    foreign key(course_id) references course(id)
);
insert into exam (student_id, course_id, grade) values (1, 1, 8);
insert into exam (student_id, course_id, grade) values (1, 2, 7);
insert into exam (student_id, course_id, grade) values (2, 3, 10);
insert into exam (student_id, course_id, grade) values (3, 4, 9);
insert into exam (student_id, course_id, grade) values (4, 1, 9);
insert into exam (student_id, course_id, grade) values (4, 3, 10);
insert into exam (student_id, course_id, grade) values (5, 7, 10);

select*from exam;
use dbcountrysecurity;



create table security_user(
	id integer auto_increment,
	username varchar(255),
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key(id)
);

alter table security_user add column password varchar(255);

-- insert users
-- password is 12345 (bcrypt encoded) 
insert into security_user (username, password, first_name, last_name) values 
	('admin', '$2y$12$j0JBocDs5OsGsY.qKDm1yeQ5.VdKrv3W3cuFlRAuiS8zw0nfvTn5K', 'Admin', 'Admin');
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
-- insert countries

insert into country (name, population) values ('Serbia', 7098000);
insert into country (name, population) values ('France', 66810000);
insert into country (name, population) values ('Italy', 60800000);

select*from country;


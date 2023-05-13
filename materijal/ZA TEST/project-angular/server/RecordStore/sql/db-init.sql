-- insert users
-- password is 12345 (bcrypt encoded) 
insert into security_user (username, password, first_name, last_name) values 
	('admin', '$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi', 'Admin', 'Admin');
-- password is abcdef (bcrypt encoded)
insert into security_user (username, password, first_name, last_name) values 
	('petar', '$2a$04$Yr3QD6lbcemnrRNLbUMLBez2oEK15pdacIgfkvymQ9oMhqsEE56EK', 'Petar', 'Petrovic');

-- insert authorities
insert into security_authority (name) values ('ROLE_ADMIN'); -- super user
insert into security_authority (name) values ('ROLE_USER'); -- normal user

-- insert mappings between users and authorities
insert into security_user_authority (user_id, authority_id) values (1, 1); -- admin has ROLE_ADMIN
insert into security_user_authority (user_id, authority_id) values (1, 2); -- admin has ROLE_USER too
insert into security_user_authority (user_id, authority_id) values (2, 2); -- petar has ROLE_USER


insert into project (description, name, readme) values ("ovo je 2 projekat", "2", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 2");
insert into project (description, name, readme) values ("ovo je 3 projekat", "3", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 3");
insert into project (description, name, readme) values ("ovo je 4 projekat", "4", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 4");
insert into project (description, name, readme) values ("ovo je 5 projekat", "5", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 5");
insert into project (description, name, readme) values ("ovo je 6 projekat", "6", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 6");
insert into project (description, name, readme) values ("ovo je 7 projekat", "7", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 7");
insert into project (description, name, readme) values ("ovo je 8 projekat", "8", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 8");
insert into project (description, name, readme) values ("ovo je 9 projekat", "9", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 9");
insert into project (description, name, readme) values ("ovo je 10 projekat", "10", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 10");
insert into project (description, name, readme) values ("ovo je 11 projekat", "11", "Detaljno cu ga opisati kasnije posto sam kratak sa vremenom 11");

insert into comment (text, username, project_id) values ("komentar 1", "kralj", 1);
insert into comment (text, username, project_id) values ("komentar 2", "kralj", 1);
insert into comment (text, username, project_id) values ("komentar 3", "kralj", 1);

insert into comment (text, username, project_id) values ("komentar 1", "kralj", 2);
insert into comment (text, username, project_id) values ("komentar 2", "kralj", 2);
insert into comment (text, username, project_id) values ("komentar 3", "kralj", 2);

insert into comment (text, username, project_id) values ("komentar 1", "kralj", 3);
insert into comment (text, username, project_id) values ("komentar 2", "kralj", 3);
insert into comment (text, username, project_id) values ("komentar 3", "kralj", 3);

insert into comment (text, username, project_id) values ("komentar 1", "kralj", 4);
insert into comment (text, username, project_id) values ("komentar 2", "kralj", 4);
insert into comment (text, username, project_id) values ("komentar 3", "kralj", 5);

insert into comment (text, username, project_id) values ("komentar 1", "kralj", 6);
insert into comment (text, username, project_id) values ("komentar 2", "kralj", 6);
insert into comment (text, username, project_id) values ("komentar 3", "kralj", 6);

insert into comment (text, username, project_id) values ("komentar 1", "kralj", 10);
insert into comment (text, username, project_id) values ("komentar 2", "kralj", 11);
insert into comment (text, username, project_id) values ("komentar 3", "kralj", 2);


create database db_building;
use db_building;

-- insert users
-- password is 12345 (bcrypt encoded) 
insert into security_user (id, username, password, first_name, last_name) values 
	(1, 'admin', '$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi', 'Admin', 'Admin');
-- password is abcdef (bcrypt encoded)
insert into security_user (id, username, password, first_name, last_name) values 
	(2, 'petar', '$2a$04$Yr3QD6lbcemnrRNLbUMLBez2oEK15pdacIgfkvymQ9oMhqsEE56EK', 'Petar', 'Petrovic');

-- insert authorities
insert into security_authority (id, name) values (1, 'ROLE_ADMIN'); -- super user
insert into security_authority (id, name) values (2, 'ROLE_USER'); -- normal user

-- insert mappings between users and authorities
insert into security_user_authority (id, user_id, authority_id) values (1, 1, 1); -- admin has ROLE_ADMIN
insert into security_user_authority (id, user_id, authority_id) values (2, 1, 2); -- admin has ROLE_USER too
insert into security_user_authority (id, user_id, authority_id) values (3, 2, 2); -- petar has ROLE_USER

insert into building (name, numberOgFloors) values ('Promenada',3);
insert into building (name, numberOgFloors) values ('Sheraton',5);

insert into elevator (number, currentFloor, numberOfMaxFloorsLeft, correct, building_id) values (25, 2, 120, true, 1);
insert into elevator (number, currentFloor, numberOfMaxFloorsLeft, correct, building_id) values (22, 5, 20, true,2);
insert into elevator (number, currentFloor, numberOfMaxFloorsLeft, correct) values (10, 2, 240, true, 2);




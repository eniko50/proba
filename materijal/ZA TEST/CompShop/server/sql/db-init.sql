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


insert into brend (naziv) values ('intel');
insert into brend (naziv) values ('ASRock');
insert into brend (naziv) values ('GIGABYTE');
insert into brend (naziv) values ('ASUS');


insert into kategorija (naziv) values ('Maticne Ploce');
insert into kategorija (naziv) values ('Memorije');
insert into kategorija (naziv) values ('Procesori');

insert into artikal (naziv, brend_id, kategorija_id, cena) values ('ASUS ROG STRIX B350-F GAMING AM4 AMD B350 SATA 6Gb/s USB 3.1 HDMI ATX AMD Motherboard',
1,1, 199.99);
insert into artikal (naziv, brend_id, kategorija_id, cena) values ('ASRock AB350M Pro4 AM4 AMD Promontory B350 SATA 6Gb/s USB 3.1 HDMI Micro ATX AMD Motherboard',
2,2, 399.99);

insert into artikal (naziv, brend_id, kategorija_id, cena) values ('SuperUltraGrafika',
3,3, 599.99);

insert into artikal (naziv, brend_id, kategorija_id, cena) values ('Procesor1',
3,2, 199.99);

insert into artikal (naziv, brend_id, kategorija_id, cena) values ('Procesor2',
3,2, 199.99);
insert into artikal (naziv, brend_id, kategorija_id, cena) values ('Procesor3',
3,1, 199.99);


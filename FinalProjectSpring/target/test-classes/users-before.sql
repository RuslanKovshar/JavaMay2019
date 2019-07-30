DELETE FROM receipts;
DELETE FROM applications;
DELETE FROM user_roles;
DELETE FROM users;

INSERT INTO users (id, active, email, password, balance) VALUES
(1,true,'example@mail.com','$2a$10$u75tU1T/4TOAoIIcxVj8Q..Uxx/5HHxpd3juUfUb8pJfDnxW.LPEm',0),
(2,true,'ruslan.kovshar@gmail.com','$2a$10$rrshi5NSGtWp.5njXyECS.I6ltl.rpHX.67kojHSNSjwWX62bJygW',0);

INSERT INTO user_roles (user_id, authorities) VALUES
(1,'USER'),(2,'USER'),(2,'ADMIN');

INSERT INTO applications(id, local_date, type, weight, address) VALUES
(1,'2019-07-31','Load',15,'Konotop'),(2,'2019-08-01','Tires',20,'Kyiv'),
(3,'2019-07-30','Documents',0.1,'Konotop'),(4,'2019-07-31','Pallets',660,'Kyiv');

INSERT INTO receipts (id, cost, application_id, user_id) VALUES
(1,100,1,1),(2,355,2,1),(3,500,3,1),
(4,1000,4,2);
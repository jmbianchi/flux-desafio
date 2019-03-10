create database db_flux;-- create database
create user 'fluxuser'@'%' identified by 'fluxuser'; -- Creates the user
grant all on db_flux.* to 'fluxuser'@'%'; -- Gives all the privileges to the new user on the newly created database

use db_flux;

CREATE TABLE app_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE app_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES app_user (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES app_role (id)
);


CREATE TABLE candidatos (
dni bigint(8),
domicilio varchar(100) NOT NULL,
email varchar(50) NOT NULL,
fecha_nacimiento datetime NOT NULL,
nombre_apellido varchar(100) NOT NULL,
telefono  varchar(20) NOT NULL,
PRIMARY KEY (dni)
);


INSERT INTO app_role (id, role_name) VALUES (1, 'STANDARD_USER');
INSERT INTO app_role (id, role_name) VALUES (2, 'ADMIN_USER');

-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'Flux', 'User', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'flux.user');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
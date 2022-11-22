CREATE TABLE tasks(
    id bigint primary key not null auto_increment,
    user_id bigint,
    task varchar(100),
    description varchar(300),
    dt_insert varchar(30),
    dt_update varchar(30),
    status varchar(20)
);

CREATE TABLE users(
    id bigint primary key not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null,
    password varchar(100) not null
);

CREATE TABLE profiles(
    id bigint primary key not null auto_increment,
    name varchar(100) not null
);

CREATE TABLE users_profiles (
    user_id bigint not null,
    profiles_id bigint not null
);

INSERT INTO profiles(id, name) VALUES(null, 'ADMIN');
INSERT INTO profiles(id, name) VALUES(null, 'USER');

INSERT INTO users(id, name, email, password) VALUES(null, 'admin', 'admin@email.com', '$2a$10$TdlSMKd1QMJNFT5DEmPozOJ93QUDOhVLdYDQQUFmwXaRctNUiRMRm');
INSERT INTO users(id, name, email, password) VALUES(null, 'user', 'user@email.com', '$2a$10$TdlSMKd1QMJNFT5DEmPozOJ93QUDOhVLdYDQQUFmwXaRctNUiRMRm');
INSERT INTO users(id, name, email, password) VALUES(null, 'Sem acesso', 'semacesso@email.com', '$2a$10$TdlSMKd1QMJNFT5DEmPozOJ93QUDOhVLdYDQQUFmwXaRctNUiRMRm');

INSERT INTO users_profiles(user_id, profiles_id) VALUES(1, 1);
INSERT INTO users_profiles(user_id, profiles_id) VALUES(2, 2);
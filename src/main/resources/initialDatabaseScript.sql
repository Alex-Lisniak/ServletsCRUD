drop table if exists users;
create table if not exists users

(
    user_id   SERIAL,
    user_name TEXT NOT NULL ,
    user_surname TEXT NOT NULL,
    user_age INT NOT NULL
);
INSERT INTO users (user_name, user_surname, user_age) values ('OleksandrP' ,'surname',30);
INSERT INTO users (user_name, user_surname, user_age) values ('OleksandrL' ,'surname',20);
INSERT INTO users (user_name, user_surname, user_age) values ('SyrymKh' ,'surname',20);
INSERT INTO users (user_name, user_surname, user_age) values ('OlehZ' ,'surname',20);
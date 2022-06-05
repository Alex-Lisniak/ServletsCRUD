drop table if exists students;
create table if not exists students

(
    student_id   SERIAL,
    student_name TEXT NOT NULL ,
    student_surname TEXT NOT NULL,
    student_age INT NOT NULL
);
INSERT INTO students (student_name, student_surname, student_age) values ('OleksandrP' ,'surname',30);
INSERT INTO students (student_name, student_surname, student_age) values ('OleksandrL' ,'surname',20);
INSERT INTO students (student_name, student_surname, student_age) values ('SyrymKh' ,'surname',20);
INSERT INTO students (student_name, student_surname, student_age) values ('OlehZ' ,'surname',20);


insert into courses(id, name, created_date, last_update_date) values(10001, 'JPA in 50 Steps', sysdate(), sysdate() );
insert into courses(id, name, created_date, last_update_date) values(10002, 'Spring in 100 Steps', sysdate(), sysdate());
insert into courses(id, name, created_date, last_update_date) values(10003, 'SpringBoot in 100 Steps', sysdate(), sysdate());

insert into passports (id, number) values (40001, 'E123456');
insert into passports (id, number) values (40002, 'N123457');
insert into passports (id, number) values (40003, 'L123890');

insert into students (id, name, passport_id) values (20001, 'Ranga', 40001);
insert into students (id, name, passport_id) values (20002, 'Lucas', 40002);
insert into students (id, name, passport_id) values (20003, 'Martin', 40003);

insert into reviews (id, rating, description, course_id) values (50001, '5', 'Great Course', 10001);
insert into reviews (id, rating, description, course_id) values (50002, '4', 'Good Course', 10001);
insert into reviews (id, rating, description, course_id) values (50003, '3', 'Soso Course', 10002);
insert into reviews (id, rating, description, course_id) values (50004, '2', 'Bad Course', 10002);
insert into reviews (id, rating, description, course_id) values (50005, '1', 'Awful Course', 10003);

insert into student_course (id_student, id_course) values (20001, 10001);
insert into student_course (id_student, id_course) values (20002, 10001);
insert into student_course (id_student, id_course) values (20003, 10001);
insert into student_course (id_student, id_course) values (20003, 10003);
insert into student_course (id_student, id_course) values (20002, 10003);



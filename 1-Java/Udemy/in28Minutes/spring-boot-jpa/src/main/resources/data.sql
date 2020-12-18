insert into courses(id, name, created_date, last_update_date, is_deleted) values(10001, 'JPA in 50 Steps', sysdate(), sysdate(), false );
insert into courses(id, name, created_date, last_update_date, is_deleted) values(10002, 'Spring in 100 Steps', sysdate(), sysdate(), false);
insert into courses(id, name, created_date, last_update_date, is_deleted) values(10003, 'SpringBoot in 100 Steps', sysdate(), sysdate(), false);
insert into courses(id, name, created_date, last_update_date, is_deleted) values(10004, 'Dummy 1', sysdate(), sysdate(), false);
insert into courses(id, name, created_date, last_update_date, is_deleted) values(10005, 'Dummy 2', sysdate(), sysdate(), false);
insert into courses(id, name, created_date, last_update_date, is_deleted) values(10006, 'Dummy 3', sysdate(), sysdate(), false);
insert into courses(id, name, created_date, last_update_date, is_deleted) values(10007, 'Dummy 4', sysdate(), sysdate(), false);
insert into courses(id, name, created_date, last_update_date, is_deleted) values(10008, 'Dummy 5', sysdate(), sysdate(), false);

insert into passports (id, number) values (40001, 'E123456');
insert into passports (id, number) values (40002, 'N123457');
insert into passports (id, number) values (40003, 'L123890');

insert into students (id, name, passport_id) values (20001, 'Ranga', 40001);
insert into students (id, name, passport_id) values (20002, 'Lucas', 40002);
insert into students (id, name, passport_id) values (20003, 'Martin', 40003);

insert into reviews (id, rating, description, course_id) values (50001, 'FIVE', 'Great Course', 10001);
insert into reviews (id, rating, description, course_id) values (50002, 'FOUR', 'Good Course', 10001);
insert into reviews (id, rating, description, course_id) values (50003, 'THREE', 'Soso Course', 10002);
insert into reviews (id, rating, description, course_id) values (50004, 'TWO', 'Bad Course', 10002);
insert into reviews (id, rating, description, course_id) values (50005, 'ONE', 'Awful Course', 10003);

insert into student_course (id_student, id_course) values (20001, 10001);
insert into student_course (id_student, id_course) values (20002, 10001);
insert into student_course (id_student, id_course) values (20003, 10001);
insert into student_course (id_student, id_course) values (20003, 10003);
insert into student_course (id_student, id_course) values (20002, 10003);



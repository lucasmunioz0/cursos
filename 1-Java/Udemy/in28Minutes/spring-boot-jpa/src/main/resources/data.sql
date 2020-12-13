insert into courses(id, name, created_date, last_update_date) values(10001, 'JPA in 50 Steps', sysdate(), sysdate() );
insert into courses(id, name, created_date, last_update_date) values(10002, 'Spring in 100 Steps', sysdate(), sysdate());
insert into courses(id, name, created_date, last_update_date) values(10003, 'SpringBoot in 100 Steps', sysdate(), sysdate());

insert into passports (id, number) values (40001, 'E6532121');
insert into passports (id, number) values (40002, 'A123612');
insert into passports (id, number) values (40003, 'F8123');

insert into students (id, name, passport_id) values (2001, 'Ranga', 40001);
insert into students (id, name, passport_id) values (2002, 'Lucas', 40002);
insert into students (id, name, passport_id) values (2003, 'Martin', 40003);

insert into reviews (id, rating, description) values (5001, '5', 'Great Course');
insert into reviews (id, rating, description) values (5002, '4', 'Good Course');
insert into reviews (id, rating, description) values (5003, '3', 'Soso Course');
insert into reviews (id, rating, description) values (5004, '2', 'Bad Course');
insert into reviews (id, rating, description) values (5005, '1', 'Awful Course');



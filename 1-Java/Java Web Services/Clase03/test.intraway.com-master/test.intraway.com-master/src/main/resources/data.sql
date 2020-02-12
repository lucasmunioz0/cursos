
-- User
insert into User values (10000, 'hsimpson@gmail.com', 'Homer', 'Simpson', 'qwerty', '+123123123', 'hsimpson', 'Active');
insert into User values (10001, 'msimpson@gmail.com', 'Marge', 'Simpson', 'qwerty', '+123123124', 'msimpson', 'Active');
insert into User values (10002, 'bsimpson@hotmail.com', 'Bart', 'Simpson', 'qwerty', '+123321123', 'bsimpson', 'Blocked');
insert into User values (10003, 'lsimpson@outlook.com', 'Lisa', 'Simpson', 'qwerty', '+1234234567', 'lsimpson', 'Active');
insert into User values (10004, 'masimpson@yahoo.com', 'Maggie', 'Simpson', 'qwerty', '+1123323456', 'masimpson', 'Blocked');

-- Login
insert into login values (1, 'USER', CURRENT_DATE(), 'raul.pena@gmail.com', 1, CURRENT_DATE(), '$2a$10$PUpnDPC2ivmEPArrYAoqVOo4V.gIVKsSwnQR6MFkjVzbSlqp28LNO', CURRENT_DATE(), 'raulgpena');
insert into login values (2, 'ADMIN', CURRENT_DATE(), 'admin@gmail.com', 1, CURRENT_DATE(), '$2a$10$PUpnDPC2ivmEPArrYAoqVOo4V.gIVKsSwnQR6MFkjVzbSlqp28LNO', CURRENT_DATE(), 'admin');
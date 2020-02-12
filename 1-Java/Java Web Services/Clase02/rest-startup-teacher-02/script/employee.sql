CREATE TABLE `educacionit`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  `managerId` INT NULL,
  `city` VARCHAR(45) NOT NULL,
  `officePhone` VARCHAR(45) NOT NULL,
  `cellPhone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `picture` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO `educacionit`.`employee` (`firstName`, `lastName`, `title`, `department`, `city`, `officePhone`, `cellPhone`, `email`, `picture`)
VALUES ('Montgomery',  'Burns',  'Programmer',  'IT',  'Springfield',  '+123', '+321', 'mburns@gmail.com', 'xxx.jpg');

INSERT INTO `educacionit`.`employee` (`firstName`, `lastName`, `title`, `department`, `managerId`, `city`, `officePhone`, `cellPhone`, `email`, `picture`)
VALUES ('Homer',  'Simpson',  'Programmer',  'IT',  1,  'Springfield',  '+121212', '+212121', 'hsimpson@gmail.com', 'xxx.jpg');

INSERT INTO `educacionit`.`employee` (`firstName`, `lastName`, `title`, `department`, `managerId`, `city`, `officePhone`, `cellPhone`, `email`, `picture`)
VALUES ('Bart',  'Simpson',  'Programmer',  'IT',  1,  'Springfield',  '+1212122', '+2121213', 'bsimpson@gmail.com', 'eee.jpg');

INSERT INTO `educacionit`.`employee` (`firstName`, `lastName`, `title`, `department`, `managerId`, `city`, `officePhone`, `cellPhone`, `email`, `picture`)
VALUES ('Lisa',  'Simpson',  'Programmer',  'IT',  1,  'Springfield',  '+1213182', '+2421913', 'lisimpson@gmail.com', 'e2ee.jpg');


INSERT INTO `educacionit`.`employee` (`firstName`, `lastName`, `title`, `department`, `managerId`, `city`, `officePhone`, `cellPhone`, `email`, `picture`)
VALUES ('Maggie',  'Simpson',  'Programmer',  'IT',  1,  'Springfield',  '+12122223', '+2126763', 'magsimpson@gmail.com', 'eee4.jpg');


INSERT INTO `educacionit`.`employee` (`firstName`, `lastName`, `title`, `department`, `managerId`, `city`, `officePhone`, `cellPhone`, `email`, `picture`)
VALUES ('Marge',  'Simpson',  'Programmer',  'IT',  1,  'Springfield',  '+12124442', '+27891213', 'maimpson@hotmail.com', 'ete.jpg');
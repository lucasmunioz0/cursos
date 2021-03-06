/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 01-feb.-2020 08:42:13 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0 
;

/* Drop Tables */

DROP TABLE IF EXISTS `Personas` CASCADE
;

/* Create Tables */

CREATE TABLE `Personas`
(
	`IdPersona` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`Nombre` VARCHAR(50) NOT NULL,
	`Apellido` VARCHAR(50) NOT NULL,
	`FechaNacimiento` DATE NULL,
	`Documento` VARCHAR(50) NULL,
	`CUIL` VARCHAR(50) NULL,
	`Telefono` VARCHAR(50) NULL,
	`Celular` VARCHAR(50) NULL,
	`Email` VARCHAR(255) NULL,
	CONSTRAINT `PK_Table1` PRIMARY KEY (`IdPersona` ASC)
)

;

SET FOREIGN_KEY_CHECKS=1 
;

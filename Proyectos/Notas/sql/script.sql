/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lucas
 * Created: Feb 27, 2020
 */
CREATE SCHEMA `igsm` ;
CREATE TABLE `igsm`.`personas` (
  `idPersona` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `dni` VARCHAR(50) NOT NULL,
  `baja` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idPersona`));
CREATE TABLE `igsm`.`notas` (
  `idNota` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `valor` FLOAT NOT NULL,
  `trimestre` INT NOT NULL,
  `idPersona` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idNota`),
  INDEX `fk_notas_persona_idx` (`idPersona` ASC),
  CONSTRAINT `fk_notas_persona`
    FOREIGN KEY (`idPersona`)
    REFERENCES `igsm`.`personas` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `igsm`.`personas` (`nombre`, `apellido`, `dni`, `baja`) VALUES ('Lucas', 'Muñoz', '37627180', '0');
INSERT INTO `igsm`.`personas` (`nombre`, `apellido`, `dni`, `baja`) VALUES ('Manuel', 'Perez', '28397163', '1');



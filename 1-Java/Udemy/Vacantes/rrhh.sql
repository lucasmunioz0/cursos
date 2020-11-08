-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: rrhh
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Solicitudes`
--

DROP TABLE IF EXISTS `Solicitudes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Solicitudes` (
  `idSolicitud` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `archivo` varchar(200) NOT NULL,
  `idVacante` int NOT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `fk_Solicitudes_1_idx` (`idVacante`),
  CONSTRAINT `fk_Solicitudes_Vacantes` FOREIGN KEY (`idVacante`) REFERENCES `Vacantes` (`idVacante`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Solicitudes`
--

LOCK TABLES `Solicitudes` WRITE;
/*!40000 ALTER TABLE `Solicitudes` DISABLE KEYS */;
INSERT INTO `Solicitudes` VALUES (1,'2020-11-06','Lucas','lucasmunioz0@gmail.com','3543518545','San Juan 1549','EQOKNSMQ9DSA7LDPLVJ5CV-FORMAT.pdf',11),(2,'2020-11-06','Lucas','lucasmunioz0@gmail.com','3543518545','San Juan 1549','QTQA1PPU98SA7LDPLVJ5CV-FORMAT.pdf',11),(3,'2020-11-06','Lucas ','lucasmunioz0@gmail.com','3543518545','San Juan 1549','S4XB44X8Y5JE65KSYV4Ieuropass-curriculum-vitae-1.pdf',11),(4,'2020-11-06','Lucas ','lucasmunioz0@gmail.com','3543518545','San Juan 1549','11O6CWBJYBJE65KSYV4Ieuropass-curriculum-vitae-1.pdf',11),(5,'2020-11-06','Prueba','pruba@hotmai.com','3543518545','asdasd','FMC9BRG9ZJU7X9RVO9A0BlankResumeTemplate.pdf',11);
/*!40000 ALTER TABLE `Solicitudes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `perfil` varchar(30) DEFAULT NULL,
  `estatus` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (1,'Lucas','lucasmunioz0@gmail.com','admin','81dc9bdb52d04dc20036dbd8313ed055','Administrador','activo');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vacantes`
--

DROP TABLE IF EXISTS `Vacantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vacantes` (
  `idVacante` int NOT NULL AUTO_INCREMENT,
  `fechaPublicacion` date DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` text,
  `detalle` text,
  PRIMARY KEY (`idVacante`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vacantes`
--

LOCK TABLES `Vacantes` WRITE;
/*!40000 ALTER TABLE `Vacantes` DISABLE KEYS */;
INSERT INTO `Vacantes` VALUES (3,'2020-11-05','prueba','descripcion','detalle'),(4,'2020-11-05','prueba','descripcion','detalle'),(5,'2020-11-05','prueba','descripcion','detalle'),(8,'2020-11-05','Ingeniero en Sistemas','Detalle de ingeniero','Detalle importante'),(9,'2020-11-06','Nueva','Prueba','<p><strong>Hola</strong></p>\r\n<p>&nbsp;</p>'),(11,'2020-11-06','Desarrollador Java','Puesto para Java Sr.','<p><span style=\"font-size: 10pt;\"><strong>Requerimientos</strong></span></p>\r\n<ol>\r\n<li><span style=\"font-size: 12pt;\">Java EE<br /></span></li>\r\n<li><span style=\"font-size: 12pt;\">Spring</span></li>\r\n<li><span style=\"font-size: 12pt;\">Hibernate</span></li>\r\n<li><span style=\"font-size: 12pt;\">Docker</span></li>\r\n<li><span style=\"font-size: 12pt;\">Kubernates</span></li>\r\n<li><span style=\"font-size: 12pt;\">Amazon</span></li>\r\n</ol>\r\n<p><span style=\"font-size: 12pt; color: #e03e2d;\">Y otras cosas mas...</span></p>\r\n<p>&nbsp;</p>');
/*!40000 ALTER TABLE `Vacantes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-07 18:46:00

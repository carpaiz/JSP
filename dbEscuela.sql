-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbescuela
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiantes` (
  `idEstudiante` int(11) NOT NULL AUTO_INCREMENT,
  `Carne` varchar(6) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Telefono` varchar(100) DEFAULT NULL,
  `Correo` varchar(30) DEFAULT NULL,
  `idTipoSangre` smallint(6) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`idEstudiante`),
  KEY `idtiposangre_estudiante_tiposangre_idx` (`idTipoSangre`),
  CONSTRAINT `idtiposangre_estudiante_tiposangre` FOREIGN KEY (`idTipoSangre`) REFERENCES `tipossangre` (`idTipoSangre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantes`
--

LOCK TABLES `estudiantes` WRITE;
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
INSERT INTO `estudiantes` VALUES (1,'E001','Armando','Cardona','Guatemala','58795503','paiz2790@gmail.com',4,'2017-07-13'),(2,'E002','Augusto','Cardona','guatemala','58795503','paiz279@gmil.com',4,'2017-07-18'),(3,'E003','Luis','De leon','dd','ddd','ff',3,'1990-01-01'),(4,'C001','Armando','Paiz','28 calle zona 5 guatemala','58795503','paiz2790@gmail.com',3,'2017-07-28'),(5,'C001','Armando','Paiz','28 calle zona 5 guatemala','58795503','paiz2790@gmail.com',5,'2017-07-28'),(6,'C001','Armando','Paiz','28 calle zona 5 guatemala','58795503','paiz2790@gmail.com',5,'2017-07-28');
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipossangre`
--

DROP TABLE IF EXISTS `tipossangre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipossangre` (
  `idTipoSangre` smallint(6) NOT NULL AUTO_INCREMENT,
  `tipoSangre` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`idTipoSangre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipossangre`
--

LOCK TABLES `tipossangre` WRITE;
/*!40000 ALTER TABLE `tipossangre` DISABLE KEYS */;
INSERT INTO `tipossangre` VALUES (1,'O +'),(2,'O -'),(3,'A'),(4,'AB -'),(5,'AB +');
/*!40000 ALTER TABLE `tipossangre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbescuela'
--

--
-- Dumping routines for database 'dbescuela'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-29 15:19:20

-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sistemaveterinario
-- ------------------------------------------------------
-- Server version	5.7.31-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `idEmpresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idCliente` (`idCliente`),
  KEY `idEmpresa` (`idEmpresa`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Cliente','Favorito',123,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `cuit` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`),
  UNIQUE KEY `idEmpresa` (`idEmpresa`),
  UNIQUE KEY `cuit` (`cuit`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'utn',1234),(2,'itba',2345),(3,'uade',9999);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encuesta` (
  `idEncuesta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `idEmpresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEncuesta`),
  UNIQUE KEY `idEncuesta` (`idEncuesta`),
  KEY `idEmpresa` (`idEmpresa`),
  CONSTRAINT `encuesta_ibfk_1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuesta`
--

LOCK TABLES `encuesta` WRITE;
/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` VALUES (1,'EncuestaGral','Esta es la encuesta general',NULL,NULL,1),(2,'EncuestaGral','Esta es la encuesta general',NULL,NULL,2),(3,'EncuestaGral','Esta es la encuesta general',NULL,NULL,3),(4,'EncuestaEspecial','Encuesta especial?',NULL,NULL,1);
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuestarespondida`
--

DROP TABLE IF EXISTS `encuestarespondida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encuestarespondida` (
  `idEncuestaRespondida` int(11) NOT NULL AUTO_INCREMENT,
  `idEncuesta` int(11) NOT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `idFichaMedica` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEncuestaRespondida`),
  UNIQUE KEY `idEncuestaRespondida` (`idEncuestaRespondida`),
  KEY `idEncuesta` (`idEncuesta`),
  KEY `FK_kqmxso8qw7s5gs6mxja36hrwx` (`idFichaMedica`),
  CONSTRAINT `FK_kqmxso8qw7s5gs6mxja36hrwx` FOREIGN KEY (`idFichaMedica`) REFERENCES `fichamedica` (`idFichaMedica`),
  CONSTRAINT `encuestarespondida_ibfk_1` FOREIGN KEY (`idEncuesta`) REFERENCES `encuesta` (`idEncuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuestarespondida`
--

LOCK TABLES `encuestarespondida` WRITE;
/*!40000 ALTER TABLE `encuestarespondida` DISABLE KEYS */;
INSERT INTO `encuestarespondida` VALUES (1,1,NULL,1);
/*!40000 ALTER TABLE `encuestarespondida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `establecimiento`
--

DROP TABLE IF EXISTS `establecimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `establecimiento` (
  `idEstablecimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `activo` bit(1) DEFAULT NULL,
  `idEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idEstablecimiento`),
  UNIQUE KEY `idEstablecimiento` (`idEstablecimiento`),
  KEY `idEmpresa` (`idEmpresa`),
  CONSTRAINT `establecimiento_ibfk_1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `establecimiento`
--

LOCK TABLES `establecimiento` WRITE;
/*!40000 ALTER TABLE `establecimiento` DISABLE KEYS */;
INSERT INTO `establecimiento` VALUES (1,NULL,NULL,'campus','mozart 123',_binary '',1);
/*!40000 ALTER TABLE `establecimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fichamedica`
--

DROP TABLE IF EXISTS `fichamedica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fichamedica` (
  `idFichaMedica` int(11) NOT NULL AUTO_INCREMENT,
  `idEncuestaRespondida` int(11) NOT NULL,
  `idProfesional` int(11) NOT NULL,
  `idEstablecimiento` int(11) NOT NULL,
  `idMascota` int(11) NOT NULL,
  `fechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descripcion` date DEFAULT NULL,
  PRIMARY KEY (`idFichaMedica`),
  UNIQUE KEY `idFichaMedica` (`idFichaMedica`),
  KEY `idEncuestaRespondida` (`idEncuestaRespondida`),
  KEY `idProfesional` (`idProfesional`),
  KEY `idEstablecimiento` (`idEstablecimiento`),
  KEY `idMascota` (`idMascota`),
  CONSTRAINT `fichamedica_ibfk_1` FOREIGN KEY (`idEncuestaRespondida`) REFERENCES `encuestarespondida` (`idEncuestaRespondida`),
  CONSTRAINT `fichamedica_ibfk_2` FOREIGN KEY (`idProfesional`) REFERENCES `profesional` (`idProfesional`),
  CONSTRAINT `fichamedica_ibfk_3` FOREIGN KEY (`idEstablecimiento`) REFERENCES `establecimiento` (`idEstablecimiento`),
  CONSTRAINT `fichamedica_ibfk_4` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichamedica`
--

LOCK TABLES `fichamedica` WRITE;
/*!40000 ALTER TABLE `fichamedica` DISABLE KEYS */;
INSERT INTO `fichamedica` VALUES (1,1,1,1,1,'2020-09-06 16:57:11',NULL);
/*!40000 ALTER TABLE `fichamedica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `idMascota` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idMascota`),
  UNIQUE KEY `idMascota` (`idMascota`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (1,'asd',1),(2,'qwe',1);
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcion`
--

DROP TABLE IF EXISTS `opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opcion` (
  `idOpcion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `activo` bit(1) DEFAULT NULL,
  `idPregunta` int(11) NOT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  PRIMARY KEY (`idOpcion`),
  UNIQUE KEY `idOpcion` (`idOpcion`),
  KEY `idPregunta` (`idPregunta`),
  CONSTRAINT `opcion_ibfk_1` FOREIGN KEY (`idPregunta`) REFERENCES `pregunta` (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcion`
--

LOCK TABLES `opcion` WRITE;
/*!40000 ALTER TABLE `opcion` DISABLE KEYS */;
INSERT INTO `opcion` VALUES (1,'Hace mucho',_binary '',1,NULL,NULL),(2,'Hace poco',_binary '',1,NULL,NULL);
/*!40000 ALTER TABLE `opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pregunta` (
  `idPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `idTipoPregunta` int(11) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `idEncuesta` int(11) NOT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  PRIMARY KEY (`idPregunta`),
  UNIQUE KEY `idPregunta` (`idPregunta`),
  KEY `idTipoPregunta` (`idTipoPregunta`),
  KEY `idEncuesta` (`idEncuesta`),
  CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`idTipoPregunta`) REFERENCES `tipopregunta` (`idTipoPregunta`),
  CONSTRAINT `pregunta_ibfk_2` FOREIGN KEY (`idEncuesta`) REFERENCES `encuesta` (`idEncuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,'¿Como se llama?',1,_binary '',1,NULL,NULL),(2,'¿Hace cuanto nota los sintomas?',2,_binary '',1,NULL,NULL);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesional`
--

DROP TABLE IF EXISTS `profesional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesional` (
  `idProfesional` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `activo` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idProfesional`),
  UNIQUE KEY `idProfesional` (`idProfesional`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesional`
--

LOCK TABLES `profesional` WRITE;
/*!40000 ALTER TABLE `profesional` DISABLE KEYS */;
INSERT INTO `profesional` VALUES (1,1234,'Elias','Reuter',_binary ''),(2,1235,'Juan','Perez',_binary ''),(3,1235,'Dr','Who',_binary '');
/*!40000 ALTER TABLE `profesional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuesta` (
  `idRespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `idEncuestaRespondida` int(11) NOT NULL,
  `idPregunta` int(11) NOT NULL,
  `respuestaLibre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idRespuesta`),
  UNIQUE KEY `idRespuesta` (`idRespuesta`),
  KEY `idPregunta` (`idPregunta`),
  KEY `FK_mibku0f67m66glsxjxvi8buqc` (`idEncuestaRespondida`),
  CONSTRAINT `FK_mibku0f67m66glsxjxvi8buqc` FOREIGN KEY (`idEncuestaRespondida`) REFERENCES `encuestarespondida` (`idEncuestaRespondida`),
  CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`idPregunta`) REFERENCES `pregunta` (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,1,1,'Dogo'),(2,1,2,NULL);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestaopcion`
--

DROP TABLE IF EXISTS `respuestaopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuestaopcion` (
  `idRespuestaOpcion` int(11) NOT NULL AUTO_INCREMENT,
  `idRespuesta` int(11) NOT NULL,
  `idOpcion` int(11) NOT NULL,
  PRIMARY KEY (`idRespuesta`),
  UNIQUE KEY `idRespuestaOpcion` (`idRespuestaOpcion`),
  KEY `idOpcion` (`idOpcion`),
  CONSTRAINT `respuestaopcion_ibfk_1` FOREIGN KEY (`idOpcion`) REFERENCES `opcion` (`idOpcion`),
  CONSTRAINT `respuestaopcion_ibfk_2` FOREIGN KEY (`idRespuesta`) REFERENCES `respuesta` (`idRespuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestaopcion`
--

LOCK TABLES `respuestaopcion` WRITE;
/*!40000 ALTER TABLE `respuestaopcion` DISABLE KEYS */;
INSERT INTO `respuestaopcion` VALUES (1,2,2);
/*!40000 ALTER TABLE `respuestaopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopregunta`
--

DROP TABLE IF EXISTS `tipopregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipopregunta` (
  `idTipoPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTipoPregunta`),
  UNIQUE KEY `idTipoPregunta` (`idTipoPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopregunta`
--

LOCK TABLES `tipopregunta` WRITE;
/*!40000 ALTER TABLE `tipopregunta` DISABLE KEYS */;
INSERT INTO `tipopregunta` VALUES (1,'informacionMascota'),(2,'informacionSobreSintomas'),(3,'identificacionSintomas');
/*!40000 ALTER TABLE `tipopregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `idTurno` int(11) NOT NULL AUTO_INCREMENT,
  `idProfesional` int(11) DEFAULT NULL,
  `idEstablecimiento` int(11) DEFAULT NULL,
  `activo` bit(1) DEFAULT NULL,
  `cantHoras` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTurno`),
  UNIQUE KEY `idTurno` (`idTurno`),
  KEY `idProfesional` (`idProfesional`),
  KEY `idEstablecimiento` (`idEstablecimiento`),
  CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`idProfesional`) REFERENCES `profesional` (`idProfesional`),
  CONSTRAINT `turno_ibfk_2` FOREIGN KEY (`idEstablecimiento`) REFERENCES `establecimiento` (`idEstablecimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,1,1,_binary '',4),(2,1,1,_binary '',4);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-06 21:15:36

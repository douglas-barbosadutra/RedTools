-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: rdtools
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tab_dossier`
--

DROP TABLE IF EXISTS `tab_dossier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_dossier` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `periodo_di_imposta` varchar(4) NOT NULL,
  `costo_dipendenti_periodo_imposta` double NOT NULL,
  `fatturato_periodo_di_imposta` double NOT NULL,
  `numero_totale_dipendenti` int(10) unsigned NOT NULL,
  `costo_complessivo_attivita` double unsigned NOT NULL,
  `costo_personale` double unsigned NOT NULL,
  `pi_utente_finale` varchar(11) NOT NULL,
  `id_progetto` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pi_utente_finale_idx` (`pi_utente_finale`),
  KEY `id_progetto_idx` (`id_progetto`),
  CONSTRAINT `id_progetto` FOREIGN KEY (`id_progetto`) REFERENCES `tab_progetto` (`idprogetto`),
  CONSTRAINT `pi_utente_finale` FOREIGN KEY (`pi_utente_finale`) REFERENCES `tab_utente_finale` (`partita_iva`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_dossier`
--

LOCK TABLES `tab_dossier` WRITE;
/*!40000 ALTER TABLE `tab_dossier` DISABLE KEYS */;
INSERT INTO `tab_dossier` VALUES (12,'2',4,45,6,2,1,'12345678903',1),(13,'2134',3,3,32,21,219,'12345678903',1),(14,'678',67,78,54,567,768,'12345678903',1);
/*!40000 ALTER TABLE `tab_dossier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_progetto`
--

DROP TABLE IF EXISTS `tab_progetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_progetto` (
  `idprogetto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomeprogetto` varchar(45) NOT NULL,
  PRIMARY KEY (`idprogetto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_progetto`
--

LOCK TABLES `tab_progetto` WRITE;
/*!40000 ALTER TABLE `tab_progetto` DISABLE KEYS */;
INSERT INTO `tab_progetto` VALUES (1,'pippo'),(2,'pippo');
/*!40000 ALTER TABLE `tab_progetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_user`
--

DROP TABLE IF EXISTS `tab_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_user` (
  `userId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `usertype` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_user`
--

LOCK TABLES `tab_user` WRITE;
/*!40000 ALTER TABLE `tab_user` DISABLE KEYS */;
INSERT INTO `tab_user` VALUES (1,'admin','admin','superuser'),(2,'ciccio','ciccio','user');
/*!40000 ALTER TABLE `tab_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_utente_finale`
--

DROP TABLE IF EXISTS `tab_utente_finale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_utente_finale` (
  `denominazione_societa` varchar(100) NOT NULL,
  `forma_giuridica` varchar(45) NOT NULL,
  `sede_legale` varchar(45) NOT NULL,
  `partita_iva` varchar(11) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `e_mail` varchar(45) NOT NULL,
  `indirizzo_unita_locale` varchar(100) NOT NULL,
  `attivita_azienda` varchar(45) NOT NULL,
  `legale_rappresentante` varchar(45) NOT NULL,
  `nato_a` varchar(45) NOT NULL,
  `nato_il` varchar(45) NOT NULL,
  `id_utente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`partita_iva`),
  KEY `id_utente_idx` (`id_utente`),
  CONSTRAINT `id_utente` FOREIGN KEY (`id_utente`) REFERENCES `tab_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_utente_finale`
--

LOCK TABLES `tab_utente_finale` WRITE;
/*!40000 ALTER TABLE `tab_utente_finale` DISABLE KEYS */;
INSERT INTO `tab_utente_finale` VALUES ('rerf','tre','rtfdf','12345678903','67676767','retr','rtrtr','edsdd','trtrrf','trtr','trttr',1);
/*!40000 ALTER TABLE `tab_utente_finale` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 11:32:33

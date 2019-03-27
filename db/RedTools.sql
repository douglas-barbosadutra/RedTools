CREATE DATABASE  IF NOT EXISTS `redtools` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `redtools`;

-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: redtools
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
  `id_utente_finale` int(10) unsigned NOT NULL,
  `id_progetto` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_progetto_idx` (`id_progetto`),
  KEY `id_utente_finale_idx` (`id_utente_finale`),
  CONSTRAINT `id_progetto` FOREIGN KEY (`id_progetto`) REFERENCES `tab_progetto` (`idprogetto`),
  CONSTRAINT `id_utente_finale` FOREIGN KEY (`id_utente_finale`) REFERENCES `tab_utente_finale` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_dossier`
--

LOCK TABLES `tab_dossier` WRITE;
/*!40000 ALTER TABLE `tab_dossier` DISABLE KEYS */;
INSERT INTO `tab_dossier` VALUES (20,'2019',12364,7872,232,23452,1234,4,8);
/*!40000 ALTER TABLE `tab_dossier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_mom`
--

DROP TABLE IF EXISTS `tab_mom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_mom` (
  `id_mom` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome_utente_finale_mom` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `luogo_mom` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_del_giorno_mom` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `orario_mom` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `oggetto_mom` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `progetto_mom` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `partecipanti_mom` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `testo_agenda_mom` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `testo_azione_mom` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `testo_note_mom` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `chiave_est_ut_fin` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_mom`),
  KEY `chiave_est_ut_fin_idx` (`chiave_est_ut_fin`),
  CONSTRAINT `chiave_est_ut_fin` FOREIGN KEY (`chiave_est_ut_fin`) REFERENCES `tab_utente_finale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_mom`
--

LOCK TABLES `tab_mom` WRITE;
/*!40000 ALTER TABLE `tab_mom` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_mom` ENABLE KEYS */;
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
  `idutentefinale` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idprogetto`),
  KEY `id_utente_finale_idx` (`idutentefinale`),
  KEY `id_utente_finale1_idx` (`idutentefinale`),
  CONSTRAINT `idutentefinale` FOREIGN KEY (`idutentefinale`) REFERENCES `tab_utente_finale` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_progetto`
--

LOCK TABLES `tab_progetto` WRITE;
/*!40000 ALTER TABLE `tab_progetto` DISABLE KEYS */;
INSERT INTO `tab_progetto` VALUES (8,'Red',4);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_user`
--

LOCK TABLES `tab_user` WRITE;
/*!40000 ALTER TABLE `tab_user` DISABLE KEYS */;
INSERT INTO `tab_user` VALUES (7,'admin','admin','superuser'),(8,'ciccio','ciccio','user');
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
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id_utente_idx` (`id_utente`),
  CONSTRAINT `id_utente` FOREIGN KEY (`id_utente`) REFERENCES `tab_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_utente_finale`
--

LOCK TABLES `tab_utente_finale` WRITE;
/*!40000 ALTER TABLE `tab_utente_finale` DISABLE KEYS */;
INSERT INTO `tab_utente_finale` VALUES ('enel energia','spa','roma','01234567890','555','info@enel.it','via tal dei tali, 5','servizi','mario rossi','roma','01/01/1970',8,4);
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

-- Dump completed on 2019-03-27 10:25:22

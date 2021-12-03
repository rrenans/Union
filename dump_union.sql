-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: DBUNION
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `coordenador`
--

DROP TABLE IF EXISTS `coordenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `coordenador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenador`
--

LOCK TABLES `coordenador` WRITE;
/*!40000 ALTER TABLE `coordenador` DISABLE KEYS */;
INSERT INTO `coordenador` VALUES (1,'admin@email.com','Astolfo','$2a$10$DzGxLzp4c016C6YEyxqcQOO9.TopOLETwu7aY0YRABK1Hus2faVDm'),(2,'email@email.com','Arnaldo','$2a$10$CjypqafK7r4qIxbWjYBwbezrHLZsBVaxnbxeTMJvpeb363H9CiXD.');
/*!40000 ALTER TABLE `coordenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `foto` varchar(2000) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `coordenador_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK97f1o0j13221kopuudtor3v9p` (`coordenador_id`),
  CONSTRAINT `FK97f1o0j13221kopuudtor3v9p` FOREIGN KEY (`coordenador_id`) REFERENCES `coordenador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'12345678912','https://imgsapp2.correiobraziliense.com.br/app/noticia_127983242361/2020/07/20/873752/20200720191252323218u.jpg','Keanu Reaves',1),(3,'75315978945','https://aventurasnahistoria.uol.com.br/media/_versions/dalicapasalvadpor_widelg.jpg','Salvador Dalí',1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-03  1:15:15

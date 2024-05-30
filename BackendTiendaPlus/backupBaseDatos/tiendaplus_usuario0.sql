-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: tiendaplus
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `docidentidad` varchar(255) DEFAULT NULL,
  `apmaterno` varchar(255) DEFAULT NULL,
  `appaterno` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `avatar_id` bigint DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `UK_863n1y3x0jalatoir4325ehal` (`username`),
  UNIQUE KEY `UK_eafgkh3ukqlfc62wbonlq90gt` (`avatar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'cristian','cristhiandesing@gmail.com','$2a$10$3jTbVSgZxeI4MmUJ96d/pOJK0ammZYwgcLtgFMorB79.wVwpANnpO','961362011','43016561','Toribiore','Maldonado','Cristian Waldir',NULL),(2,'ethan','ethanmaldonado@gmail.com','$2a$10$VOMwPaeOgojzXLwAN7aSru6I9puxsThXGmLg/cDC8nA3.VVnbcKcu','954452152','77731647','Salinas','Maldonado','Tyler',NULL),(3,'candy','candysalinas@gmail.com','$2a$10$eUPo4DejLEoDALUp/p1U8OYnGDvkQU4vOAhb.Xkh7euWlX.XX6T1a','962712054','43791228','Soto','Salinas','Candy',NULL),(31,'tyler','tyler@gmail.com','$2a$10$CppLlEHCzpHk6suyUZzTAeMk8FdrNeGDaBUh3a2UIBxMmUWO2nEaW','999954411','42654215','Toribio','Maldonado','Cristian',NULL),(32,'juan','juan@gmail.com','$2a$10$jvqmlqfpvKGDaFgBWTPvo.bfb3Nzw6Yc/mfSAs9ZXCvRr3Y61lC72','985584541','42541524',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-07 18:41:27

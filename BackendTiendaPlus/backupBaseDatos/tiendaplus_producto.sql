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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `precio` double NOT NULL,
  `stock` int NOT NULL,
  `idproducto` bigint NOT NULL,
  `idusuario` bigint DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `FKgmd8s330lhvk6wke9amj284xo` (`idusuario`),
  CONSTRAINT `FKgmd8s330lhvk6wke9amj284xo` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (3399,28,19542,1,'Laptop Gamer Acer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_acer03.webp','Gamer Acer Intel Core I5 Rtx 3050 4gb 8gb 512 Gb Ssd Nitro 11° Gen 15.6\'\'\n'),(55.25,20,29988,3,'Electrica y a Gas','www.estufaagas.com','Estufa a Gas'),(2799,10,42966,1,'Laptop Gamer Asus','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_asus01.webp','Gamer Asus Intel Core I5 Rtx 3050 8gb 512gb Ssd Tuf F15 11°gen 15.6\"\n'),(2299,50,44650,1,'Laptop Gamer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_acer.webp','Laptop Acer Intel Core I5 8gb 512gb Ssd 12va Gen Aspire 5 15.6\"'),(3499,15,78346,1,'Laptop Gamer Acer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_acer02.webp','Gamer Acer Intel Core I5 Rtx3050 8gb 512gb Ssd 12va Gen Nitro 5 15.6\" + Mouse + Headset'),(150.25,75,81435,3,'Madera Pino y accesorios','www.maderapino.com','Mesa Noche'),(1899,55,90171,1,'Laptop Gamer Lenovo','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_lenovo.webp','LAPTOP LENOVO IDEAPAD 3 15ITL6 CORE I5 1135G7');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-12  4:47:54

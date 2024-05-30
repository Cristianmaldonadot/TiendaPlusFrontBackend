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
  `marca` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
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
INSERT INTO `producto` VALUES (1559,171,16473,1,'PC Gamer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/pc_gamer01.webp','Computadora Pc Intel Core i7 Monitor 19 Ram 16GB Disco 1TB+SSD 240GB CASE GAMER','Generico','Computo'),(3399,28,19542,1,'Laptop Gamer Acer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_acer03.webp','Gamer Acer Intel Core I5 Rtx 3050 4gb 8gb 512 Gb Ssd Nitro 11° Gen 15.6\'\'\n','Acer','Computo'),(169,45,20319,1,'Carpa Generica','http://imagenes-tienda.s3.us-east-2.amazonaws.com/carpa01.webp','Carpa Domepack 4 personas + Colchón inflable 2 plz','Klimber','Camping'),(69,85,20929,1,'Power Bank Cafini','http://imagenes-tienda.s3.us-east-2.amazonaws.com/power_bank01.webp','Batería Externa 52000mAH con 4 Cables Portátil Power Bank + Linterna','Cafini','Tecnologia'),(1049,87,30419,1,'TV Hyundai','http://imagenes-tienda.s3.us-east-2.amazonaws.com/televisor_hyundai.webp','Televisor Hyundai LED 55\" 4K UHD Google TV HYLED5524G4KM','Hyundai','TV'),(2999,15,31937,1,'TV 75 Samsung','http://imagenes-tienda.s3.us-east-2.amazonaws.com/televisor_samsung.webp','Televisor Samsung Smart TV 75\" Crystal UHD 4K UN75CU8000GXPE (Nuevo)','Samsung','TV'),(2849,12,32892,2,'PS5','http://imagenes-tienda.s3.us-east-2.amazonaws.com/ps5_01.webp','Consola PlayStation 5 SLIM Spider Man 2 PS5','Sony','Videojuego'),(469,75,40905,1,'Teclado Ryzer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/teclaro_ryzer.webp','TECLADO RAZER HUNTSMAN MINI OPTO MECHANICAL PURPLE SWITCH SP BLACK.','Razer','Computo'),(2799,10,42966,1,'Laptop Gamer Asus','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_asus01.webp','Gamer Asus Intel Core I5 Rtx 3050 8gb 512gb Ssd Tuf F15 11°gen 15.6\"\n','Asus','Computo'),(2299,50,44650,1,'Laptop Gamer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_acer.webp','Laptop Acer Intel Core I5 8gb 512gb Ssd 12va Gen Aspire 5 15.6\"','Acer','Computo'),(7799,45,66246,1,'Iphone','http://imagenes-tienda.s3.us-east-2.amazonaws.com/iphone01.webp','Iphone 15 Pro Max 512gb','Iphone','Computo'),(3499,15,78346,1,'Laptop Gamer Acer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_acer02.webp','Gamer Acer Intel Core I5 Rtx3050 8gb 512gb Ssd 12va Gen Nitro 5 15.6\" + Mouse + Headset','Acer','Cumputo'),(1199,48,79566,1,'TV 50 Philips','http://imagenes-tienda.s3.us-east-2.amazonaws.com/televisor_philips.webp','Televisor 50\" Android 4k Ultra Hd Smart Tv Ambilight 50pud7906','Phillips','TV'),(649,65,83011,1,'TV JVC','http://imagenes-tienda.s3.us-east-2.amazonaws.com/televisor_jvc.webp','Televisor LED 40\" JVC FHD GOOGLE TV','JVC','TV'),(209,150,87874,1,'Juego Nintendo Switch','http://imagenes-tienda.s3.us-east-2.amazonaws.com/juego_switch01.webp','Super Mario Bros Wonder Nintendo Switch','Nintendo','Videojuego'),(99,25,89371,1,'Mouse Ryzer','http://imagenes-tienda.s3.us-east-2.amazonaws.com/mouse_ryzer.webp','Mouse Razer y Almohadilla para el ratón -Negro','Razer','Computo'),(1899,55,90171,1,'Laptop Gamer Lenovo','http://imagenes-tienda.s3.us-east-2.amazonaws.com/laptop_lenovo.webp','LAPTOP LENOVO IDEAPAD 3 15ITL6 CORE I5 1135G7','Lenovo','Computo'),(1829,43,93556,1,'TV LG','http://imagenes-tienda.s3.us-east-2.amazonaws.com/televisor_lg.webp','Televisor LG 65\'\' 4K UHD 65UR7300 Smart TV WebOS 23 ?5 AI Processor 4K Gen6 con Control Magic MR23GN','LG','TV');
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

-- Dump completed on 2024-02-07 18:41:27

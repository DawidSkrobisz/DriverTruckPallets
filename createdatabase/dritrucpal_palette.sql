-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: dritrucpal
-- ------------------------------------------------------
-- Server version	8.0.34-0ubuntu0.22.04.1

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
-- Table structure for table `palette`
--

DROP TABLE IF EXISTS `palette`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `palette` (
  `palette_id` int NOT NULL AUTO_INCREMENT,
  `loaded_pallets` int DEFAULT NULL,
  `exchanged_pallets` int DEFAULT NULL,
  `returned_pallets` int DEFAULT NULL,
  `loading_date` date DEFAULT NULL,
  `loading_number` varchar(255) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `truck_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `truck_plates` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`palette_id`),
  KEY `fk_company` (`company_id`),
  KEY `fk_truck` (`truck_id`),
  CONSTRAINT `fk_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `fk_truck` FOREIGN KEY (`truck_id`) REFERENCES `truck` (`truck_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palette`
--

LOCK TABLES `palette` WRITE;
/*!40000 ALTER TABLE `palette` DISABLE KEYS */;
INSERT INTO `palette` VALUES (14,33,32,43,'2023-09-22','2',NULL,NULL,'NEW','Oskroba','Volvo FH12'),(15,25,25,20,'2023-09-21','0',NULL,NULL,'NEW','Pago','WND83762'),(16,25,25,26,'2023-10-07','1',NULL,NULL,'NEW','Hopi','WGR667W'),(17,28,28,0,'2023-09-22','1234',NULL,NULL,'NEW','HZ Transport','WND83762');
/*!40000 ALTER TABLE `palette` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-03  7:35:44

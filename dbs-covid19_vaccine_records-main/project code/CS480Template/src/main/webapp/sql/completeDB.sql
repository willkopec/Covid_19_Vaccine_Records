-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: covid19_vaccine_records
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `patient_id` int NOT NULL,
  `street_address` varchar(50) NOT NULL,
  `zip_code` int NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` char(2) NOT NULL,
  PRIMARY KEY (`patient_id`,`street_address`),
  UNIQUE KEY `patient_id` (`patient_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'2789 S Westfield St',60504,'Auroroa','IL'),(2,'5601 W Lavender Ave',60606,'Chicago','IL'),(3,'3220 W Central Ave',60564,'Naperville','IL'),(4,'4107 N Laramie',60606,'Chicago','IL'),(5,'123 N Half St',60606,'Chicago','IL');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booster`
--

DROP TABLE IF EXISTS `booster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booster` (
  `patient_id` int NOT NULL,
  `type_b` varchar(10) NOT NULL,
  `lot_num_b` varchar(10) NOT NULL,
  `dose_b_date` date NOT NULL,
  `location_b` varchar(50) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id` (`patient_id`),
  CONSTRAINT `booster_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `dose_2` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booster_chk_1` CHECK ((`type_b` in (_utf8mb4'Moderna',_utf8mb4'Pfizer',_utf8mb4'J&J')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booster`
--

LOCK TABLES `booster` WRITE;
/*!40000 ALTER TABLE `booster` DISABLE KEYS */;
INSERT INTO `booster` VALUES (1,'Moderna','FG6729','2021-09-25','CVS'),(2,'Moderna','FB1639','2021-09-22','Jewel Osco'),(3,'Pfizer','GK1562','2022-02-21','Jewel Osco'),(4,'J&J','GJ9160','2021-11-30','Walgreens'),(5,'J&J','FW3890','2021-09-12','Walgreens');
/*!40000 ALTER TABLE `booster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `patient_id` int NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `phone_num` bigint NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id` (`patient_id`),
  CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'cScot887@yahoo.com',2687481977),(2,'john_rose@gmail.com',2764892748),(3,'jcpuppy@hotmail.com',2546783901),(4,'brynbryn@yahoo.com',1319807654),(5,'sbyers@gmail.com',1234567809);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dose_1`
--

DROP TABLE IF EXISTS `dose_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dose_1` (
  `patient_id` int NOT NULL,
  `type_1` varchar(10) NOT NULL,
  `lot_num_1` varchar(10) NOT NULL,
  `dose_1_date` date NOT NULL,
  `location_1` varchar(50) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id` (`patient_id`),
  CONSTRAINT `dose_1_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE,
  CONSTRAINT `dose_1_chk_1` CHECK ((`type_1` in (_utf8mb4'Moderna',_utf8mb4'Pfizer',_utf8mb4'J&J')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dose_1`
--

LOCK TABLES `dose_1` WRITE;
/*!40000 ALTER TABLE `dose_1` DISABLE KEYS */;
INSERT INTO `dose_1` VALUES (1,'Moderna','JW2765','2021-01-01','CVS'),(2,'Moderna','FH1047','2020-12-11','CVS'),(3,'Pfizer','P6136A','2021-07-11','Walgreens'),(4,'J&J','FG8906','2021-05-15','Costco'),(5,'J&J','FG3678','2021-02-10','Costco');
/*!40000 ALTER TABLE `dose_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dose_2`
--

DROP TABLE IF EXISTS `dose_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dose_2` (
  `patient_id` int NOT NULL,
  `type_2` varchar(10) NOT NULL,
  `lot_num_2` varchar(10) NOT NULL,
  `dose_2_date` date NOT NULL,
  `location_2` varchar(50) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id` (`patient_id`),
  CONSTRAINT `dose_2_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `dose_1` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dose_2_chk_1` CHECK ((`type_2` in (_utf8mb4'Moderna',_utf8mb4'Pfizer',_utf8mb4'J&J')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dose_2`
--

LOCK TABLES `dose_2` WRITE;
/*!40000 ALTER TABLE `dose_2` DISABLE KEYS */;
INSERT INTO `dose_2` VALUES (1,'Moderna','FW8729','2021-02-05','Walgreens'),(2,'Moderna','FW8729','2021-01-08','Walgreens'),(3,'Pfizer','FJ7643','2021-08-01','Walgreens'),(4,'J&J','FG8906','2021-05-15','Costco'),(5,'J&J','FG3678','2021-02-10','Costco');
/*!40000 ALTER TABLE `dose_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_history`
--

DROP TABLE IF EXISTS `medical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_history` (
  `patient_id` int NOT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `pre_existing_conditions` varchar(200) DEFAULT NULL,
  `contracted_covid` date DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id` (`patient_id`),
  CONSTRAINT `medical_history_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_history`
--

LOCK TABLES `medical_history` WRITE;
/*!40000 ALTER TABLE `medical_history` DISABLE KEYS */;
INSERT INTO `medical_history` VALUES (1,NULL,'Diabetes, High Blood Pressure',NULL),(2,NULL,'asthma',NULL),(3,'Last hospitalization: 1/10/2022','hypertension,10/20/2021',NULL),(4,'last hospitalization: 11-02-2021, allergic to latex','asthma, diabetes','2020-08-15'),(5,NULL,NULL,NULL);
/*!40000 ALTER TABLE `medical_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `gender` char(1) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Cheryl','Scott','1998-06-08','F'),(2,'John','Rose','1990-10-12','M'),(3,'June','Carson','1995-01-22','F'),(4,'Bryn','Marks','2000-03-30','I'),(5,'Scott','Byers','2001-08-17','M');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `primary_physician`
--

DROP TABLE IF EXISTS `primary_physician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `primary_physician` (
  `patient_id` int NOT NULL,
  `p_first_name` varchar(50) NOT NULL,
  `p_last_name` varchar(50) NOT NULL,
  `p_zip` int NOT NULL,
  `p_state` char(2) NOT NULL,
  `p_city` varchar(50) NOT NULL,
  `p_phone_num` bigint NOT NULL,
  `p_street_address` varchar(50) NOT NULL,
  PRIMARY KEY (`p_phone_num`,`patient_id`),
  UNIQUE KEY `patient_id` (`patient_id`),
  CONSTRAINT `primary_physician_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `primary_physician`
--

LOCK TABLES `primary_physician` WRITE;
/*!40000 ALTER TABLE `primary_physician` DISABLE KEYS */;
INSERT INTO `primary_physician` VALUES (1,'Charles','Watkins',60504,'IL','Aurora',3039071874,'8046 E. Lancaster Street'),(5,'Derrick ','Lewis',60606,'IL','Chicago',3146272903,'3 Brook Dr.'),(2,'Cheryl','Flores',60606,'IL','Chicago',5052710015,'23 Mountainview Lane'),(3,'Crystal ','Holmes',60564,'IL','Naperville',7246699097,'39 Warren Drive '),(4,'Jeremy ','Thompson',60606,'IL','Chicago',8627814565,'569 Thompson Court Apt 7');
/*!40000 ALTER TABLE `primary_physician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('covid19_vaccine_records','UICCS480Project','mnaray5@uic.edu');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-31 18:14:12

-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: employee
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `emoloyee_file`
--

DROP TABLE IF EXISTS `emoloyee_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emoloyee_file` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT 'ファイルネーム',
  `type` varchar(255) DEFAULT NULL COMMENT 'ファイル形式',
  `size` bigint DEFAULT NULL COMMENT 'ファイルサイズ(kb)',
  `url` varchar(255) DEFAULT NULL COMMENT 'ファイルURL',
  `is_delete` tinyint DEFAULT '0' COMMENT '削除状態 0は未削除　1は削除状態',
  `enable` tinyint DEFAULT '1' COMMENT 'リンク制限 1は使用可 0は不可',
  `md5` varchar(255) DEFAULT NULL COMMENT 'md5識別',
  PRIMARY KEY (`id`),
  KEY `emoloyee_file_md5_IDX` (`md5`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emoloyee_file`
--

LOCK TABLES `emoloyee_file` WRITE;
/*!40000 ALTER TABLE `emoloyee_file` DISABLE KEYS */;
INSERT INTO `emoloyee_file` VALUES (153,'people_1.jpg','jpg',61,'http://localhost:9090/file/715712521b31429ca8f663951fb460e1.jpg',0,0,'fd34014f6961b989189f4f48a1bb54f6'),(154,'people_1.jpg','jpg',61,'http://localhost:9090/file/715712521b31429ca8f663951fb460e1.jpg',0,0,'fd34014f6961b989189f4f48a1bb54f6'),(155,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(156,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(157,'people_1.jpg','jpg',61,'http://localhost:9090/file/715712521b31429ca8f663951fb460e1.jpg',0,0,'fd34014f6961b989189f4f48a1bb54f6'),(158,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(159,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(160,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(161,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(162,'people_1.jpg','jpg',61,'http://localhost:9090/file/715712521b31429ca8f663951fb460e1.jpg',0,0,'fd34014f6961b989189f4f48a1bb54f6'),(163,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(164,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(165,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(166,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(167,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(168,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(169,'people_1.jpg','jpg',61,'http://localhost:9090/file/715712521b31429ca8f663951fb460e1.jpg',0,0,'fd34014f6961b989189f4f48a1bb54f6'),(170,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(171,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(172,'people_1.jpg','jpg',61,'http://localhost:9090/file/715712521b31429ca8f663951fb460e1.jpg',0,0,'fd34014f6961b989189f4f48a1bb54f6'),(173,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(174,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(175,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(176,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(177,'people_1.jpg','jpg',61,'http://localhost:9090/file/715712521b31429ca8f663951fb460e1.jpg',0,0,'fd34014f6961b989189f4f48a1bb54f6'),(178,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee'),(179,'sn_T-0011-thumb-720x480-10297.jpg','jpg',234,'http://localhost:9090/file/3a0a66481db444719e14b5bf933a4ca8.jpg',0,0,'ed19a4e0d83b4e59730f616aef1192dc'),(180,'houjin_freshman_main_01.jpg','jpg',260,'http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg',0,0,'646817b87c827a16076d57876e2a46ee');
/*!40000 ALTER TABLE `emoloyee_file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-28 23:13:57

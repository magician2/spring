-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: employee
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `employeedata`
--

DROP TABLE IF EXISTS `employeedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeedata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int NOT NULL,
  `gender` varchar(2) NOT NULL,
  `department` varchar(20) DEFAULT NULL,
  `date` date NOT NULL,
  `academic` varchar(30) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `hobby` varchar(20) DEFAULT NULL,
  `img_url` varchar(2083) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `katakana` varchar(20) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `del_flg` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeedata`
--

LOCK TABLES `employeedata` WRITE;
/*!40000 ALTER TABLE `employeedata` DISABLE KEYS */;
INSERT INTO `employeedata` VALUES (1,'だだ',91,'dd','dddad','2021-12-11','日本電子専門学校','piao_x@sunseer.co.jp','サッカー','3141531531531.png','33-0023-3331','福岡県',NULL,NULL,NULL,0),(2,'ss',33,'女性','SS事業部','1997-07-14','日本電子専門学校','pxiongquan@gmail.com','バスケ','999999993311.jpg','070-3830-7450','東京都新宿','ダッシュボード',NULL,NULL,0),(3,'ddd',22,'aa','gaa','2021-12-11','東京都電子専門学校','piao_x@sunseer.co.jp','ビリヤード',NULL,'33-0023-3331','埼玉県',NULL,NULL,NULL,0),(4,'dd',33,'男性','SS事業部','1997-07-14','日本電子専門学校','pxiongquan@gmail.com','バスケ','999999993311.jpg','060-3030-8830','東京都新宿','成田',NULL,NULL,0),(6,'mybatis-plus-updata-test',22,'dd','dddad','2021-12-11','埼玉車','pxiongquan@gmail.com','ビリヤード',NULL,'060-3303-7450','東京都新宿',NULL,NULL,NULL,0),(8,'管理人',43,'男性','gg','1997-07-14','福岡県福岡大学','piao_x@sunseer.co.jp','プログラム',NULL,'070-3830-7450','静岡県',NULL,'root','root',0),(9,'DAD',22,'女性','SS事業部','1997-07-14','埼玉車','piao_x@sunseer.co.jp','ビリヤード',NULL,'33-0023-3331','埼玉県',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `employeedata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-20 14:28:43

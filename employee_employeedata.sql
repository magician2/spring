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
  `imgUrl` varchar(2083) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `katakana` varchar(20) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `del_flg` int NOT NULL,
  `zipcode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeedata`
--

LOCK TABLES `employeedata` WRITE;
/*!40000 ALTER TABLE `employeedata` DISABLE KEYS */;
INSERT INTO `employeedata` VALUES (1,'佐々木　結城',23,'女性','SI事業部','1998-12-11','日本電子専門学校','sasaki_y@sunseer.co.jp','サッカー','http://localhost:9090/file/29e95e81f7ca4e81959d8716ee7f670e.jpg','07038307450','東京都新宿区2-11-3',NULL,NULL,NULL,0,'3560004'),(2,'佐藤 萌',22,'男性','SS事業部','1997-07-14','日本電子専門学校','sato_m@sunseer.co.jp','ピアノ',NULL,'07038307450','東京都新宿区1-33-1','ダッシュボード',NULL,NULL,0,'3560004'),(3,'高橋 早由',22,'女性','管理部','2001-12-11','東京都電子専門学校','taka_s@sunseer.co.jp','チェス',NULL,'07038307450','埼玉県狭山市2-33-1',NULL,NULL,NULL,0,NULL),(4,'张 益达',33,'男性','SS事業部','1997-07-14','日本電子専門学校','zhang_y@seer.co.jp','バスケ',NULL,'07038307450','埼玉県川越市2-3-11','成田',NULL,NULL,0,NULL),(6,'劉 尹盛',22,'男性','SS事業部','1995-12-11','ホンダ自動車専門学校','liu_y@sunseer.co.jp','ビリヤード',NULL,'07038307450','東京都池袋2-11-21',NULL,NULL,NULL,0,NULL),(8,'藤原 七香',31,'女性','SS事業部','1989-07-14','福岡県福岡大学','huji_w@sunseer.co.jp','プログラム',NULL,'07038307450','千葉県千葉市1-33-1',NULL,'root','root',0,NULL),(9,'DAD',22,'女性','SS事業部','1997-07-14','埼玉車','piao_x@sunseer.co.jp','ビリヤード',NULL,'07038307450','埼玉県',NULL,NULL,NULL,0,NULL),(10,'佐々木　英rな',22,'女性','SS事業部','1997-07-14','埼玉車','piao_x@sunseer.co.jp','ビリヤード',NULL,'07038307450','神奈川県',NULL,NULL,NULL,0,NULL);
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

-- Dump completed on 2023-05-28 23:13:57

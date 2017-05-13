-- MySQL dump 10.13  Distrib 5.7.12, for osx10.11 (x86_64)
--
-- Host: localhost    Database: tonlan
-- ------------------------------------------------------
-- Server version	5.7.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tl_action_info`
--

DROP TABLE IF EXISTS `tl_action_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_action_info` (
  `code` varchar(32) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` mediumtext,
  `vaild` int(11) NOT NULL DEFAULT '1',
  `var1` varchar(100) DEFAULT NULL,
  `var2` varchar(100) DEFAULT NULL,
  `var3` varchar(100) DEFAULT NULL,
  `var4` varchar(100) DEFAULT NULL,
  `var5` varchar(100) DEFAULT NULL,
  `update_time` bigint(16) DEFAULT NULL,
  `create_time` bigint(16) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_action_info`
--

LOCK TABLES `tl_action_info` WRITE;
/*!40000 ALTER TABLE `tl_action_info` DISABLE KEYS */;
INSERT INTO `tl_action_info` VALUES ('1','h',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1000000','w',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1001','hello',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('100222','name1001',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1003','hello',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,2017,NULL),('110','h',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('123','1993',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,1492421074797,NULL),('1333','name1001',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1990','1993',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,1492419699581,NULL),('19901','1993',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,1492420605500,NULL),('19902','1993',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,1492420982454,NULL),('19904','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492479739027,1492479739027,NULL),('19905','1993',NULL,1,NULL,NULL,NULL,NULL,NULL,1492479595828,1492479595828,NULL),('19909','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492480641958,1492480641958,NULL),('22','gcl',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('303','hello',NULL,1,NULL,NULL,NULL,NULL,NULL,1493187243014,1493187243014,NULL),('81','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492481765658,1492481765658,NULL),('83','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492482531335,1492482531335,NULL),('84','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492482689164,1492482689164,NULL),('85','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492484205083,1492484205083,NULL),('86','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492484890832,1492484890832,NULL),('87','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492485104605,1492485104605,NULL),('88','tooooo',NULL,1,NULL,NULL,NULL,NULL,NULL,1493193527382,1492485266516,NULL),('89','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492485628774,1492485628774,NULL),('891','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492485704879,1492485704878,NULL),('892','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492493219565,1492493219565,NULL),('893','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492493402758,1492493402758,NULL),('8934','1',NULL,0,NULL,NULL,NULL,NULL,NULL,1492493587076,1492493587076,NULL),('99','9',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tl_action_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tl_app_files`
--

DROP TABLE IF EXISTS `tl_app_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_app_files` (
  `app_version_id` int(11) NOT NULL,
  `file_id` int(11) NOT NULL,
  `var1` varchar(100) DEFAULT NULL,
  `var2` varchar(100) DEFAULT NULL,
  `var3` varchar(100) DEFAULT NULL,
  `var4` varchar(100) DEFAULT NULL,
  `var5` varchar(100) DEFAULT NULL,
  `update_time` bigint(16) DEFAULT NULL,
  `create_time` bigint(16) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`app_version_id`,`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_app_files`
--

LOCK TABLES `tl_app_files` WRITE;
/*!40000 ALTER TABLE `tl_app_files` DISABLE KEYS */;
INSERT INTO `tl_app_files` VALUES (1,1,NULL,NULL,NULL,NULL,NULL,1493193876525,NULL,NULL),(1,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tl_app_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tl_app_info`
--

DROP TABLE IF EXISTS `tl_app_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_app_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_code` varchar(32) NOT NULL,
  `app_name` varchar(100) NOT NULL,
  `latest_version` varchar(32) NOT NULL,
  `limit_version` varchar(32) NOT NULL,
  `description` mediumtext NOT NULL,
  `company_id` int(11) NOT NULL,
  `var1` varchar(100) DEFAULT NULL,
  `var2` varchar(100) DEFAULT NULL,
  `var3` varchar(100) DEFAULT NULL,
  `var4` varchar(100) DEFAULT NULL,
  `var5` varchar(100) DEFAULT NULL,
  `update_time` bigint(16) DEFAULT NULL,
  `create_time` bigint(16) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_app_info`
--

LOCK TABLES `tl_app_info` WRITE;
/*!40000 ALTER TABLE `tl_app_info` DISABLE KEYS */;
INSERT INTO `tl_app_info` VALUES (38,'312','','1.0','1.0','90',90,NULL,NULL,NULL,NULL,NULL,1493017523684,1493017523684,NULL),(39,'31','','1.0','1.0','90',90,NULL,NULL,NULL,NULL,NULL,1493019552545,20170424153913,NULL);
/*!40000 ALTER TABLE `tl_app_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tl_app_version`
--

DROP TABLE IF EXISTS `tl_app_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_app_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` int(11) NOT NULL,
  `version` varchar(200) NOT NULL,
  `update_description` mediumtext,
  `setup_script` longtext NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `var1` varchar(100) DEFAULT NULL,
  `var2` varchar(100) DEFAULT NULL,
  `var3` varchar(100) DEFAULT NULL,
  `var4` varchar(100) DEFAULT NULL,
  `var5` varchar(100) DEFAULT NULL,
  `update_time` bigint(16) DEFAULT NULL,
  `create_time` bigint(16) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`,`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_app_version`
--

LOCK TABLES `tl_app_version` WRITE;
/*!40000 ALTER TABLE `tl_app_version` DISABLE KEYS */;
INSERT INTO `tl_app_version` VALUES (13,1,'1.1',NULL,'okk',1,NULL,NULL,NULL,NULL,NULL,1492670982740,NULL,NULL),(14,1,'1.2',NULL,'o',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,2,'1.3',NULL,'1',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,11,'1.0',NULL,'ok',1,NULL,NULL,NULL,NULL,NULL,1493017349609,1493017349609,NULL);
/*!40000 ALTER TABLE `tl_app_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tl_company_info`
--

DROP TABLE IF EXISTS `tl_company_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_company_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `short_name` varchar(100) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `description` mediumtext,
  `var1` varchar(100) DEFAULT NULL,
  `var2` varchar(100) DEFAULT NULL,
  `var3` varchar(100) DEFAULT NULL,
  `var4` varchar(100) DEFAULT NULL,
  `var5` varchar(100) DEFAULT NULL,
  `update_time` bigint(16) DEFAULT NULL,
  `create_time` bigint(16) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_company_info`
--

LOCK TABLES `tl_company_info` WRITE;
/*!40000 ALTER TABLE `tl_company_info` DISABLE KEYS */;
INSERT INTO `tl_company_info` VALUES (3,'80','tooooo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1492933973292,NULL,NULL),(4,'9','t','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'81','tooooo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1493003126879,1492933847347,NULL),(11,'38','8888888',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1493016897702,1493016897702,NULL);
/*!40000 ALTER TABLE `tl_company_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tl_file_info`
--

DROP TABLE IF EXISTS `tl_file_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_file_info` (
  `id` int(11) NOT NULL,
  `app_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `url` varchar(200) NOT NULL,
  `md5` mediumtext NOT NULL,
  `size` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `gzip` int(11) NOT NULL,
  `version` varchar(100) DEFAULT NULL,
  `var1` varchar(100) DEFAULT NULL,
  `var2` varchar(100) DEFAULT NULL,
  `var3` varchar(100) DEFAULT NULL,
  `var4` varchar(100) DEFAULT NULL,
  `var5` varchar(100) DEFAULT NULL,
  `update_time` bigint(16) DEFAULT NULL,
  `create_time` bigint(16) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_file_info`
--

LOCK TABLES `tl_file_info` WRITE;
/*!40000 ALTER TABLE `tl_file_info` DISABLE KEYS */;
INSERT INTO `tl_file_info` VALUES (2,2,'soft','http:local','123',11,0,0,NULL,NULL,NULL,NULL,NULL,NULL,1493194196414,1493194196414,NULL),(4,2,'hello','http:local','123',11,0,0,NULL,NULL,NULL,NULL,NULL,NULL,1492672281645,1492672281645,NULL);
/*!40000 ALTER TABLE `tl_file_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-26 20:45:43

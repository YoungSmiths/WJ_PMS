-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: wjpms
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `alert_event`
--

DROP TABLE IF EXISTS `alert_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `confirmed` bit(1) DEFAULT NULL,
  `confirmed_time` datetime DEFAULT NULL,
  `content` longtext,
  `level` int(11) DEFAULT NULL,
  `source_uri` varchar(256) DEFAULT NULL,
  `source_uri_list` varchar(2048) DEFAULT NULL,
  `subject` longtext,
  `confirmed_by_id` bigint(20) DEFAULT NULL,
  `rule_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7m3a5awwlmnq3gw2yp4e54c2x` (`confirmed_by_id`),
  KEY `FK1sehn6mpxtshf781kyly6ecre` (`rule_id`),
  KEY `FKdojs1ldaqn2m46o7si6kr0ban` (`user_id`),
  CONSTRAINT `FK1sehn6mpxtshf781kyly6ecre` FOREIGN KEY (`rule_id`) REFERENCES `alert_rule` (`id`),
  CONSTRAINT `FK7m3a5awwlmnq3gw2yp4e54c2x` FOREIGN KEY (`confirmed_by_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKdojs1ldaqn2m46o7si6kr0ban` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert_event`
--

LOCK TABLES `alert_event` WRITE;
/*!40000 ALTER TABLE `alert_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `alert_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alert_rule`
--

DROP TABLE IF EXISTS `alert_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `compare_condition` varchar(255) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `last_period_count` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `threshold` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1ri0fg876op2e7ppa1aolcawd` (`user_id`),
  CONSTRAINT `FK1ri0fg876op2e7ppa1aolcawd` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert_rule`
--

LOCK TABLES `alert_rule` WRITE;
/*!40000 ALTER TABLE `alert_rule` DISABLE KEYS */;
INSERT INTO `alert_rule` VALUES (1,'2018-07-27 07:12:30',NULL,'2018-07-27 07:12:30','<','结点状态异常',3,3,'nodeNotAlive',1,2),(2,'2018-07-27 07:12:30',NULL,'2018-07-27 07:12:30','>','结点CPU使用率超限',3,1,'nodeCpuExceedLimit',80,2),(3,'2018-07-27 07:12:30',NULL,'2018-07-27 07:12:30','>','结点内存使用率超限',3,1,'nodeMemoryExceedLimit',80,2),(4,'2018-07-27 07:12:30',NULL,'2018-07-27 07:12:30','<','任务状态异常',3,2,'taskNotAlive',1,2),(5,'2018-07-27 07:12:30',NULL,'2018-07-27 07:12:30','<','任务版本变更',3,0,'taskVersionUnconfirmed',1,2),(6,'2018-07-27 07:12:30',NULL,'2018-07-27 07:12:30','<','模块访问不通',3,2,'moduleNotAccess',1,2);
/*!40000 ALTER TABLE `alert_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_module`
--

DROP TABLE IF EXISTS `app_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `alert_count` int(11) NOT NULL,
  `check_count` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `system_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmjbixobcovsuc1dqtrdfk9uc` (`system_id`),
  CONSTRAINT `FKmjbixobcovsuc1dqtrdfk9uc` FOREIGN KEY (`system_id`) REFERENCES `system` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_module`
--

LOCK TABLES `app_module` WRITE;
/*!40000 ALTER TABLE `app_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_module_check`
--

DROP TABLE IF EXISTS `app_module_check`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_module_check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `app_module_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeh6q4bv684o8stk9ufagn7iow` (`app_module_id`),
  CONSTRAINT `FKeh6q4bv684o8stk9ufagn7iow` FOREIGN KEY (`app_module_id`) REFERENCES `app_module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_module_check`
--

LOCK TABLES `app_module_check` WRITE;
/*!40000 ALTER TABLE `app_module_check` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_module_check` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_module_check_log`
--

DROP TABLE IF EXISTS `app_module_check_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_module_check_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  `status_code` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `app_module_check_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs2xephal78aijnnha9ff10p3g` (`app_module_check_id`),
  CONSTRAINT `FKs2xephal78aijnnha9ff10p3g` FOREIGN KEY (`app_module_check_id`) REFERENCES `app_module_check` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_module_check_log`
--

LOCK TABLES `app_module_check_log` WRITE;
/*!40000 ALTER TABLE `app_module_check_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_module_check_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_module_pattern`
--

DROP TABLE IF EXISTS `app_module_pattern`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_module_pattern` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `fk_module_id` bigint(20) DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `pattern` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `app_module_pattern_normal_fk_module_id` (`fk_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_module_pattern`
--

LOCK TABLES `app_module_pattern` WRITE;
/*!40000 ALTER TABLE `app_module_pattern` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_module_pattern` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_orders`
--

DROP TABLE IF EXISTS `base_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `card_length` float DEFAULT NULL,
  `card_width` float DEFAULT NULL,
  `contract` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `deal_out_side` varchar(255) DEFAULT NULL,
  `describe_info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `package_require` varchar(255) DEFAULT NULL,
  `paper_type` varchar(255) DEFAULT NULL,
  `parts` varchar(255) DEFAULT NULL,
  `print_require` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_orders`
--

LOCK TABLES `base_orders` WRITE;
/*!40000 ALTER TABLE `base_orders` DISABLE KEYS */;
INSERT INTO `base_orders` VALUES (1,'shiyang','2018-06-27 22:13:46',NULL,'shiyang','2018-06-27 22:13:55',11.11,9,'这是第一个合同',1100,'表面处理','描述','望京的扑克','打包要求','纸张类型','组件','打印要求');
/*!40000 ALTER TABLE `base_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `Id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `employee_code` varchar(32) DEFAULT NULL,
  `id_no` varchar(2000) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `birthday` varchar(2000) DEFAULT NULL,
  `sex` varchar(2000) DEFAULT NULL,
  `phone` varchar(2000) DEFAULT NULL,
  `qq` varchar(2000) DEFAULT NULL,
  `department_id` varchar(2000) DEFAULT NULL,
  `secret` varchar(2000) DEFAULT NULL,
  `flag` bit(1) DEFAULT NULL,
  `name_created` varchar(2000) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `name_updated` varchar(2000) DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IDU_Employee_employee_odeFD10` (`employee_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exception`
--

DROP TABLE IF EXISTS `exception`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exception` (
  `Id` int(11) NOT NULL,
  `exception_code` varchar(2000) DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `order_id` varchar(2000) DEFAULT NULL,
  `employee_id` varchar(32) DEFAULT NULL,
  `name_created` varchar(2000) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `name_updated` varchar(2000) DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exception`
--

LOCK TABLES `exception` WRITE;
/*!40000 ALTER TABLE `exception` DISABLE KEYS */;
/*!40000 ALTER TABLE `exception` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gzt_http_content`
--

DROP TABLE IF EXISTS `gzt_http_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gzt_http_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `fk_module_id` bigint(20) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `request_header` longtext,
  `request_ip` varchar(255) DEFAULT NULL,
  `request_time` datetime DEFAULT NULL,
  `request_uri` varchar(255) DEFAULT NULL,
  `response_header` longtext,
  `response_time` datetime DEFAULT NULL,
  `status_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gzt_http_content`
--

LOCK TABLES `gzt_http_content` WRITE;
/*!40000 ALTER TABLE `gzt_http_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `gzt_http_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gzt_module`
--

DROP TABLE IF EXISTS `gzt_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gzt_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `pattern` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gzt_module`
--

LOCK TABLES `gzt_module` WRITE;
/*!40000 ALTER TABLE `gzt_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `gzt_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gzt_reverse_proxy_server`
--

DROP TABLE IF EXISTS `gzt_reverse_proxy_server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gzt_reverse_proxy_server` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `from_host` varchar(255) DEFAULT NULL,
  `proxy_porter` int(11) NOT NULL,
  `runing` bit(1) DEFAULT NULL,
  `target_host` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gzt_reverse_proxy_server`
--

LOCK TABLES `gzt_reverse_proxy_server` WRITE;
/*!40000 ALTER TABLE `gzt_reverse_proxy_server` DISABLE KEYS */;
/*!40000 ALTER TABLE `gzt_reverse_proxy_server` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `status_check_rule` varchar(255) DEFAULT NULL,
  `system_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8ap6llpidw36nnb5ymu776to3` (`system_id`),
  CONSTRAINT `FK8ap6llpidw36nnb5ymu776to3` FOREIGN KEY (`system_id`) REFERENCES `system` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metric`
--

DROP TABLE IF EXISTS `metric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metric` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `endpoint` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `endpoint_index` (`endpoint`),
  KEY `name_index` (`name`),
  KEY `time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metric`
--

LOCK TABLES `metric` WRITE;
/*!40000 ALTER TABLE `metric` DISABLE KEYS */;
/*!40000 ALTER TABLE `metric` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_connection_time` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `port` int(11) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_state_router`
--

DROP TABLE IF EXISTS `order_state_router`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_state_router` (
  `Id` int(11) NOT NULL,
  `state_name` varchar(100) NOT NULL,
  `next_state_name` varchar(32) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  `name_created` varchar(2000) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `name_updated` varchar(2000) DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IDU_order_state_router_odeFD10` (`state_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_state_router`
--

LOCK TABLES `order_state_router` WRITE;
/*!40000 ALTER TABLE `order_state_router` DISABLE KEYS */;
INSERT INTO `order_state_router` VALUES (1,'待设计','正在设计',1,'system','2018-07-28 07:25:38','system','2018-07-28 07:25:51'),(2,'正在设计','未审核',1,'system','2018-07-28 07:25:40','system','2018-07-28 07:25:53');
/*!40000 ALTER TABLE `order_state_router` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `confirmed` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `version_content` longtext,
  `version_md5` varchar(255) DEFAULT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `version_md5_index` (`version_md5`),
  KEY `FKaqo1clgxik2n1p7b1p49g9wn3` (`job_id`),
  CONSTRAINT `FKaqo1clgxik2n1p7b1p49g9wn3` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_info1`
--

DROP TABLE IF EXISTS `role_info1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_info1` (
  `Id` int(11) NOT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_info1`
--

LOCK TABLES `role_info1` WRITE;
/*!40000 ALTER TABLE `role_info1` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_info1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system`
--

DROP TABLE IF EXISTS `system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `cert` longtext,
  `name` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system`
--

LOCK TABLES `system` WRITE;
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
/*!40000 ALTER TABLE `system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `db_driver` varchar(255) DEFAULT NULL,
  `db_password` varchar(255) DEFAULT NULL,
  `db_user` varchar(255) DEFAULT NULL,
  `is_db_job` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pkg_start_time` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `node_id` bigint(20) DEFAULT NULL,
  `pkg_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9hh4r25ufrrdjgqm37vgbojnj` (`job_id`),
  KEY `FK2y684cmktdqcs2n01oouwp1ho` (`node_id`),
  KEY `FKh14vh6q6vbfa0ol2fnkrcvj9v` (`pkg_id`),
  CONSTRAINT `FK2y684cmktdqcs2n01oouwp1ho` FOREIGN KEY (`node_id`) REFERENCES `node` (`id`),
  CONSTRAINT `FK9hh4r25ufrrdjgqm37vgbojnj` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FKh14vh6q6vbfa0ol2fnkrcvj9v` FOREIGN KEY (`pkg_id`) REFERENCES `package` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_version_record`
--

DROP TABLE IF EXISTS `task_version_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_version_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `pkg_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs1s3xj7w7fi3abrm6i7wyf63s` (`pkg_id`),
  KEY `FKqcgjo2eeoqpqdo7qneaux1i42` (`task_id`),
  CONSTRAINT `FKqcgjo2eeoqpqdo7qneaux1i42` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`),
  CONSTRAINT `FKs1s3xj7w7fi3abrm6i7wyf63s` FOREIGN KEY (`pkg_id`) REFERENCES `package` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_version_record`
--

LOCK TABLES `task_version_record` WRITE;
/*!40000 ALTER TABLE `task_version_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_version_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `last_modify_time` datetime DEFAULT NULL,
  `start_state` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `state_name` longtext,
  `state_start_time` datetime DEFAULT NULL,
  `ticket_id` varchar(255) DEFAULT NULL,
  `ticket_name` longtext,
  `ticket_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_log`
--

DROP TABLE IF EXISTS `ticket_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `info` longtext,
  `operation_time` datetime DEFAULT NULL,
  `session_id` varchar(255) DEFAULT NULL,
  `state_from` varchar(255) DEFAULT NULL,
  `state_from_time` datetime DEFAULT NULL,
  `state_to` varchar(255) DEFAULT NULL,
  `ticket_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `normal_ticket_id` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_log`
--

LOCK TABLES `ticket_log` WRITE;
/*!40000 ALTER TABLE `ticket_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'shiang','2018-07-27 06:48:00',NULL,'shiang','2018-07-27 06:48:10','1','shiyang','khkh','shiang','123','sfa','sfa','12314131241','2018-07-27 06:48:48'),(2,NULL,'2018-07-27 07:12:30',NULL,NULL,'2018-07-27 07:12:30',NULL,'Administrator',NULL,'admin','admin',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user1`
--

DROP TABLE IF EXISTS `user1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user1` (
  `Id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_code` varchar(50) NOT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `id_no` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `we_chat` varchar(50) DEFAULT NULL,
  `department_id` varchar(50) DEFAULT NULL,
  `secret` varchar(4000) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `state` varchar(1) NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IDU_user_odeFD10` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user1`
--

LOCK TABLES `user1` WRITE;
/*!40000 ALTER TABLE `user1` DISABLE KEYS */;
/*!40000 ALTER TABLE `user1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_access_record`
--

DROP TABLE IF EXISTS `user_access_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_access_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `comtop_session_sid` varchar(255) DEFAULT NULL,
  `dwrsession_id` varchar(255) DEFAULT NULL,
  `fk_module_id` bigint(20) DEFAULT NULL,
  `fk_module_name` varchar(255) DEFAULT NULL,
  `jsession_id` varchar(255) DEFAULT NULL,
  `jsession_id_mini` varchar(255) DEFAULT NULL,
  `request_body` longtext,
  `request_headers` longtext,
  `request_method` varchar(255) DEFAULT NULL,
  `request_query` longtext,
  `request_referer` longtext,
  `request_referer_module_id` varchar(255) DEFAULT NULL,
  `request_referer_module_name` varchar(255) DEFAULT NULL,
  `request_time` datetime DEFAULT NULL,
  `request_url` longtext,
  `response_code` varchar(255) DEFAULT NULL,
  `response_headers` longtext,
  `response_location` longtext,
  `response_time` datetime DEFAULT NULL,
  `set_comtop_session_sid` varchar(255) DEFAULT NULL,
  `set_dwrsession_id` varchar(255) DEFAULT NULL,
  `set_jsession_id` varchar(255) DEFAULT NULL,
  `set_jsession_id_mini` varchar(255) DEFAULT NULL,
  `time_diff` bigint(20) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_session_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_access_record_normal_fk_module_id` (`fk_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_access_record`
--

LOCK TABLES `user_access_record` WRITE;
/*!40000 ALTER TABLE `user_access_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_access_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_description`
--

DROP TABLE IF EXISTS `user_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_description` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_description`
--

LOCK TABLES `user_description` WRITE;
/*!40000 ALTER TABLE `user_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_operation_record`
--

DROP TABLE IF EXISTS `user_operation_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_operation_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `new_content` varchar(255) DEFAULT NULL,
  `old_content` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp4d4o5mqxrrpo186limu3rmbs` (`user_id`),
  CONSTRAINT `FKp4d4o5mqxrrpo186limu3rmbs` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_operation_record`
--

LOCK TABLES `user_operation_record` WRITE;
/*!40000 ALTER TABLE `user_operation_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_operation_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_session`
--

DROP TABLE IF EXISTS `user_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `last_activity_time` datetime DEFAULT NULL,
  `session_id` varchar(255) NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_session_id` (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_session`
--

LOCK TABLES `user_session` WRITE;
/*!40000 ALTER TABLE `user_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_session` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-31  7:03:23

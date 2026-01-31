CREATE DATABASE  IF NOT EXISTS `bcssafy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bcssafy`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bcssafy
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `ETH_INFO`
--

DROP TABLE IF EXISTS `ETH_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ETH_INFO` (
  `net_url` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `latest_bno` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ETH_INFO`
--

LOCK TABLES `ETH_INFO` WRITE;
/*!40000 ALTER TABLE `ETH_INFO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ETH_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `category` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `explanation` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '1',
  `seller` int NOT NULL,
  `registered_at` timestamp NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `items_users__fk` (`seller`),
  CONSTRAINT `items_users__fk` FOREIGN KEY (`seller`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchases` (
  `id` int NOT NULL AUTO_INCREMENT,
  `purchase_id` int NOT NULL,
  `created_at` timestamp NOT NULL,
  `seller_id` int NOT NULL,
  `buyer_id` int NOT NULL,
  `item_id` int NOT NULL,
  `state` char(1) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'I',
  `contract_address` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `purchases_purchase_id_uindex` (`purchase_id`),
  KEY `purchases_items_id_fk` (`item_id`),
  KEY `purchases_users__fk` (`buyer_id`),
  KEY `purchases_users_id_fk_2` (`seller_id`),
  CONSTRAINT `purchases_items_id_fk` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`),
  CONSTRAINT `purchases_users__fk` FOREIGN KEY (`buyer_id`) REFERENCES `users` (`id`),
  CONSTRAINT `purchases_users_id_fk` FOREIGN KEY (`seller_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hash` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `nonce` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `block_hash` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `block_number` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `transaction_index` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `from_hash` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `to_hash` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `value` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gas_price` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gas` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `input` varchar(300) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `creates` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `public_key` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `raw` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `r` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `s` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `v` int DEFAULT NULL,
  `stored_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `created_at` timestamp NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ssafy','ssafy','2022-03-21 02:40:26','ENCRYPTED_PASSWORD'),(2,'string','string','2022-03-21 02:45:17','string'),(3,'코인유저','코인유저@yahoo.com','2022-03-21 02:46:11','qwer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallets`
--

DROP TABLE IF EXISTS `wallets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `owner_id` int NOT NULL,
  `balance` decimal(25,0) DEFAULT '0',
  `pay_balance` decimal(25,0) DEFAULT '0',
  `receiving_count` int DEFAULT '0',
  `cash` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallets`
--

LOCK TABLES `wallets` WRITE;
/*!40000 ALTER TABLE `wallets` DISABLE KEYS */;
/*!40000 ALTER TABLE `wallets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-21 13:49:29

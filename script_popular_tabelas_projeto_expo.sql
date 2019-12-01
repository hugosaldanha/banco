-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projeto
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `mercadoria`
--

DROP TABLE IF EXISTS `mercadoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mercadoria` (
  `idMercadoria` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(13) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `unidade` varchar(10) NOT NULL,
  `preco` decimal(15,2) NOT NULL,
  `dataAtualizacao` date NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `codigoImagem` varchar(45) DEFAULT NULL,
  `codigoExiste` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idMercadoria`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mercadoria`
--

LOCK TABLES `mercadoria` WRITE;
/*!40000 ALTER TABLE `mercadoria` DISABLE KEYS */;
INSERT INTO `mercadoria` VALUES (1,'pamonha','Pamonha','un',45.65,'2001-01-14',1,'imagem',NULL),(2,'chocolate','chocolate','un',45.65,'2001-01-14',0,'imagem',NULL),(3,'bis','bis','un',45.65,'2018-01-14',1,'imagem',NULL),(4,'pizza','pizza','un',45.65,'2018-01-14',1,'imagem',NULL),(5,'coxinha','coxinha','un',45.65,'2018-05-06',1,'imagem',NULL),(6,'bala','bala','pc',45.65,'2001-01-14',1,'imagem',NULL),(7,'coca-cola','coca-cola','un',45.65,'2001-01-14',1,'imagem',NULL),(8,'Dolly','Dolly','un',45.65,'2001-01-14',1,'imagem',NULL),(9,'Barra','Barra','un',45.65,'2001-01-14',1,'imagem',NULL),(10,'Morango','Morango','pc',45.65,'2001-01-14',1,'imagem',NULL),(11,'Bolo','Bolo','un',45.65,'2001-01-14',1,'imagem',NULL),(12,'Pão','Pão','un',45.65,'2018-09-05',1,'imagem',NULL),(13,'Pão','Pão','un',45.65,'2018-09-05',1,'imagem',1),(14,'Torta','Torta','un',4.65,'2018-09-05',1,'imagem',0),(15,'Queijo','Queijo','un',45.65,'2018-09-05',1,'imagem',1);
/*!40000 ALTER TABLE `mercadoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `totalItens` int(11) NOT NULL,
  `totalPedido` double NOT NULL,
  `cancelado` tinyint(4) NOT NULL,
  PRIMARY KEY (`idpedido`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2019-11-15',3,2.5,1),(2,'2019-11-15',3,2.5,0),(3,'2019-11-15',3,2.5,1),(4,'2019-11-15',3,2.5,0),(5,'2019-11-15',3,2.5,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `idvenda` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `preco` double NOT NULL,
  `mercadoria_idMercadoria` int(11) NOT NULL,
  `pedido_idpedido` int(11) NOT NULL,
  PRIMARY KEY (`idvenda`,`mercadoria_idMercadoria`,`pedido_idpedido`),
  KEY `fk_venda_mercadoria_idx` (`mercadoria_idMercadoria`),
  KEY `fk_venda_pedido1_idx` (`pedido_idpedido`),
  CONSTRAINT `fk_venda_mercadoria` FOREIGN KEY (`mercadoria_idMercadoria`) REFERENCES `mercadoria` (`idMercadoria`),
  CONSTRAINT `fk_venda_pedido1` FOREIGN KEY (`pedido_idpedido`) REFERENCES `pedido` (`idpedido`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,1,45.65,5,1),(2,1,43.6,10,1),(3,1,4.65,15,1),(4,1,45.65,7,2),(5,1,45.65,8,2),(16,1,65.15,9,2),(17,1,65.15,11,3),(18,1,65.15,12,3),(19,1,65.15,13,3),(20,1,5.15,3,4),(21,1,65.15,4,4),(22,1,65.15,14,4),(23,1,5.15,8,5),(24,1,65.15,1,5),(25,1,65.15,2,5);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-01 17:53:27

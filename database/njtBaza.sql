/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.22 : Database - moje_zgrade
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`moje_zgrade` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `moje_zgrade`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `mestoid` bigint NOT NULL,
  `ptt` varchar(50) DEFAULT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mestoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `racunid` bigint NOT NULL,
  `ukupnavrednost` double DEFAULT NULL,
  `datumizdavanja` date DEFAULT NULL,
  `vlasnikid` bigint DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`racunid`),
  KEY `vlasnikid` (`vlasnikid`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`vlasnikid`) REFERENCES `vlasnik_posebnog_dela` (`vlasnikid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `sednica_skupstine` */

DROP TABLE IF EXISTS `sednica_skupstine`;

CREATE TABLE `sednica_skupstine` (
  `sednicaskupstineid` bigint NOT NULL AUTO_INCREMENT,
  `datumodrzavanja` date DEFAULT NULL,
  `brojprisutnih` int DEFAULT NULL,
  `dnevnired` varchar(200) DEFAULT NULL,
  `stambenazajednicaid` bigint DEFAULT NULL,
  PRIMARY KEY (`sednicaskupstineid`),
  KEY `stambenazajednicaid` (`stambenazajednicaid`),
  CONSTRAINT `sednica_skupstine_ibfk_1` FOREIGN KEY (`stambenazajednicaid`) REFERENCES `stambena_zajednica` (`stambenazajednicaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `sednica_vlasnik` */

DROP TABLE IF EXISTS `sednica_vlasnik`;

CREATE TABLE `sednica_vlasnik` (
  `sednicaskupstineid` bigint NOT NULL,
  `vlasnikposebnogdelaid` bigint NOT NULL,
  PRIMARY KEY (`sednicaskupstineid`,`vlasnikposebnogdelaid`),
  KEY `vlasnikposebnogdelaid` (`vlasnikposebnogdelaid`),
  CONSTRAINT `sednica_vlasnik_ibfk_2` FOREIGN KEY (`vlasnikposebnogdelaid`) REFERENCES `vlasnik_posebnog_dela` (`vlasnikid`),
  CONSTRAINT `sednica_vlasnik_ibfk_3` FOREIGN KEY (`sednicaskupstineid`) REFERENCES `sednica_skupstine` (`sednicaskupstineid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `stambena_zajednica` */

DROP TABLE IF EXISTS `stambena_zajednica`;

CREATE TABLE `stambena_zajednica` (
  `stambenazajednicaid` bigint NOT NULL,
  `mesto` bigint DEFAULT NULL,
  `ulica` varchar(50) DEFAULT NULL,
  `broj` varchar(50) DEFAULT NULL,
  `banka` varchar(50) DEFAULT NULL,
  `tekuciracun` varchar(50) DEFAULT NULL,
  `pib` varchar(50) DEFAULT NULL,
  `maticniBroj` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stambenazajednicaid`),
  KEY `mesto` (`mesto`),
  CONSTRAINT `stambena_zajednica_ibfk_1` FOREIGN KEY (`mesto`) REFERENCES `mesto` (`mestoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `stavka_racuna` */

DROP TABLE IF EXISTS `stavka_racuna`;

CREATE TABLE `stavka_racuna` (
  `rb` int NOT NULL,
  `cena` double DEFAULT NULL,
  `racunid` bigint NOT NULL,
  `uslugaid` bigint DEFAULT NULL,
  PRIMARY KEY (`rb`,`racunid`),
  KEY `racunid` (`racunid`),
  KEY `uslugaid` (`uslugaid`),
  CONSTRAINT `stavka_racuna_ibfk_1` FOREIGN KEY (`racunid`) REFERENCES `racun` (`racunid`),
  CONSTRAINT `stavka_racuna_ibfk_2` FOREIGN KEY (`uslugaid`) REFERENCES `usluga` (`uslugaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `upravnik` */

DROP TABLE IF EXISTS `upravnik`;

CREATE TABLE `upravnik` (
  `upravnikId` bigint unsigned NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `lozinka` varchar(50) NOT NULL,
  PRIMARY KEY (`upravnikId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `usluga` */

DROP TABLE IF EXISTS `usluga`;

CREATE TABLE `usluga` (
  `uslugaid` bigint NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `jedinicamere` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uslugaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `vlasnik_posebnog_dela` */

DROP TABLE IF EXISTS `vlasnik_posebnog_dela`;

CREATE TABLE `vlasnik_posebnog_dela` (
  `vlasnikid` bigint NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `brojposebnogdela` varchar(10) DEFAULT NULL,
  `velicinaposebnogdela` double DEFAULT NULL,
  `mernajedinica` varchar(50) DEFAULT NULL,
  `kontaktvlasnika` varchar(50) DEFAULT NULL,
  `stambenazajednicaid` bigint DEFAULT NULL,
  PRIMARY KEY (`vlasnikid`),
  KEY `stambenazajednicaid` (`stambenazajednicaid`),
  CONSTRAINT `vlasnik_posebnog_dela_ibfk_1` FOREIGN KEY (`stambenazajednicaid`) REFERENCES `stambena_zajednica` (`stambenazajednicaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

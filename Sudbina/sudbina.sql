/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.8-MariaDB : Database - sudbina
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sudbina` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `sudbina`;

/*Table structure for table `konobar` */

DROP TABLE IF EXISTS `konobar`;

CREATE TABLE `konobar` (
  `KonobarID` bigint(20) NOT NULL AUTO_INCREMENT,
  `KorisnickoIme` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Sifra` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `E-mail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Telefon` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Ime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`KonobarID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `konobar` */

insert  into `konobar`(`KonobarID`,`KorisnickoIme`,`Sifra`,`E-mail`,`Telefon`,`Ime`,`Prezime`) values 
(1,'pera','pera','pera.peric@gmail.com','0600022288','Pera','Perić'),
(2,'laza','laza','laza.lazic@gmail.com','0613456731','Laza','Lazić');

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `SifraProizvoda` bigint(20) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cena` decimal(10,2) DEFAULT 0.00,
  `Proizvodjac` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Velicina` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TipID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`SifraProizvoda`),
  KEY `TipID` (`TipID`),
  CONSTRAINT `proizvod_ibfk_1` FOREIGN KEY (`TipID`) REFERENCES `tip_proizvoda` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `proizvod` */

insert  into `proizvod`(`SifraProizvoda`,`Naziv`,`Cena`,`Proizvodjac`,`Velicina`,`TipID`) values 
(1,'Coca-cola',160.00,'Coca-cola','0.25',1),
(2,'Coca-cola Zero',160.00,'Coca-cola','0.25',1),
(3,'Fanta',160.00,'Coca-cola','0.25',1),
(4,'Sprite',160.00,'Coca-cola','0.25',1),
(5,'Schweppes Bitter',160.00,'Coca-cola','0.25',1),
(6,'Schweppes Tonic',160.00,'Coca-cola','0.25',1),
(7,'Ice tea',160.00,'Nectar','0.33',2),
(8,'Borovnica',145.00,'Nectar','0.25',2),
(9,'Breskva',145.00,'Nectar','0.25',2),
(10,'Jabuka',145.00,'Nectar','0.25',2),
(11,'Pomorandza',145.00,'Nectar','0.25',2),
(12,'Jagoda',145.00,'Nectar','0.25',2),
(13,'Cedevita',120.00,'Atlantic','0.33',2),
(14,'Pomorandza-cedjena',240.00,'Sudbina','0.30',3),
(15,'Limunada-cedjena',160.00,'Sudbina','0.30',3),
(16,'Cedjeni mix',250.00,'Sudbina','0.30',3),
(17,'Red bull',430.00,'Atlantic','0.25',4),
(18,'Guarana',195.00,'Knjaz Milos','0.25',4),
(19,'Rosa',145.00,'Coca-cola','0.33',5),
(20,'Rosa',200.00,'Coca-cola','0.75',5),
(21,'Aqua viva',145.00,'Knjaz Milos','0.33',5),
(22,'Aqua viva',200.00,'Knjaz Milos','0.75',5),
(23,'Knjaz Milos',150.00,'Knjaz Milos','0.33',5),
(24,'Knjaz Milos',220.00,'Knjaz Milos','0.75',5),
(25,'Espresso',110.00,'Doncafe','0.16',6),
(26,'Espresso sa mlekom',120.00,'Doncafe','0.24',6),
(27,'Domaca kafa',100.00,'Doncafe','0.24',6),
(28,'Nescafe',120.00,'Nestle','0.30',6),
(29,'Topla cokolada',150.00,'Dr oetker','0.48',6),
(30,'Caj',115.00,'Milford','0.48',6),
(37,'proba',12.00,'neko','0.33',1),
(38,'ttt',87.00,'ttt','0.33',1);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `BrojRacuna` bigint(20) NOT NULL AUTO_INCREMENT,
  `Vreme` date DEFAULT NULL,
  `KonobarID` bigint(20) DEFAULT NULL,
  `UkupnaVrednost` decimal(10,2) DEFAULT 0.00,
  `Storniran` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`BrojRacuna`),
  KEY `KonobarID` (`KonobarID`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`KonobarID`) REFERENCES `konobar` (`KonobarID`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `racun` */

insert  into `racun`(`BrojRacuna`,`Vreme`,`KonobarID`,`UkupnaVrednost`,`Storniran`) values 
(70,'2020-03-14',1,2720.00,0);

/*Table structure for table `racun_za_sto` */

DROP TABLE IF EXISTS `racun_za_sto`;

CREATE TABLE `racun_za_sto` (
  `SifraStola` bigint(20) NOT NULL,
  `BrojRacuna` bigint(20) NOT NULL,
  PRIMARY KEY (`SifraStola`,`BrojRacuna`),
  KEY `racun_za_sto_ibfk_2` (`BrojRacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `racun_za_sto` */

insert  into `racun_za_sto`(`SifraStola`,`BrojRacuna`) values 
(4,70);

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `SifraRezervacije` bigint(20) NOT NULL AUTO_INCREMENT,
  `NaIme` varchar(100) COLLATE utf8_unicode_ci DEFAULT 'z',
  `BrojMesta` int(10) DEFAULT NULL,
  `Vreme` date DEFAULT '2000-01-01',
  `Napomena` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SifraRezervacije`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`SifraRezervacije`,`NaIme`,`BrojMesta`,`Vreme`,`Napomena`) values 
(7,'Vanja',5,'2020-03-15','Proslava'),
(8,'Minja',8,'2020-05-17','');

/*Table structure for table `rezervacija_za_sto` */

DROP TABLE IF EXISTS `rezervacija_za_sto`;

CREATE TABLE `rezervacija_za_sto` (
  `SifraRezervacije` bigint(20) NOT NULL,
  `SifraStola` bigint(20) NOT NULL,
  `Vreme` date DEFAULT NULL,
  PRIMARY KEY (`SifraRezervacije`,`SifraStola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rezervacija_za_sto` */

insert  into `rezervacija_za_sto`(`SifraRezervacije`,`SifraStola`,`Vreme`) values 
(7,6,'2020-03-15'),
(7,7,'2020-03-15'),
(8,2,'2020-05-17'),
(8,3,'2020-05-17'),
(8,5,'2020-05-17');

/*Table structure for table `stavka_racuna` */

DROP TABLE IF EXISTS `stavka_racuna`;

CREATE TABLE `stavka_racuna` (
  `BrojRacuna` bigint(20) NOT NULL,
  `RBStavke` int(20) NOT NULL AUTO_INCREMENT,
  `Kolicina` int(10) DEFAULT 0,
  `Vrednost` decimal(10,2) DEFAULT 0.00,
  `SifraProizvoda` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`BrojRacuna`,`RBStavke`),
  KEY `ŠifraProizvoda` (`SifraProizvoda`),
  KEY `RBStavke` (`RBStavke`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavka_racuna` */

insert  into `stavka_racuna`(`BrojRacuna`,`RBStavke`,`Kolicina`,`Vrednost`,`SifraProizvoda`) values 
(70,67,1,160.00,4),
(70,69,8,160.00,2),
(70,70,8,160.00,3);

/*Table structure for table `sto` */

DROP TABLE IF EXISTS `sto`;

CREATE TABLE `sto` (
  `SifraStola` bigint(20) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `BrojMesta` int(10) NOT NULL,
  PRIMARY KEY (`SifraStola`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sto` */

insert  into `sto`(`SifraStola`,`Naziv`,`BrojMesta`) values 
(1,'S1',4),
(2,'S2',3),
(3,'S3',5),
(4,'S4',3),
(5,'B1',4),
(6,'B2',4),
(7,'B3',5);

/*Table structure for table `tip_proizvoda` */

DROP TABLE IF EXISTS `tip_proizvoda`;

CREATE TABLE `tip_proizvoda` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tip_proizvoda` */

insert  into `tip_proizvoda`(`ID`,`Naziv`) values 
(1,'Gazirani sokovi'),
(2,'Negazirani sokovi'),
(3,'Sveze cedjeni sokovi'),
(4,'Energetska pica'),
(5,'Vode'),
(6,'Topli i hladni napitci');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

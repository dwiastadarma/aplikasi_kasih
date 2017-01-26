/*
SQLyog Enterprise - MySQL GUI v7.14 
MySQL - 5.5.5-10.1.16-MariaDB : Database - db_kasihdwiyusma
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_kasihdwiyusma` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_kasihdwiyusma`;

/*Table structure for table `tbl_barang` */

DROP TABLE IF EXISTS `tbl_barang`;

CREATE TABLE `tbl_barang` (
  `idBarang` int(11) NOT NULL AUTO_INCREMENT,
  `KodeBarang` varchar(5) DEFAULT NULL,
  `NamaBarang` varchar(35) DEFAULT NULL,
  `HargaBarang` int(11) DEFAULT NULL,
  `StokBarang` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBarang`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_barang` */

insert  into `tbl_barang`(`idBarang`,`KodeBarang`,`NamaBarang`,`HargaBarang`,`StokBarang`) values (2,'KB002','Mouse',10000,200),(3,'KB001','Keyboard',7500,3),(4,'KB003','Mouse',75000,4),(5,'KB004','Headphone',1250000,1),(6,'KB005','Mousepad',20000,1);

/*Table structure for table `tbl_transaksi` */

DROP TABLE IF EXISTS `tbl_transaksi`;

CREATE TABLE `tbl_transaksi` (
  `idTransaksi` int(11) NOT NULL AUTO_INCREMENT,
  `KodeTransaksi` varchar(5) DEFAULT NULL,
  `KodeBarang` varchar(5) DEFAULT NULL,
  `NamaPembeli` varchar(35) DEFAULT NULL,
  `NamaBarang` varchar(35) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  `JumlahBeli` int(11) DEFAULT NULL,
  `TotalHarga` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTransaksi`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_transaksi` */

insert  into `tbl_transaksi`(`idTransaksi`,`KodeTransaksi`,`KodeBarang`,`NamaPembeli`,`NamaBarang`,`Harga`,`JumlahBeli`,`TotalHarga`) values (4,'KT001','KB003','Riksan','Mouse',75000,1,75000),(5,'KT002','KB005','Dwi Astadarma','Mousepad',20000,4,80000),(6,'KT003','KB002','Fikri Ramadhan','Mouse',10000,7,70000),(7,'KT004','KB004','Wibowo','Headphone',1250000,1,1250000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;

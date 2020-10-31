-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 30, 2020 at 09:26 PM
-- Server version: 5.7.24
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zackdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tclient`
--

DROP TABLE IF EXISTS `tclient`;
CREATE TABLE IF NOT EXISTS `tclient` (
  `numClient` int(11) NOT NULL AUTO_INCREMENT,
  `nomClient` varchar(30) NOT NULL,
  `prenomClient` varchar(30) NOT NULL,
  `adresseClient` varchar(50) NOT NULL,
  `villeClient` varchar(10) NOT NULL,
  `phoneClient` varchar(15) NOT NULL,
  `mailClient` varchar(30) NOT NULL,
  `mdpClient` varchar(30) NOT NULL,
  PRIMARY KEY (`numClient`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tclient`
--

INSERT INTO `tclient` (`numClient`, `nomClient`, `prenomClient`, `adresseClient`, `villeClient`, `phoneClient`, `mailClient`, `mdpClient`) VALUES
(1, 'lakhal', 'zakaria', 'hay nahda1', 'Rabat', '0623080504', 'zakaria.lakhal@gmail.com', '123456'),
(2, 'lmarssi', 'hicham', 'hay karima', 'sale', '0614323423', 'hicham@gmail.com', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `tcredit`
--

DROP TABLE IF EXISTS `tcredit`;
CREATE TABLE IF NOT EXISTS `tcredit` (
  `numCredit` int(11) NOT NULL AUTO_INCREMENT,
  `dateCredit` varchar(50) DEFAULT NULL,
  `capitalCredit` double NOT NULL,
  `dureeCredit` int(11) NOT NULL,
  `tauxCredit` double NOT NULL,
  `annuiteCredit` double NOT NULL,
  `client` int(11) NOT NULL,
  PRIMARY KEY (`numCredit`),
  KEY `client` (`client`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tcredit`
--

INSERT INTO `tcredit` (`numCredit`, `dateCredit`, `capitalCredit`, `dureeCredit`, `tauxCredit`, `annuiteCredit`, `client`) VALUES
(36, '2020/10/30 17:04:22', 10000, 10, 12, 1053, 1),
(39, '2020/10/30 19:45:26', 100000, 95, 20, 2004, 1),
(40, '2020/10/30 19:53:48', 30000, 24, 20, 1503, 2),
(41, '2020/10/30 19:54:01', 80000, 24, 15, 3843, 2),
(31, '2020/10/30 00:05:18', 10000, 10, 10, 1044, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

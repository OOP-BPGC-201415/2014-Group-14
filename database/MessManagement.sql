-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 14, 2014 at 09:22 PM
-- Server version: 5.5.40-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `MessManagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `AlreadyEaten`
--

CREATE TABLE IF NOT EXISTS `AlreadyEaten` (
  `Id` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Complaint`
--

CREATE TABLE IF NOT EXISTS `Complaint` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `From` text NOT NULL,
  `Text` text NOT NULL,
  `Status` int(11) NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `HygieneReport`
--

CREATE TABLE IF NOT EXISTS `HygieneReports` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Date` int NOT NULL,
  `Year` int NOT NULL,
  `Report` text NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Inventory`
--

CREATE TABLE IF NOT EXISTS `Inventory` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Item` text NOT NULL,
  `Price` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Login`
--

CREATE TABLE IF NOT EXISTS `Login` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Hash` varchar(32) UNIQUE NOT NULL,
  `Id` int NOT NULL,
  `Designation` int NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Menu`
--

CREATE TABLE IF NOT EXISTS `Menu` (
  `Day` int(11) UNIQUE NOT NULL,
  `Breakfast` text NOT NULL,
  `Lunch` text NOT NULL,
  `Snacks` text NOT NULL,
  `Dinner` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into menu (day, Breakfast, Lunch, Snacks, Dinner) values (0, "", "", "", "");
insert into menu (day, Breakfast, Lunch, Snacks, Dinner) values (1, "", "", "", "");
insert into menu (day, Breakfast, Lunch, Snacks, Dinner) values (2, "", "", "", "");
insert into menu (day, Breakfast, Lunch, Snacks, Dinner) values (3, "", "", "", "");
insert into menu (day, Breakfast, Lunch, Snacks, Dinner) values (4, "", "", "", "");
insert into menu (day, Breakfast, Lunch, Snacks, Dinner) values (5, "", "", "", "");
insert into menu (day, Breakfast, Lunch, Snacks, Dinner) values (6, "", "", "", "");


-- --------------------------------------------------------

--
-- Table structure for table `NonStudentList`
--

CREATE TABLE IF NOT EXISTS `NonStudentList` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Designation` text NOT NULL,
  `Phone` text NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Problem`
--

CREATE TABLE IF NOT EXISTS `Problem` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Designation` int NOT NULL,
  `Id` int NOT NULL,
  `Text` text NOT NULL,
  `Status` int(11) NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `StudentLeave`
--

CREATE TABLE IF NOT EXISTS `StudentLeave` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Id` varchar(12) UNIQUE NOT NULL,
  `Departure` BIGINT NOT NULL,
  `Arrival` BIGINT NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `StudentList`
--

CREATE TABLE IF NOT EXISTS `StudentList` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Id` varchar(12) UNIQUE NOT NULL,
  `Mess` int(11) NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `WorkerLeave`
--

CREATE TABLE IF NOT EXISTS `WorkerLeave` (
`SR` int(11) NOT NULL AUTO_INCREMENT,
`Id` int NOT NULL,
`Departure` date NOT NULL,
`Arrival` date NOT NULL,
`Status` int(11) NOT NULL,
PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Sessions`
--

CREATE TABLE IF NOT EXISTS `Sessions` (
`SR` int(11) NOT NULL AUTO_INCREMENT,
`hash` varchar(32) UNIQUE NOT NULL,
`designation` int NOT NULL,
`id` int NOT NULL,
PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

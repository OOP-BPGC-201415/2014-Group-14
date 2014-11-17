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
  `Id_Number` text NOT NULL,
  `Eaten` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Complaint`
--

CREATE TABLE IF NOT EXISTS `Complaint` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Designation` text NOT NULL,
  `User_Id` text NOT NULL,
  `Complaint_Text` text NOT NULL,
  `Complaint_Status` int(11) NOT NULL,
  PRIMARY KEY (`Complaint_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `HygieneReport`
--

CREATE TABLE IF NOT EXISTS `HygieneReport` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Month` text NOT NULL,
  `Report` text NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Inventory`
--

CREATE TABLE IF NOT EXISTS `Inventory` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Item_` text NOT NULL,
  `Price` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Login`
--

CREATE TABLE IF NOT EXISTS `Login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Hash` text NOT NULL,
  `User_Id` int NOT NULL,
  `User_Designation` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Menu`
--

CREATE TABLE IF NOT EXISTS `Menu` (
  `Day` text NOT NULL,
  `Breakfast` text NOT NULL,
  `Lunch` text NOT NULL,
  `Snacks` text NOT NULL,
  `Dinner` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `NonStudentList`
--

CREATE TABLE IF NOT EXISTS `NonStudentList` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Id` int NOT NULL,
  `Designation` text NOT NULL,
  `Phone_Number` text NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Problem`
--

CREATE TABLE IF NOT EXISTS `Problem` (
  `Problem_Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Designation` int NOT NULL,
  `User_Id` int NOT NULL,
  `Problem_Text` text NOT NULL,
  `Problem_Status` int(11) NOT NULL,
  PRIMARY KEY (`Problem_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `StudentLeave`
--

CREATE TABLE IF NOT EXISTS `StudentLeave` (
  `Leave_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Student_Id` int NOT NULL,
  `Departure` datetime NOT NULL,
  `Arrival` datetime NOT NULL,
  PRIMARY KEY (`Leave_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `StudentList`
--

CREATE TABLE IF NOT EXISTS `StudentList` (
  `SR` int(11) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Id` text NOT NULL,
  `Mess` int(11) NOT NULL,
  PRIMARY KEY (`SR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `WorkerLeave`
--

CREATE TABLE IF NOT EXISTS `WorkerLeave` (
`Leave_Id` int(11) NOT NULL AUTO_INCREMENT,
`Worker_Id` int NOT NULL,
`Departure_Date` date NOT NULL,
`Arrival_Date` date NOT NULL,
`Leave_Status` int(11) NOT NULL,
PRIMARY KEY (`Leave_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Sessions`
--

CREATE TABLE IF NOT EXISTS `Sessions` (
`Session_Id` int(11) NOT NULL AUTO_INCREMENT,
`hash` text NOT NULL,
`designation` int NOT NULL,
`id` int NOT NULL,
PRIMARY KEY (`Session_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

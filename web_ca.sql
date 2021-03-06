-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 14, 2014 at 12:16 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `web_ca`
--
CREATE DATABASE IF NOT EXISTS `web_ca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `web_ca`;

-- --------------------------------------------------------

--
-- Table structure for table `coordinate`
--

CREATE TABLE IF NOT EXISTS `coordinate` (
  `CoordinateID` int(11) NOT NULL AUTO_INCREMENT,
  `CoordinateX` int(11) NOT NULL,
  `CoordinateY` int(11) NOT NULL,
  `CoordinateZ` int(11) NOT NULL,
  `Value` int(11) NOT NULL,
  `WorldID` int(11) NOT NULL,
  PRIMARY KEY (`CoordinateID`),
  KEY `WorldID` (`WorldID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `coordinate`
--

INSERT INTO `coordinate` (`CoordinateID`, `CoordinateX`, `CoordinateY`, `CoordinateZ`, `Value`, `WorldID`) VALUES
(1, 0, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rule`
--

CREATE TABLE IF NOT EXISTS `rule` (
  `RuleID` int(11) NOT NULL AUTO_INCREMENT,
  `RuleName` varchar(20) NOT NULL,
  `RuleDesc` varchar(300) NOT NULL,
  `Priority` int(11) NOT NULL,
  `RuleConditionID` int(11) NOT NULL,
  `RuleResultID` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`RuleID`),
  KEY `ConditionID` (`OwnerID`),
  KEY `OwnerID` (`OwnerID`),
  KEY `ConditionID_2` (`RuleConditionID`,`RuleResultID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `rule`
--

INSERT INTO `rule` (`RuleID`, `RuleName`, `RuleDesc`, `Priority`, `RuleConditionID`, `RuleResultID`, `OwnerID`) VALUES
(1, 'Progress', 'progress', 1, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rulecondition`
--

CREATE TABLE IF NOT EXISTS `rulecondition` (
  `RuleConditionID` int(11) NOT NULL AUTO_INCREMENT,
  `isNot` tinyint(1) NOT NULL,
  `Operation` varchar(10) NOT NULL,
  `Operand` varchar(2) NOT NULL,
  `CompareValue` int(11) NOT NULL,
  PRIMARY KEY (`RuleConditionID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `rulecondition`
--

INSERT INTO `rulecondition` (`RuleConditionID`, `isNot`, `Operation`, `Operand`, `CompareValue`) VALUES
(1, 0, '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ruleconditionneighbours`
--

CREATE TABLE IF NOT EXISTS `ruleconditionneighbours` (
  `RuleConditionNeighID` int(11) NOT NULL AUTO_INCREMENT,
  `Neighbours` varchar(26) NOT NULL,
  `RuleConditionID` int(11) NOT NULL,
  PRIMARY KEY (`RuleConditionNeighID`),
  KEY `RuleConditionID` (`RuleConditionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ruleresult`
--

CREATE TABLE IF NOT EXISTS `ruleresult` (
  `RuleResultID` int(11) NOT NULL AUTO_INCREMENT,
  `Operation` varchar(10) NOT NULL,
  `Operand` varchar(2) NOT NULL,
  `ResultValue` int(11) DEFAULT NULL,
  PRIMARY KEY (`RuleResultID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ruleresultneighbours`
--

CREATE TABLE IF NOT EXISTS `ruleresultneighbours` (
  `RuleResultNeighID` int(11) NOT NULL AUTO_INCREMENT,
  `Neighbours` varchar(26) NOT NULL,
  `RuleResultID` int(11) NOT NULL,
  PRIMARY KEY (`RuleResultNeighID`),
  KEY `RuleResultID` (`RuleResultID`),
  KEY `RuleResultID_2` (`RuleResultID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE IF NOT EXISTS `state` (
  `StateID` int(11) NOT NULL AUTO_INCREMENT,
  `StateName` varchar(20) NOT NULL,
  `StateDesc` varchar(300) NOT NULL,
  `StateValue` int(11) NOT NULL,
  `StateHex` varchar(7) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`StateID`),
  KEY `OwnerID` (`OwnerID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`StateID`, `StateName`, `StateDesc`, `StateValue`, `StateHex`, `OwnerID`) VALUES
(1, 'Dead', 'dead', 1, '255,255', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `UserFirstName` varchar(20) NOT NULL,
  `UserLastName` varchar(40) NOT NULL,
  `UserEmail` varchar(50) NOT NULL,
  `UserPassword` varchar(50) NOT NULL,
  `UserRole` varchar(20) NOT NULL,
  PRIMARY KEY (`UserID`),
  KEY `UserID` (`UserID`),
  KEY `UserID_2` (`UserID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `UserFirstName`, `UserLastName`, `UserEmail`, `UserPassword`, `UserRole`) VALUES
(1, 'John', 'Doe', 'john@gmial.com', '123', 'Admin'),
(2, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(3, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(4, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(5, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(6, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(7, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(8, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(9, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(10, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(11, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(12, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(13, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(14, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(15, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(16, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(17, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(18, 'hello', 'hello', 'email@e.com', 'pass', 'user'),
(19, 'Stephan..', 'Viljoen', 'email', 'pass', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `world`
--

CREATE TABLE IF NOT EXISTS `world` (
  `WorldID` int(11) NOT NULL AUTO_INCREMENT,
  `WorldName` varchar(20) NOT NULL,
  `WorldDesc` varchar(300) NOT NULL,
  `WorldDimension` int(1) NOT NULL,
  `WorldWidth` int(11) NOT NULL,
  `WorldHeight` int(11) NOT NULL,
  `WorldDepth` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`WorldID`),
  KEY `RuleID` (`OwnerID`),
  KEY `OwnerID` (`OwnerID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `world`
--

INSERT INTO `world` (`WorldID`, `WorldName`, `WorldDesc`, `WorldDimension`, `WorldWidth`, `WorldHeight`, `WorldDepth`, `OwnerID`) VALUES
(1, 'Game of live', 'live/dead', 1, 10, 10, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `worldrules`
--

CREATE TABLE IF NOT EXISTS `worldrules` (
  `WorldID` int(11) NOT NULL,
  `RuleID` int(11) NOT NULL,
  KEY `WorldID` (`WorldID`),
  KEY `RuleID` (`RuleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `coordinate`
--
ALTER TABLE `coordinate`
  ADD CONSTRAINT `coordinate_ibfk_2` FOREIGN KEY (`WorldID`) REFERENCES `world` (`WorldID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rule`
--
ALTER TABLE `rule`
  ADD CONSTRAINT `rule_ibfk_1` FOREIGN KEY (`OwnerID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ruleconditionneighbours`
--
ALTER TABLE `ruleconditionneighbours`
  ADD CONSTRAINT `ruleconditionneighbours_ibfk_1` FOREIGN KEY (`RuleConditionID`) REFERENCES `rulecondition` (`RuleConditionID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ruleresultneighbours`
--
ALTER TABLE `ruleresultneighbours`
  ADD CONSTRAINT `ruleresultneighbours_ibfk_1` FOREIGN KEY (`RuleResultID`) REFERENCES `ruleresult` (`RuleResultID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `state`
--
ALTER TABLE `state`
  ADD CONSTRAINT `state_ibfk_1` FOREIGN KEY (`OwnerID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `world`
--
ALTER TABLE `world`
  ADD CONSTRAINT `world_ibfk_1` FOREIGN KEY (`OwnerID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `worldrules`
--
ALTER TABLE `worldrules`
  ADD CONSTRAINT `worldrules_ibfk_2` FOREIGN KEY (`RuleID`) REFERENCES `rule` (`RuleID`),
  ADD CONSTRAINT `worldrules_ibfk_1` FOREIGN KEY (`WorldID`) REFERENCES `world` (`WorldID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

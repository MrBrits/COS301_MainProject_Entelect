-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 27, 2014 at 02:11 AM
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
  `StateValue` double NOT NULL,
  `WorldID` int(11) NOT NULL,
  PRIMARY KEY (`CoordinateID`),
  KEY `WorldID` (`WorldID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `rule`
--

CREATE TABLE IF NOT EXISTS `rule` (
  `RuleID` int(11) NOT NULL AUTO_INCREMENT,
  `RuleName` varchar(20) NOT NULL,
  `RuleDesc` varchar(300) NOT NULL,
  `RuleConID` int(11) NOT NULL,
  `RuleConANDID` int(11) DEFAULT NULL,
  `RuleConORID` int(11) DEFAULT NULL,
  `RuleResID` int(11) DEFAULT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`RuleID`),
  KEY `ConditionID` (`OwnerID`),
  KEY `OwnerID` (`OwnerID`),
  KEY `ConditionID_2` (`RuleConID`,`RuleResID`),
  KEY `RuleResultID` (`RuleResID`),
  KEY `RuleConID` (`RuleConID`),
  KEY `RuleConANDID` (`RuleConANDID`),
  KEY `RuleConORID` (`RuleConORID`),
  KEY `RuleResID` (`RuleResID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Dumping data for table `rule`
--

INSERT INTO `rule` (`RuleID`, `RuleName`, `RuleDesc`, `RuleConID`, `RuleConANDID`, `RuleConORID`, `RuleResID`, `OwnerID`) VALUES
(2, 'GameOfLifeRule1', 'Under Population', 2, 3, NULL, 3, 31),
(3, 'GameOfLifeRule2', 'Next Generation', 4, 5, NULL, 2, 31),
(4, 'GameOfLifeRule3', 'Over Crowding', 6, 7, NULL, 3, 31),
(5, 'GameOfLifeRule4', 'Reproduction', 8, 9, NULL, 2, 31),
(26, 'Water Flow', 'Allows Water to Flow Through the World', 8, 48, NULL, 27, 31),
(28, 'Land Corrosion', 'Allows water to corrode land', 49, 50, NULL, 27, 31),
(29, 'Water Flow Down', 'Flow Down', 51, 52, NULL, 3, 31);

-- --------------------------------------------------------

--
-- Table structure for table `rulecondition`
--

CREATE TABLE IF NOT EXISTS `rulecondition` (
  `RuleConditionID` int(11) NOT NULL AUTO_INCREMENT,
  `isNot` bit(1) NOT NULL,
  `Operation` varchar(10) NOT NULL,
  `NeighboursID` int(11) NOT NULL,
  `Operand` varchar(7) NOT NULL,
  `CompareValueOne` double NOT NULL,
  `CompareValueTwo` double DEFAULT NULL,
  PRIMARY KEY (`RuleConditionID`),
  KEY `NeighbourID` (`NeighboursID`),
  KEY `NeighbourID_2` (`NeighboursID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=55 ;

--
-- Dumping data for table `rulecondition`
--

INSERT INTO `rulecondition` (`RuleConditionID`, `isNot`, `Operation`, `NeighboursID`, `Operand`, `CompareValueOne`, `CompareValueTwo`) VALUES
(2, b'0', 'SUM', 3, '==', 1, 0),
(3, b'0', 'SUM', 4, '<', 2, 0),
(4, b'0', 'SUM', 3, '==', 1, 0),
(5, b'0', 'SUM', 4, 'BETWEEN', 2, 3),
(6, b'0', 'SUM', 3, '==', 1, 0),
(7, b'0', 'SUM', 4, '>', 3, 0),
(8, b'0', 'SUM', 3, '==', 0, 0),
(9, b'0', 'SUM', 4, '==', 3, 0),
(10, b'1', 'SUM', 5, '<', -0.1, -0.1),
(11, b'1', 'AVG', 5, '<', -0.5, -0.5),
(12, b'1', 'MAX', 5, '<', 0.5, 0.5),
(13, b'1', 'MAX', 5, '>=', -2.4, -1.4),
(14, b'1', 'MAX', 5, '==', -2.2, 2.6),
(15, b'1', 'MIN', 5, '==', -4.2, 4.5),
(16, b'1', 'MAX', 5, '==', 100, NULL),
(17, b'0', 'MIN', 5, '>=', 100, NULL),
(18, b'1', 'SUM', 5, '<', -0.5, -0.6),
(19, b'0', 'SUM', 3, 'BE', 0, 1),
(20, b'0', 'COUNT', 4, '==', 5, 4),
(21, b'1', 'SUM', 4, '<', 5, NULL),
(22, b'0', 'SUM', 3, '<', 5, NULL),
(23, b'0', 'MAX', 3, '>=', 6, NULL),
(24, b'0', 'AVG', 3, '>=', 6, NULL),
(25, b'1', 'AVG', 3, '>', 0.1, NULL),
(26, b'1', 'SUM', 3, '>', 0.3, NULL),
(27, b'1', 'SUM', 3, '<', 5, NULL),
(28, b'1', 'COUNT', 3, '>=', 8, 5),
(29, b'1', 'SUM', 3, 'BE', 4, 5),
(30, b'1', 'SUM', 3, 'BI', 2, 5),
(31, b'1', 'COUNT', 3, '<', 5, 2),
(32, b'1', 'SUM', 3, '<', 10, NULL),
(33, b'1', 'SUM', 3, 'BE', 10, 15),
(34, b'1', 'SUM', 3, 'BE', 10, 15),
(35, b'1', 'COUNT', 3, '>', 10, 10),
(36, b'1', 'COUNT', 3, '<=', 10, 10),
(37, b'1', 'COUNT', 3, '<', 10, 10),
(38, b'1', 'SUM', 3, '>=', 10, NULL),
(39, b'1', 'SUM', 3, '<', 12, NULL),
(40, b'1', 'AVG', 3, '<', 10, NULL),
(41, b'1', 'SUM', 4, '>', 10, NULL),
(42, b'1', 'SUM', 3, 'BI', 10, NULL),
(43, b'1', 'AVG', 3, 'BE', 10, 15),
(44, b'1', 'SUM', 3, 'BE', 20, NULL),
(45, b'1', 'AVG', 3, '>', 20, NULL),
(46, b'1', 'SUM', 4, '<', 10, NULL),
(47, b'1', 'SUM', 3, '>', 10, NULL),
(48, b'0', 'COUNT', 4, '>=', 2, 1),
(49, b'0', 'SUM', 3, '==', 4, NULL),
(50, b'0', 'COUNT', 4, '>=', 2, 5),
(51, b'0', 'SUM', 3, '==', 2, NULL),
(52, b'0', 'COUNT', 6, '>=', 2, 3),
(53, b'0', 'COUNT', 6, '==', 2, 0),
(54, b'1', 'AVG', 7, '>=', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ruleneighbours`
--

CREATE TABLE IF NOT EXISTS `ruleneighbours` (
  `RuleNeighboursID` int(11) NOT NULL AUTO_INCREMENT,
  `Neighbours` varchar(27) NOT NULL,
  PRIMARY KEY (`RuleNeighboursID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `ruleneighbours`
--

INSERT INTO `ruleneighbours` (`RuleNeighboursID`, `Neighbours`) VALUES
(3, '000000000000010000000000000'),
(4, '111111111111101111111111111'),
(5, '000000000000000000000000000'),
(6, '111111111000000000000000000'),
(7, '000000000000100000000000010');

-- --------------------------------------------------------

--
-- Table structure for table `ruleresult`
--

CREATE TABLE IF NOT EXISTS `ruleresult` (
  `RuleResultID` int(11) NOT NULL AUTO_INCREMENT,
  `Operation` varchar(10) DEFAULT NULL,
  `NeighboursID` int(11) DEFAULT NULL,
  `ResultValue` double DEFAULT NULL,
  PRIMARY KEY (`RuleResultID`),
  KEY `NeigboursID` (`NeighboursID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data for table `ruleresult`
--

INSERT INTO `ruleresult` (`RuleResultID`, `Operation`, `NeighboursID`, `ResultValue`) VALUES
(2, NULL, NULL, 1),
(3, NULL, NULL, 0),
(4, 'SUM', 5, -0.1),
(5, 'MIN', 5, -0.3),
(6, NULL, 5, 111),
(7, 'SUM', 5, 111),
(8, 'MIN', 5, -0.6),
(9, 'SUM', 4, NULL),
(10, 'SUM', 3, NULL),
(11, 'SUM', 3, NULL),
(12, 'MAX', 4, NULL),
(13, 'MIN', 4, NULL),
(14, 'AVG', 4, NULL),
(15, 'AVG', 4, NULL),
(16, 'SUM', 4, NULL),
(17, 'AVG', 4, NULL),
(18, 'AVG', 4, NULL),
(19, 'MIN', 3, NULL),
(20, 'SUM', 4, NULL),
(21, NULL, NULL, 10),
(22, NULL, NULL, 15),
(23, NULL, NULL, 30),
(24, NULL, NULL, 55),
(25, NULL, NULL, 65),
(26, 'AVG', 3, NULL),
(27, NULL, NULL, 2),
(28, 'SUM', 7, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE IF NOT EXISTS `state` (
  `StateID` int(11) NOT NULL AUTO_INCREMENT,
  `StateName` varchar(20) NOT NULL,
  `StateDesc` varchar(300) NOT NULL,
  `StateValue` double NOT NULL,
  `StateHex` varchar(7) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`StateID`),
  KEY `OwnerID` (`OwnerID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`StateID`, `StateName`, `StateDesc`, `StateValue`, `StateHex`, `OwnerID`) VALUES
(1, 'Live Cell', 'Live Cell in Game of Life', 1, '#000000', 31),
(4, 'Water Cell', 'Water in World', 2, '#1c1384', 31),
(5, 'Grass Cell', 'Grass in World', 4, '#10880d', 31);

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
  `Tutorials` bit(1) NOT NULL,
  PRIMARY KEY (`UserID`),
  KEY `UserID` (`UserID`),
  KEY `UserID_2` (`UserID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `UserFirstName`, `UserLastName`, `UserEmail`, `UserPassword`, `UserRole`, `Tutorials`) VALUES
(23, 'df', 'sd', 'evf', 'efv', 'b', b'0'),
(24, 'eg', 'e', 'f', 'de', 'd', b'0'),
(25, 'John', 'Doe', 'doe@gmail.com', '123', 'User', b'0'),
(26, 'John', 'Doe', 'doe@gmail.com', '123', 'User', b'0'),
(27, 'Piet', 'Pompies', 'pomp@gmail.com', '123', 'User', b'0'),
(28, 'we', 'we', 'w@gmail.com', '123', 'User', b'0'),
(29, 'Jan', 'Aman', 'jan@gmail.com', '123', 'User', b'0'),
(30, 'e', 'e', 'e@gmail.com', 'e', 'User', b'0'),
(31, 'John', 'Doe', 'jd@gmail.com', '123', 'Admin', b'0');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `world`
--

INSERT INTO `world` (`WorldID`, `WorldName`, `WorldDesc`, `WorldDimension`, `WorldWidth`, `WorldHeight`, `WorldDepth`, `OwnerID`) VALUES
(12, 'Game of Life 2D', 'Game of Life in 2D', 2, 30, 30, 1, 31),
(14, 'Game of Life 3D', 'Game of Life in 3D', 3, 10, 10, 10, 31),
(15, 'Land and Water Demo', 'Demonstrates flow of water and how it can corrode land', 2, 30, 30, 1, 31),
(16, 'Flooding in 3D', 'Flooding in 3D', 3, 10, 10, 10, 31);

-- --------------------------------------------------------

--
-- Table structure for table `worldrules`
--

CREATE TABLE IF NOT EXISTS `worldrules` (
  `WorldRulesID` int(11) NOT NULL AUTO_INCREMENT,
  `WorldID` int(11) NOT NULL,
  `RuleID` int(11) NOT NULL,
  PRIMARY KEY (`WorldRulesID`),
  KEY `WorldID` (`WorldID`),
  KEY `RuleID` (`RuleID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `worldrules`
--

INSERT INTO `worldrules` (`WorldRulesID`, `WorldID`, `RuleID`) VALUES
(1, 15, 26),
(2, 15, 26),
(3, 15, 28);

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
  ADD CONSTRAINT `rule_ibfk_1` FOREIGN KEY (`OwnerID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rule_ibfk_2` FOREIGN KEY (`RuleConID`) REFERENCES `rulecondition` (`RuleConditionID`),
  ADD CONSTRAINT `rule_ibfk_3` FOREIGN KEY (`RuleConANDID`) REFERENCES `rulecondition` (`RuleConditionID`),
  ADD CONSTRAINT `rule_ibfk_4` FOREIGN KEY (`RuleConORID`) REFERENCES `rulecondition` (`RuleConditionID`),
  ADD CONSTRAINT `rule_ibfk_5` FOREIGN KEY (`RuleResID`) REFERENCES `ruleresult` (`RuleResultID`);

--
-- Constraints for table `rulecondition`
--
ALTER TABLE `rulecondition`
  ADD CONSTRAINT `rulecondition_ibfk_1` FOREIGN KEY (`NeighboursID`) REFERENCES `ruleneighbours` (`RuleNeighboursID`);

--
-- Constraints for table `ruleresult`
--
ALTER TABLE `ruleresult`
  ADD CONSTRAINT `ruleresult_ibfk_1` FOREIGN KEY (`NeighboursID`) REFERENCES `ruleneighbours` (`RuleNeighboursID`);

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
  ADD CONSTRAINT `worldrules_ibfk_1` FOREIGN KEY (`WorldID`) REFERENCES `world` (`WorldID`),
  ADD CONSTRAINT `worldrules_ibfk_2` FOREIGN KEY (`RuleID`) REFERENCES `rule` (`RuleID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

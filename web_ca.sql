-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 03, 2014 at 10:21 AM
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
-- Table structure for table `condition`
--

CREATE TABLE IF NOT EXISTS `condition` (
  `ConditionID` int(11) NOT NULL AUTO_INCREMENT,
  `StateToBeFound` int(11) NOT NULL,
  `AmountToBeFound` int(11) NOT NULL,
  `DirectionID` int(11) NOT NULL,
  `ConditionTypeID` int(11) NOT NULL,
  `RuleID` int(11) NOT NULL,
  PRIMARY KEY (`ConditionID`),
  KEY `StateToBeFound` (`StateToBeFound`,`DirectionID`,`ConditionTypeID`),
  KEY `DirectionID` (`DirectionID`),
  KEY `ConditionTypeID` (`ConditionTypeID`),
  KEY `RuleID` (`RuleID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `conditiontype`
--

CREATE TABLE IF NOT EXISTS `conditiontype` (
  `ConditionTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `ConditionName` varchar(20) NOT NULL,
  `ConditionDesc` varchar(100) NOT NULL,
  PRIMARY KEY (`ConditionTypeID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `conditiontype`
--

INSERT INTO `conditiontype` (`ConditionTypeID`, `ConditionName`, `ConditionDesc`) VALUES
(1, 'Count', 'Used to count the amount of certain state values.');

-- --------------------------------------------------------

--
-- Table structure for table `coordinate`
--

CREATE TABLE IF NOT EXISTS `coordinate` (
  `CoordinateID` int(11) NOT NULL AUTO_INCREMENT,
  `CoordinateX` int(11) NOT NULL,
  `CoordinateY` int(11) NOT NULL,
  `CoordinateZ` int(11) NOT NULL,
  `StateID` int(11) NOT NULL,
  `WorldID` int(11) NOT NULL,
  PRIMARY KEY (`CoordinateID`),
  KEY `StateID` (`StateID`),
  KEY `WorldID` (`WorldID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table `direction`
--

CREATE TABLE IF NOT EXISTS `direction` (
  `DirectionID` int(11) NOT NULL AUTO_INCREMENT,
  `DirectionName` varchar(20) NOT NULL,
  PRIMARY KEY (`DirectionID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `direction`
--

INSERT INTO `direction` (`DirectionID`, `DirectionName`) VALUES
(4, 'Up'),
(5, 'Down');

-- --------------------------------------------------------

--
-- Table structure for table `rule`
--

CREATE TABLE IF NOT EXISTS `rule` (
  `RuleID` int(11) NOT NULL AUTO_INCREMENT,
  `RuleName` varchar(20) NOT NULL,
  `RuleDesc` varchar(100) NOT NULL,
  `Priority` int(11) NOT NULL,
  `ConditionID` int(11) NOT NULL,
  `CurrentValue` int(11) NOT NULL,
  `NextValue` int(11) NOT NULL,
  `WorldID` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`RuleID`),
  KEY `ConditionID` (`ConditionID`,`CurrentValue`,`NextValue`,`OwnerID`),
  KEY `CurrentValue` (`CurrentValue`),
  KEY `NextValue` (`NextValue`),
  KEY `OwnerID` (`OwnerID`),
  KEY `WorldID` (`WorldID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE IF NOT EXISTS `state` (
  `StateID` int(11) NOT NULL AUTO_INCREMENT,
  `StateName` varchar(20) NOT NULL,
  `StateDesc` varchar(100) NOT NULL,
  `StateValue` double NOT NULL,
  `StateRGB` varchar(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`StateID`),
  KEY `OwnerID` (`OwnerID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`StateID`, `StateName`, `StateDesc`, `StateValue`, `StateRGB`, `OwnerID`) VALUES
(2, 'Rock', 'A naturally occurring solid aggregate of minerals or mineraloids.', 1.5, '102,51,0', 5),
(3, 'Air', 'Mainly composed of nitrogen, oxygen and argon.', 0.1, '204,204,255', 5);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `UserFirstName`, `UserLastName`, `UserEmail`, `UserPassword`, `UserRole`) VALUES
(5, 'John', 'Doe', 'john@gmail.com', '12345', ''),
(6, 'John', 'Doe', 'john@gmail.com', '12345', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `world`
--

CREATE TABLE IF NOT EXISTS `world` (
  `WorldID` int(11) NOT NULL AUTO_INCREMENT,
  `WorldName` varchar(20) NOT NULL,
  `WorldDesc` varchar(100) NOT NULL,
  `WorldDimension` int(1) NOT NULL,
  `WorldWidth` int(11) NOT NULL,
  `WorldHeight` int(11) NOT NULL,
  `WorldLength` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  PRIMARY KEY (`WorldID`),
  KEY `RuleID` (`OwnerID`),
  KEY `OwnerID` (`OwnerID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `world`
--

INSERT INTO `world` (`WorldID`, `WorldName`, `WorldDesc`, `WorldDimension`, `WorldWidth`, `WorldHeight`, `WorldLength`, `OwnerID`) VALUES
(1, 'Falling Object', 'USed to test how gravity affects certain states with other states.', 2, 1, 2, 0, 5);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `condition`
--
ALTER TABLE `condition`
  ADD CONSTRAINT `condition_ibfk_4` FOREIGN KEY (`RuleID`) REFERENCES `rule` (`RuleID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `condition_ibfk_1` FOREIGN KEY (`StateToBeFound`) REFERENCES `state` (`StateID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `condition_ibfk_2` FOREIGN KEY (`DirectionID`) REFERENCES `direction` (`DirectionID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `condition_ibfk_3` FOREIGN KEY (`ConditionTypeID`) REFERENCES `conditiontype` (`ConditionTypeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `coordinate`
--
ALTER TABLE `coordinate`
  ADD CONSTRAINT `coordinate_ibfk_2` FOREIGN KEY (`WorldID`) REFERENCES `world` (`WorldID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `coordinate_ibfk_1` FOREIGN KEY (`StateID`) REFERENCES `state` (`StateID`);

--
-- Constraints for table `rule`
--
ALTER TABLE `rule`
  ADD CONSTRAINT `rule_ibfk_5` FOREIGN KEY (`WorldID`) REFERENCES `world` (`WorldID`),
  ADD CONSTRAINT `rule_ibfk_1` FOREIGN KEY (`OwnerID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rule_ibfk_3` FOREIGN KEY (`CurrentValue`) REFERENCES `state` (`StateID`),
  ADD CONSTRAINT `rule_ibfk_4` FOREIGN KEY (`NextValue`) REFERENCES `state` (`StateID`);

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

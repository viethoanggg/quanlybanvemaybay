-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2019 at 04:23 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlybanvemaybay`
--

-- --------------------------------------------------------

--
-- Table structure for table `maybay`
--

CREATE TABLE `maybay` (
  `MaMayBay` varchar(10) NOT NULL,
  `Hang` varchar(100) NOT NULL,
  `Loai` varchar(20) NOT NULL,
  `SoLuongGhe` bigint(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `maybay`
--

INSERT INTO `maybay` (`MaMayBay`, `Hang`, `Loai`, `SoLuongGhe`) VALUES
('104', 'VietJet Air', 'Tupolev 104', 20),
('114', 'VietJet Air', 'Tupolev 114', 20),
('124', 'VietJet Air', 'Tupolev 124', 20),
('144', 'VietNam Airlines', 'Tupolev 144', 20),
('204', 'VietJet Air', 'Tupolev 204', 20),
('224', 'Jetstar Pacific Airlines', 'Tupolev 224', 20),
('300', 'Jetstar Pacific Airlines', 'Airbus A300', 20),
('310', 'Jetstar Pacific Airlines', 'Airbus A310', 20),
('314', 'VietNam Airlines', 'Tupolev 314', 20),
('319', 'VietNam Airlines', 'Airbus A319', 20),
('320', 'VietNam Airlines', 'Airbus A320', 20),
('330', 'VietJet Air', 'Airbus A330', 20),
('360', 'Jetstar Pacific Airlines', 'Airbus A360', 20),
('370', 'Jetstar Pacific Airlines', 'Airbus A370', 20),
('380', 'VietJet Air', 'Airbus A380', 20),
('707', 'Jetstar Pacific Airlines', 'Boeing 707', 20),
('737', 'VietNam Airlines', 'Boeing 737', 20),
('747', 'VietNam Airlines', 'Boeing 747', 20),
('767', 'VietJet Air', 'Boeing 767', 20),
('777', 'VietNam Airlines', 'Boeing 777', 20),
('787', 'Jetstar Pacific Airlines', 'Boeing 787', 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `maybay`
--
ALTER TABLE `maybay`
  ADD PRIMARY KEY (`MaMayBay`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

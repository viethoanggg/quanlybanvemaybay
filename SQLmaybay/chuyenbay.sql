-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2019 at 06:35 AM
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
-- Table structure for table `chuyenbay`
--

CREATE TABLE `chuyenbay` (
  `MaMayBay` varchar(10) NOT NULL,
  `MaChuyenBay` varchar(10) NOT NULL,
  `MaChang` varchar(10) NOT NULL,
  `ThoiGianDi` time NOT NULL,
  `ThoiGianDen` time NOT NULL,
  `NgayDi` date NOT NULL,
  `NgayDen` date NOT NULL,
  `SoGheConTrong` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chuyenbay`
--

INSERT INTO `chuyenbay` (`MaMayBay`, `MaChuyenBay`, `MaChang`, `ThoiGianDi`, `ThoiGianDen`, `NgayDi`, `NgayDen`, `SoGheConTrong`) VALUES
('224', 'VN156', 'CB301', '04:50:00', '11:50:00', '2018-01-12', '2018-01-12', 15),
('360', 'VN160', 'CB301', '06:20:00', '03:30:00', '2017-01-17', '2017-01-18', 20),
('370', 'VN170', 'CB302', '05:00:00', '06:00:00', '2019-01-18', '2019-01-20', 20),
('380', 'VN190', 'CB302', '12:00:00', '11:30:00', '2018-01-28', '2018-01-30', 20),
('330', 'VN210', 'CB302', '15:00:00', '13:40:00', '2019-02-02', '2019-02-04', 20),
('114', 'VN225', 'CB304', '05:30:00', '08:30:00', '2017-02-08', '2017-02-08', 20),
('204', 'VN248', 'CB304', '07:30:00', '10:30:00', '2016-02-10', '2016-02-10', 20),
('314', 'VN254', 'CB106', '11:15:00', '21:15:00', '2016-01-06', '2016-01-06', 10),
('787', 'VN269', 'CB205', '16:00:00', '06:00:00', '2014-01-05', '2014-01-06', 15),
('777', 'VN280', 'CB105', '06:00:00', '08:00:00', '2015-02-03', '2015-02-03', 10),
('767', 'VN281', 'CB306', '07:00:00', '13:00:00', '2013-02-20', '2013-02-20', 20),
('300', 'VN315', 'CB206', '15:00:00', '20:00:00', '2019-05-20', '2019-05-20', 5),
('310', 'VN317', 'CB208', '14:10:00', '21:30:00', '2019-06-06', '2019-06-06', 15),
('737', 'VN320', 'CB102', '08:50:00', '10:30:00', '2019-05-30', '2019-05-30', 10),
('737', 'VN320-1', 'CB102', '06:00:00', '07:10:00', '2019-07-01', '2019-07-01', 20),
('320', 'VN338', 'CB107', '21:15:00', '18:30:00', '2019-06-17', '2019-06-18', 20),
('707', 'VN374', 'CB203', '19:30:00', '08:00:00', '2019-07-17', '2019-07-18', 5),
('747', 'VN431', 'CB101', '05:55:00', '06:55:00', '2019-03-01', '2019-03-01', 10),
('747', 'VN431-1', 'CB101', '06:25:00', '08:15:00', '2018-11-14', '2018-11-14', 20),
('747', 'VN431-2', 'CB101', '13:15:00', '15:20:00', '2012-12-30', '2012-12-30', 20),
('319', 'VN440', 'CB108', '23:05:00', '14:01:00', '2019-06-06', '2019-06-08', 20),
('144', 'VN651', 'CB109', '23:10:00', '13:25:00', '2018-10-19', '2018-10-21', 15),
('124', 'VN830', 'CB308', '08:00:00', '10:00:00', '2019-09-25', '2019-09-25', 5),
('104', 'VN840', 'CB308', '12:00:00', '03:00:00', '2019-12-02', '2019-12-02', 15);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chuyenbay`
--
ALTER TABLE `chuyenbay`
  ADD PRIMARY KEY (`MaChuyenBay`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

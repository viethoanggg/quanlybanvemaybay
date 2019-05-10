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
-- Table structure for table `sanbay`
--

CREATE TABLE `sanbay` (
  `MaSanBay` varchar(5) NOT NULL,
  `TenSanBay` varchar(20) NOT NULL,
  `ThanhPho` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanbay`
--

INSERT INTO `sanbay` (`MaSanBay`, `TenSanBay`, `ThanhPho`) VALUES
('SB01', 'TÂN SƠN NHẤT', 'TPHCM'),
('SB02', 'NỘI BÀI', 'HÀ NỘI'),
('SB05', 'LIÊN KHƯƠNG', 'ĐÀ LẠT'),
('SB08', 'ĐIỆN BIÊN PHỦ', 'ĐIỆN BIÊN '),
('SB09', 'CÁT BI', 'HẢI PHÒNG'),
('SB10', 'ĐÀ NẴNG', 'ĐÀ NẴNG'),
('SB18', 'HANEDA', 'TOKYO'),
('SB20', 'ĐÔN MƯỜNG', 'BANGKOK'),
('SB25', 'JOHN F.KENNEDY', 'NEWYORK'),
('SB28', 'INCHEON', 'SEOUL'),
('SB30', 'PHỔ ĐÔNG', 'THƯỢNG HẢI'),
('SB32', 'PHÚ QUỐC', 'PHÚ QUỐC'),
('SB35', 'HỒNG KÔNG', 'HỒNG KÔNG'),
('SB36', 'CHANGI', 'SINGAPORE'),
('SB38', 'PHNOM PENH', 'PHNOM PENH'),
('SB40', 'CAM RANH', 'NHA TRANG'),
('SB45', 'SOEKARNO HATTA', 'JAKARTA'),
('SB47', 'WATTAY', 'VIENTIANE(LÀO)'),
('SB50', 'SYDNEY', 'SYDNEY'),
('SB52', 'YANGON', 'YANGON(MYANMAR)'),
('SB56', 'VINH', 'VINH');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sanbay`
--
ALTER TABLE `sanbay`
  ADD PRIMARY KEY (`MaSanBay`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

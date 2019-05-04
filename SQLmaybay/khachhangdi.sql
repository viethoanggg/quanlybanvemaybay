-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 11, 2019 lúc 05:25 AM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `projectdatabase`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhangdi`
--

CREATE TABLE `khachhangdi` (
  `MaKH` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL COMMENT 'Khách hàng đi',
  `Visa` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhangdi`
--

INSERT INTO `khachhangdi` (`MaKH`, `Visa`) VALUES
('KHD_01', 'VISA123456'),
('KHD_02', 'VISA341234'),
('KHD_03', 'VISA201948'),
('KHD_04', 'VISA685944'),
('KHD_05', 'VISA867459'),
('KHD_06', 'VISA745645'),
('KHD_07', 'VISA856844'),
('KHD_08', 'VISA354344'),
('KHD_09', 'VISA847432'),
('KHD_10', 'VISA453222'),
('KHD_11', 'VISA123457'),
('KHD_12', 'VISA748392'),
('KHD_13', 'VISA546343'),
('KHD_14', 'VISA234234'),
('KHD_15', 'VISA098776'),
('KHD_16', 'VISA876757'),
('KHD_17', 'VISA456453'),
('KHD_18', 'VISA254345'),
('KHD_19', 'VISA126465'),
('KHD_20', 'VISA014242'),
('KHD_21', 'VISA891293'),
('KHD_22', 'VISA126465'),
('KHD_23', 'VISA126465'),
('KHD_24', 'VISA383818'),
('KHD_25', 'VISA128984');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `khachhangdi`
--
ALTER TABLE `khachhangdi`
  ADD PRIMARY KEY (`MaKH`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

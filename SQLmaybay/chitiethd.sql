-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 06, 2019 lúc 03:01 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.2.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlybanvemaybay`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MaHD` varchar(10) NOT NULL,
  `MaVe` varchar(10) NOT NULL,
  `MaHangVe` varchar(10) NOT NULL,
  `TenKH` varchar(10) DEFAULT NULL,
  `TenChang` varchar(10) DEFAULT NULL,
  `GiaVe` int(11) NOT NULL,
  `VISA` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`MaHD`, `MaVe`, `MaHangVe`, `TenKH`, `TenChang`, `GiaVe`, `VISA`) VALUES
('HD01', 'TN_01', 'BC', NULL, NULL, 1620000, NULL),
('HD01', 'NN_02', 'BC', NULL, NULL, 15400000, NULL),
('HD01', 'TN_02', 'EC', NULL, NULL, 1440000, NULL),
('HD01', 'NN_03', 'BC', NULL, NULL, 5000000, NULL),
('HD01', 'NN_06', 'EC', NULL, NULL, 3600000, NULL),
('HD02', 'TN_03', 'FC', NULL, NULL, 1620000, NULL),
('HD02', 'TN_04', 'PC', NULL, NULL, 3140000, NULL),
('HD02', 'NN_04', 'PC', NULL, NULL, 15300000, NULL),
('HD03', 'TN_05', 'EC', NULL, NULL, 1250000, NULL),
('HD03', 'NN_05', 'FC', NULL, NULL, 6100000, NULL),
('HD03', 'NN_08', 'BC', NULL, NULL, 1700000, NULL),
('HD04', 'NN_07', 'PC', NULL, NULL, 6200000, NULL),
('HD05', 'TN_06', 'FC', NULL, NULL, 1596000, NULL),
('HD05', 'TN_09', 'EC', NULL, NULL, 1912500, NULL),
('HD05', 'TN_11', 'BC', NULL, NULL, 2160000, NULL),
('HD06', 'NN_09', 'EC', NULL, NULL, 5800000, NULL),
('HD07', 'NN_10', 'BC', NULL, NULL, 1700000, NULL),
('HD08', 'NN_11', 'BC', NULL, NULL, 400000, NULL),
('HD09', 'TN_10', 'BC', NULL, NULL, 1516000, NULL),
('HD14', 'TN_08', 'FC', NULL, NULL, 1620000, NULL),
('HD15', 'NN_12', 'FC', NULL, NULL, 6100000, NULL),
('HD15', 'TN_07', 'EC', NULL, NULL, 1250000, NULL),
('HD15', 'NN_13', 'FC', NULL, NULL, 1995000, NULL),
('HD19', 'TN_12', 'FC', NULL, NULL, 997500, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

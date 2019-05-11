-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 11, 2019 lúc 05:36 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.2.17

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
-- Cấu trúc bảng cho bảng `vemaybay`
--

CREATE TABLE `vemaybay` (
  `MaVe` varchar(10) NOT NULL,
  `MaGhe` varchar(10) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `MaCB` varchar(10) NOT NULL,
  `TenHangVe` varchar(20) NOT NULL,
  `GiaVe` int(20) NOT NULL,
  `Hang` varchar(30) NOT NULL,
  `GiaTriGiam` int(11) NOT NULL,
  `Visa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `vemaybay`
--

INSERT INTO `vemaybay` (`MaVe`, `MaGhe`, `MaKH`, `MaCB`, `TenHangVe`, `GiaVe`, `Hang`, `GiaTriGiam`, `Visa`) VALUES
('NN_02', 'MGBC01', 'KHD_09', 'VN254', 'Business Class', 15400000, 'Vietnam Airlines', 0, 'VISA341234'),
('NN_03', 'MGBC01', 'KHD_11', 'VN269', 'Business Class', 5000000, 'Vietnam Airlines', 0, 'VISA201948'),
('NN_04', 'MGPC01', 'KHD_04', 'VN254', 'Premium Class', 15300000, 'Jetstar Pacific Airlines', 0, 'VISA685944'),
('NN_05', 'MGFC01', 'KHD_05', 'VN315', 'First Class', 6100000, 'Vietnam Airlines', 0, 'VISA867459'),
('NN_06', 'MGEC01', 'KHD_06', 'VN317', 'Economy Class', 3600000, 'VietJet Air', 0, 'VISA745645'),
('NN_07', 'MGPC01', 'KHD_07', 'VN651', 'Premium Class', 6200000, 'Jetstar Pacific Airlines', 0, 'VISA856844'),
('NN_08', 'MGBC01', 'KHD_08', 'VN156', 'Business Class', 1700000, 'VietJet Air', 0, 'VISA354344'),
('NN_09', 'MGEC01', 'KHD_02', 'VN315', 'Economy Class', 5800000, 'Jetstar Pacific Airlines', 0, 'VISA847432'),
('NN_11', 'MGEC04', 'KHD_11', 'VN380', 'Business Class', 400000, 'Vietnam Airlines', 0, 'VISA453222'),
('NN_12', 'MGFC01', 'KHD_18', 'VN315', 'First Class', 6100000, 'VietJet Air', 0, 'VISA123456'),
('NN_13', 'MGFC01', 'KHD_25', 'VN830', 'First Class', 1995000, 'Vietnam Airlines', 0, 'VISA254345'),
('TN_01', 'MGBC01', 'KHD_01', 'VN431', 'Business Class', 1620000, 'Vietnam Airlines', 10, ''),
('TN_02', 'MGEC01', 'KHD_02', 'VN431', 'Economy Class', 1440000, 'Vietnam Airlines', 10, ''),
('TN_03', 'MGFC01', 'KHD_03', 'VN320', 'First Class', 1620000, 'Vietnam Airlines', 20, ''),
('TN_04', 'MGPC01', 'KHD_12', 'VN280', 'Premium Class', 3140000, 'Jetstar Pacific Airlines', 20, ''),
('TN_05', 'MGEC01', 'KHD_13', 'VN374', 'Economy Class', 1250000, 'Jetstar Pacific Airlines', 50, ''),
('TN_06', 'MGFC01', 'KHD_10', 'VN830', 'First Class', 1596000, 'VietJet Air', 20, ''),
('TN_07', 'MGEC01', 'KHD_19', 'VN374', 'Economy Class', 1250000, 'Jetstar Pacific Airlines', 50, ''),
('TN_08', 'MGFC01', 'KHD_20', 'VN320', 'First Class', 1620000, 'VietJet Air', 10, ''),
('TN_09', 'MGEC01', 'KHD_21', 'VN280', 'Economy Class', 1912500, 'Vietnam Airlines', 50, ''),
('TN_10', 'MGBC01', 'KHD_22', 'VN840', 'Business Class', 1516000, 'VietJet Air', 20, ''),
('TN_11', 'MGBC01', 'KHD_23', 'VN374', 'Business Class', 2160000, 'Vietnam Airlines', 20, ''),
('TN_12', 'MGFC01', 'KHD_24', 'VN830', 'First Class', 997500, 'Jetstar Pacific Airlines', 50, '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `vemaybay`
--
ALTER TABLE `vemaybay`
  ADD PRIMARY KEY (`MaVe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

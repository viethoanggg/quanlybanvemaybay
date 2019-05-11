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
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MaHD` varchar(10) NOT NULL,
  `MaVe` varchar(10) NOT NULL,
  `MaHangVe` varchar(10) NOT NULL,
  `TenKH` varchar(100) NOT NULL,
  `TenChang` varchar(150) NOT NULL,
  `GiaVe` int(11) NOT NULL,
  `VISA` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`MaHD`, `MaVe`, `MaHangVe`, `TenKH`, `TenChang`, `GiaVe`, `VISA`) VALUES
('HD01', 'NN_02', 'BC', 'Đình Vũ', 'TPHCM->TOKYO', 15400000, 'VISA341234'),
('HD01', 'NN_03', 'BC', 'Trần Minh', 'HA NOI->HONG KONG', 5000000, 'VISA201948'),
('HD02', 'NN_04', 'PC', 'Nguyễn Nhân', 'TPHCM->TOKYO', 15300000, 'VISA685944'),
('HD03', 'NN_05', 'FC', 'Cao Anh', 'HA NOI->PHNOM PENH', 6100000, 'VISA867459'),
('HD01', 'NN_06', 'EC', 'Lê Trâm', 'NHA TRANG->JAKARTA', 3600000, 'VISA745645'),
('HD04', 'NN_07', 'PC', 'Nguyễn Trang', 'HA NOI->SEOUL', 6200000, 'VISA856844'),
('HD03', 'NN_08', 'BC', 'Nguyễn Giang', 'TPHCM->SINGAPORE', 1700000, 'VISA354344'),
('HD06', 'NN_09', 'EC', 'Hoàng Triết', 'HA NOI->PHNOM PENH', 5800000, 'VISA847432'),
('HD15', 'NN_12', 'FC', 'Trương Tài', 'HA NOI->PHNOM PENH', 6100000, 'VISA123456'),
('HD15', 'NN_13', 'FC', 'Quốc Tùng', 'TPHCM->HA NOI', 1995000, 'VISA254345'),
('HD01', 'TN_01', 'BC', 'Hoàng Minh', 'TPHCM->CA MAU', 1620000, ''),
('HD01', 'TN_02', 'EC', 'Hoàng Triết', 'TPHCM->CA MAU', 1440000, ''),
('HD02', 'TN_03', 'FC', 'Hong Thuan', 'TPHCM->DA NANG', 1620000, ''),
('HD02', 'TN_04', 'PC', 'Võ Hân', 'TPHCM->HAI PHONG', 3140000, ''),
('HD03', 'TN_05', 'EC', 'Trương Khoa', 'DA NANG->TPHCM', 1250000, ''),
('HD05', 'TN_06', 'FC', 'Cao Thái', 'TPHCM->HA NOI', 1596000, ''),
('HD15', 'TN_07', 'EC', 'Vĩnh Lộc', 'DA NANG->TPHCM', 1250000, ''),
('HD14', 'TN_08', 'FC', 'Nguyễn Anh', 'TPHCM->DA NANG', 1620000, ''),
('HD05', 'TN_09', 'EC', 'Minh Thanh', 'TPHCM->HAI PHONG', 1912500, ''),
('HD09', 'TN_10', 'BC', 'Bảo Tuấn', 'TPHCM->HA NOI', 1516000, ''),
('HD05', 'TN_11', 'BC', 'Thái Vũ', 'DA NANG->TPHCM', 2160000, ''),
('HD19', 'TN_12', 'FC', 'Mạnh Huấn', 'TPHCM->HA NOI', 997500, '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MaVe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

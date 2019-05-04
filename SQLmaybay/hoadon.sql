-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 21, 2019 lúc 04:34 PM
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
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `NgayDatVe` date NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `ThanhTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `NgayDatVe`, `SoLuong`, `ThanhTien`) VALUES
('HD01', 'KHM_01', 'NV01', '2018-12-13', 3, 18460000),
('HD02', 'KHM_02', 'NV01', '2018-02-14', 3, 20060000),
('HD03', 'KHM_03', 'NV02', '2018-08-15', 3, 9050000),
('HD04', 'KHM_04', 'NV08', '2018-07-12', 1, 6200000),
('HD05', 'KHM_05', 'NV08', '2018-02-22', 2, 3508500),
('HD06', 'KHM_06', 'NV09', '2018-05-12', 1, 5800000),
('HD07', 'KHM_07', 'NV10', '2018-04-01', 1, 1700000),
('HD08', 'KHM_08', 'NV11', '2018-08-06', 1, 400000),
('HD09', 'KHM_09', 'NV12', '2019-10-15', 1, 1516000),
('HD14', 'KHM_16', 'NV13', '2019-05-28', 1, 1620000),
('HD15', 'KHM_15', 'NV14', '2018-02-17', 3, 9345000),
('HD19', 'KHM_17', 'NV07', '2018-09-29', 1, 997500);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

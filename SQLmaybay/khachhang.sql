-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 08, 2019 lúc 05:16 PM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `projectdatabase1`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(10) NOT NULL,
  `TenKH` varchar(50) NOT NULL,
  `NgaySinh` varchar(20) NOT NULL,
  `CMND` varchar(15) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `GioiTinh` varchar(3) NOT NULL,
  `Visa` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `TenKH`, `NgaySinh`, `CMND`, `SDT`, `GioiTinh`, `Visa`) VALUES
('KHD_01', 'Hoàng Minh', '1967-03-15', '9873657297', '0165456789', 'Nam', 'VISA123456'),
('KHD_02', 'Hoàng Triết', '1993-02-14', '2847652019', '0909789123', 'Nam', 'VISA341234'),
('KHD_03', 'Hong Thuan', '1995-05-10', '4357811326', '0123356890', 'Nữ', 'VISA201948'),
('KHD_04', 'Nguyễn Nhân', '1994-06-12', '8442564625', '0987775322', 'Nam', 'VISA685944'),
('KHD_05', 'Cao Anh', '1984-12-10', '7625784233', '0122375758', 'Nữ', 'VISA867459'),
('KHD_06', 'Lê Trâm', '1978-08-09', '7258234234', '0123124344', 'Nữ', 'VISA745645'),
('KHD_07', 'Nguyễn Trang', '1984-09-13', '5877342563', '0984357345', 'Nữ', 'VISA856844'),
('KHD_08', 'Nguyễn Giang', '2000-10-23', '5667485343', '0934327223', 'Nữ', 'VISA354344'),
('KHD_09', 'Đình Vũ', '1997-11-12', '6247593444', '0128374634', 'Nam', 'VISA847432'),
('KHD_10', 'Cao Thái', '1988-11-14', '7689928475', '0434253443', 'Nam', 'VISA453222'),
('KHD_11', 'Trần Minh', '1992-07-25', '9873657297', '0165456789', 'Nam', 'VISA123456'),
('KHD_12', 'Võ Hân', '1986-07-08', '7477299903', '0248390122', 'Nữ', 'VISA748392'),
('KHD_13', 'Trương Khoa', '1991-12-13', '5335345324', '0988343472', 'Nam', 'VISA546343'),
('KHD_14', 'Lê Hạnh', '1988-04-11', '6576445635', '0988876755', 'Nữ', 'VISA234234'),
('KHD_15', 'Bùi Hiển', '1957-10-25', '5546097890', '0909678675', 'Nam', 'VISA098776'),
('KHD_16', 'Nguyễn Trân', '1998-03-04', '5674563533', '0867856967', 'Nữ', 'VISA876757'),
('KHD_17', 'Lý Ngọc ', '1984-09-14', '7897867855', '0987868575', 'Nữ', 'VISA456453'),
('KHD_18', 'Trương Tài', '1998-08-30', '3453423422', '0988546422', 'Nam', 'VISA254345'),
('KHD_19', 'Vĩnh Lộc', '1972-04-12', '4102939001', '0989786756', 'Nam', 'VISA126465'),
('KHD_20', 'Nguyễn Anh', '1986-06-21', '3453456746', '0986857543', 'Nữ', 'VISA014242'),
('KHD_21', 'Minh Thanh', '1968-12-25', '1928390123', '0989786756', 'Nữ', 'VISA891293'),
('KHD_22', 'Bảo Tuấn', '1993-05-19', '9102903909', '0989786756', 'Nam', 'VISA126465'),
('KHD_23', 'Thái Vũ', '1993-10-21', '6474564535', '0989786756', 'Nam', 'VISA126465'),
('KHD_24', 'Mạnh Huấn', '1999-03-05', '3784783871', '0989786756', 'Nam', 'VISA383818'),
('KHD_25', 'Quốc Tùng', '1999-06-13', '4819820094', '0989786756', 'Nam', 'VISA128984'),
('KHM_01', 'Lê Lai', '1965-09-20', '1234758392', '0909123456', 'Nam', ''),
('KHM_02', 'Hoàng Hiệp', '1970-06-10', '3758294727', '0909356118', 'Nam', ''),
('KHM_03', 'Quang Hải', '1980-01-23', '4738491838', '0122892010', 'Nam', ''),
('KHM_04', 'Tiến Dũng', '1989-12-27', '4792319094', '0165731289', 'Nam', ''),
('KHM_05', 'Vũ Huy', '1992-10-29', '5654649344', '0111234555', 'Nam', ''),
('KHM_06', 'Đỗ Phước', '1975-10-16', '4862554507', '0978888233', 'Nam', ''),
('KHM_07', 'Nguyễn Đức', '1988-01-21', '4642594567', '0123333456', 'Nam', ''),
('KHM_08', 'Hồ Nhung', '1996-10-04', '6672554604', '0995644332', 'Nữ', ''),
('KHM_09', 'Doãn Minh', '1986-07-11', '5859606400', '0112454323', 'Nam', ''),
('KHM_10', 'Cao Đạt', '1960-05-09', '6458476063', '0244565333', 'Nam', ''),
('KHM_11', 'Nguyễn Khánh', '1998-08-08', '5847592604', '0998566472', 'Nam', ''),
('KHM_12', 'Nguyễn Bình', '1959-06-07', '6455760993', '0355674832', 'Nam', ''),
('KHM_13', 'Nguyễn Quỳnh', '1987-11-10', '5688939282', '0933852813', 'Nữ', ''),
('KHM_14', 'Nguyễn Hữu', '1993-10-29', '6453452324', '0754563532', 'Nam', ''),
('KHM_15', 'Lê Quỳnh', '1993-04-12', '8756756708', '0122323253', 'Nữ', ''),
('KHM_16', 'Quế Hải', '1976-02-21', '6574563566', '0897815941', 'Nam', ''),
('KHM_17', 'Lương Trường', '1993-10-20', '4674563535', '0954843454', 'Nam', ''),
('KHM_18', 'Nguyễn Đăng', '1984-05-17', '5464564564', '0909978979', 'Nam', '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

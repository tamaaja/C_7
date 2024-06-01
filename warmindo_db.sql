-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2024 at 04:32 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `warmindo_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `mie_instan`
--

CREATE TABLE `mie_instan` (
  `id` int(11) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `gram` int(11) NOT NULL,
  `deskripsi` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mie_instan`
--

INSERT INTO `mie_instan` (`id`, `jenis`, `nama`, `harga`, `stok`, `gram`, `deskripsi`) VALUES
(2, 'kuah', 'e', 1, 5, 12, 'wefewr'),
(3, 'kuah', 'r', 1212, 88, 21, 'wdfw'),
(7, 'kuah', 'Soto', 15000, 0, 1, 'Pedas');

-- --------------------------------------------------------

--
-- Table structure for table `minuman`
--

CREATE TABLE `minuman` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `deskripsi` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `minuman`
--

INSERT INTO `minuman` (`id`, `nama`, `harga`, `stok`, `deskripsi`) VALUES
(2, 'qwqwq', 121212, 1188, 'wedew'),
(3, 'wwww', 121312, 0, 'wedwqed'),
(6, 'ooo', 1213, 200, 'eferf'),
(8, 'ddd', 213132, 3121, 'ferferer'),
(10, 'user', 1232324, 10, 'wedwef'),
(11, 'sasaa', 12121, 121212, 'wefwref'),
(14, 'aaaaaa', 1111111, 110, 'wedewfwe'),
(15, 'tttttt', 123123, 1231231, 'weferf'),
(17, 'rizky', 12, 10, 'weewf'),
(21, 'Es Jeruk', 8000, 0, 'Gula Dikit');

-- --------------------------------------------------------

--
-- Table structure for table `strukbelanja`
--

CREATE TABLE `strukbelanja` (
  `id` int(11) NOT NULL,
  `item` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `pembayaran` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL,
  `tanggal` date DEFAULT curdate(),
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `strukbelanja`
--

INSERT INTO `strukbelanja` (`id`, `item`, `harga`, `jumlah`, `pembayaran`, `kembalian`, `tanggal`, `username`) VALUES
(63, '1x mie spesial - Rp212121', 212121, 1, 999999, 787878, '2024-05-31', '11'),
(65, '1x mie spesial - Rp212121', 212121, 1, 999999, 787878, '2024-05-31', '11'),
(71, '1x w - Rp2', 2, 1, 99999, 99997, '2024-05-31', '11'),
(74, '1x w - Rp2, 2x tama - Rp4444', 4446, 1, 999999, 995553, '2024-05-31', '11'),
(75, '1x w - Rp23', 23, 1, 9999, 9976, '2024-05-31', '11'),
(76, '1x w - Rp23', 23, 1, 88, 65, '2024-05-31', '11'),
(77, '1x w - Rp23', 23, 1, 99, 76, '2024-05-31', '11'),
(78, '1x w - Rp23', 23, 1, 9999, 9976, '2024-05-31', '11'),
(79, '21x r - Rp25452, 2x rizky - Rp24, 2x bakri - Rp24', 25500, 21, 999999, 974499, '2024-05-31', '11'),
(80, '2x e - Rp2, 10x wwww - Rp1213120', 1213122, 2, 99999999, 98786877, '2024-05-31', '123'),
(81, '10x r - Rp12120, 10x user - Rp12323240', 12335360, 10, 999999999, 987664639, '2024-05-31', '45'),
(82, '1x e - Rp1, 12x qwqwq - Rp1454544', 1454545, 1, 999999999, 998545454, '2024-05-31', '11'),
(83, '1x r - Rp1212, 1x bakri - Rp12', 1224, 1, 999999, 998775, '2024-05-31', '11'),
(84, '1x e - Rp1, 20x bakri - Rp240', 241, 1, 999999, 999758, '2024-06-01', '11'),
(85, '1x r - Rp1212, 1x rizky - Rp12', 1224, 1, 9999, 8775, '2024-06-01', '11'),
(86, '3x e - Rp3, 11x namaalip - Rp242', 245, 3, 999, 754, '2024-06-01', '11'),
(87, '2x suryaanjing - Rp22000', 22000, 2, 99999, 77999, '2024-06-01', '11'),
(88, '5x suryaanjing - Rp55000, 5x rizky - Rp60, 5x rizky - Rp60, 12x qwqwq - Rp1454544', 1509664, 5, 9999999, 8490335, '2024-06-01', '123'),
(89, '3x well - Rp3636, 10x jus melon - Rp123130', 126766, 4, 130000, 3234, '2024-06-01', 'alif'),
(90, '3x Soto - Rp45000, 4x Es Jeruk - Rp32000', 77000, 4, 100000, 23000, '2024-06-01', 'alif');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`) VALUES
(1, '123', '123'),
(2, '1234', '1234'),
(3, '11', '11'),
(4, '45', '45'),
(5, '0', '0'),
(6, '0', '0'),
(7, '2', '2'),
(8, 'aa', 'aa'),
(9, '11', '11'),
(10, 'alif', '123'),
(11, 'ucup', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mie_instan`
--
ALTER TABLE `mie_instan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `minuman`
--
ALTER TABLE `minuman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `strukbelanja`
--
ALTER TABLE `strukbelanja`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mie_instan`
--
ALTER TABLE `mie_instan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `minuman`
--
ALTER TABLE `minuman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `strukbelanja`
--
ALTER TABLE `strukbelanja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

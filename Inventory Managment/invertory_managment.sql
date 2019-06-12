-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2019 at 08:39 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `invertory_managment`
--

-- --------------------------------------------------------

--
-- Table structure for table `car_parts`
--

CREATE TABLE `car_parts` (
  `id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `quantity` int(10) NOT NULL,
  `date_in` date NOT NULL,
  `price` double NOT NULL,
  `type` varchar(50) NOT NULL,
  `manufacturer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car_parts`
--

INSERT INTO `car_parts` (`id`, `name`, `quantity`, `date_in`, `price`, `type`, `manufacturer`) VALUES
('08cp/29231', 'Tyre', 43, '2019-05-08', 450, 'EXHAUSTIVE', 'Yokohame'),
('08cp/43016', 'Carborator', 40, '2019-05-08', 600, 'FIXED', 'mercedes'),
('08cp/76529', 'Radiator fluid', 20, '2019-05-08', 300, 'EXHAUSTIVE', 'Ford'),
('18cp/89124', 'Brake fluid', 15, '2019-05-18', 350.5, 'EXHAUSTIVE', 'Toyota'),
('22cp/39530', 'Rear mirror', 15, '2019-04-22', 700, 'EXHAUSTIVE', 'mercedes'),
('22cp/83541', 'Oil', 1000, '2019-05-22', 20, 'FIXED', 'Shell'),
('23cp/08487', 'Tires', 500, '2019-05-23', 600, 'FIXED', 'Moenco'),
('25cp/04462', 'Spokio', 3, '2019-05-25', 450, 'FIXED', 'Toyota'),
('25cp/08635', 'Candella', 30, '2019-05-25', 500, 'FIXED', 'AASTU'),
('29cp/01470', 'Hand-Brake', 780, '2019-05-29', 2600, 'FIXED', 'Yididya Plc'),
('29cp/52089', 'Rear-View Mirror', 100, '2019-05-29', 800, 'FIXED', 'Olyad plc'),
('29cp/56388', 'Sterring Wheel', 23, '2019-05-29', 6301, 'FIXED', 'Lamborghini'),
('29cp/58081', 'Spokio', 65, '2019-05-29', 1200, 'FIXED', 'Hyundai'),
('29cp/60204', 'Engine', 1462, '2019-05-29', 465394.75, 'FIXED', 'Ethio plc'),
('29cp/79087', 'Exhaustion', 890, '2019-05-29', 1600, 'FIXED', 'Lexus'),
('29cp/80541', 'Seat', 521, '2019-05-29', 1200, 'FIXED', 'Yoseph plc');

-- --------------------------------------------------------

--
-- Table structure for table `denied_parts`
--

CREATE TABLE `denied_parts` (
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `denied_parts`
--

INSERT INTO `denied_parts` (`name`) VALUES
('2019-04-19cp100');

-- --------------------------------------------------------

--
-- Table structure for table `denied_users`
--

CREATE TABLE `denied_users` (
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `denied_users`
--

INSERT INTO `denied_users` (`name`) VALUES
('Olyad');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(50) NOT NULL,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `type` int(2) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `type`, `username`, `password`) VALUES
('0986/10', 'Olyad', 'Bizuneh', 0, 'Olyad', '123456'),
('1', 'Kassahun', 'Ambachew', 0, 'kambachew', 'kmb'),
('111ee', 'tit', 'boi', 1, 'tb', '[C@49240580'),
('2', 'Degu', 'Debebe', 1, 'Dedebebe', 'degu'),
('56', 'Ruby', 'Abebe', 0, 'Ruby', 'rub'),
('56df', 'Hose', 'Labe', 0, 'Thor', 'thor'),
('ETS1318/10', 'Yoseph', 'Tenaw', 0, 'YT', '[C@25f4407b'),
('id1', 'Ricardo', 'Milos', 0, 'RicoMilos', 'ricardo'),
('id2', 'Void', 'main', 1, 'voidmane', 'vm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car_parts`
--
ALTER TABLE `car_parts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

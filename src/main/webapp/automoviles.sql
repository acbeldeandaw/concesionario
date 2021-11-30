-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2021 a las 21:21:31
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `automoviles`
--
CREATE DATABASE IF NOT EXISTS `automoviles` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `automoviles`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `automovil`
--

DROP TABLE IF EXISTS `automovil`;
CREATE TABLE `automovil` (
  `id` int(11) NOT NULL,
  `categoria` varchar(40) NOT NULL,
  `precio` int(11) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `modelo` varchar(40) NOT NULL,
  `fab` int(4) NOT NULL,
  `foto` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `automovil`
--

INSERT INTO `automovil` (`id`, `categoria`, `precio`, `marca`, `modelo`, `fab`, `foto`) VALUES
(1, 'Super', 108500, 'Corvette', 'ZR1', 2018, 'coche1.jpg'),
(2, 'Super', 295000, 'Aston Martin', 'DBS', 2019, 'coche2.jpg'),
(3, 'Super', 280000, 'Ferrari F8', 'Tributo', 2017, 'coche3.jpg'),
(4, 'Super', 407250, 'Lamborghini Aventador', 'SVJ', 2021, 'coche4.jpg'),
(5, 'Super', 2500000, 'Koenigsegg', 'Jesko', 2021, 'coche5.jpg'),
(6, 'Super', 300000, 'McLaren', 'GT', 2021, 'coche6.jpg'),
(7, 'Super', 108500, 'Corvette', 'ZR1', 2018, 'coche1.jpg'),
(8, 'Super', 295000, 'Aston Martin', 'DBS', 2019, 'coche2.jpg'),
(9, 'Super', 280000, 'Ferrari F8', 'Tributo', 2017, 'coche3.jpg'),
(10, 'Super', 407250, 'Lamborghini Aventador', 'SVJ', 2021, 'coche4.jpg'),
(11, 'Super', 2500000, 'Koenigsegg', 'Jesko', 2021, 'coche5.jpg'),
(12, 'Super', 300000, 'McLaren', 'GT', 2021, 'coche6.jpg'),
(13, 'Super', 108500, 'Corvette', 'ZR1', 2018, 'coche1.jpg'),
(14, 'Super', 295000, 'Aston Martin', 'DBS', 2019, 'coche2.jpg'),
(15, 'Super', 280000, 'Ferrari F8', 'Tributo', 2017, 'coche3.jpg'),
(16, 'Super', 407250, 'Lamborghini Aventador', 'SVJ', 2021, 'coche4.jpg'),
(17, 'Super', 2500000, 'Koenigsegg', 'Jesko', 2021, 'coche5.jpg'),
(18, 'Super', 300000, 'McLaren', 'GT', 2021, 'coche6.jpg'),
(19, 'Super', 108500, 'Corvette', 'ZR1', 2018, 'coche1.jpg'),
(20, 'Super', 295000, 'Aston Martin', 'DBS', 2019, 'coche2.jpg'),
(21, 'Super', 280000, 'Ferrari F8', 'Tributo', 2017, 'coche3.jpg'),
(22, 'Super', 407250, 'Lamborghini Aventador', 'SVJ', 2021, 'coche4.jpg'),
(23, 'Super', 2500000, 'Koenigsegg', 'Jesko', 2021, 'coche5.jpg'),
(24, 'Super', 300000, 'McLaren', 'GT', 2021, 'coche6.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `automovil`
--
ALTER TABLE `automovil`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `automovil`
--
ALTER TABLE `automovil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

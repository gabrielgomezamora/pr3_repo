-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2018 a las 22:56:39
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mesas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listareservas`
--

CREATE TABLE `listareservas` (
  `idmesa` int(2) NOT NULL,
  `hora` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `comensales` int(2) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `idReserva` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `listareservas`
--

INSERT INTO `listareservas` (`idmesa`, `hora`, `fecha`, `comensales`, `nombre`, `idReserva`) VALUES
(2, 13, '2018-11-30', 6, 'maria y amigos', 2),
(1, 13, '2018-11-28', 3, 'Famila lopez', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `listareservas`
--
ALTER TABLE `listareservas`
  ADD PRIMARY KEY (`idReserva`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

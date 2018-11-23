-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2018 a las 22:48:39
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
-- Estructura de tabla para la tabla `listamesas`
--

CREATE TABLE `listamesas` (
  `identificador` int(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `camarero` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `listamesas`
--

INSERT INTO `listamesas` (`identificador`, `estado`, `camarero`) VALUES
(1, 'ocupado', 'juan'),
(2, 'libre', 'Juan'),
(3, 'libre', 'Juan'),
(4, 'libre', 'Juan'),
(5, 'libre', 'Pepe'),
(6, 'Ocupado', 'Pepe'),
(7, 'libre', 'Pepe'),
(8, 'libre', 'Pepe'),
(9, 'Ocupado', 'Pepe');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `listamesas`
--
ALTER TABLE `listamesas`
  ADD PRIMARY KEY (`identificador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

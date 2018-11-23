-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2018 a las 20:21:46
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
-- Base de datos: `turnos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listaturnos`
--

CREATE TABLE `listaturnos` (
  `identificador` int(20) NOT NULL,
  `tipoTurno` varchar(20) NOT NULL,
  `tipoempleado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `listaturnos`
--

INSERT INTO `listaturnos` (`identificador`, `tipoTurno`, `tipoempleado`) VALUES
(1, 'Noche', 'Cocinero'),
(2, 'Noche', 'Camarero'),
(3, 'Noche', 'Camarero'),
(4, 'Noche', 'Camarero'),
(5, 'Noche', 'Pinche'),
(6, 'Dia', 'Cocinero'),
(7, 'Dia', 'Camarero'),
(8, 'Dia', 'Cocinero'),
(9, 'Dia', 'Camarero'),
(10, 'Noche', 'Camarero');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `listaturnos`
--
ALTER TABLE `listaturnos`
  ADD PRIMARY KEY (`identificador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

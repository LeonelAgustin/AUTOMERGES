-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-07-2023 a las 17:50:34
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `automerges`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accion`
--

CREATE TABLE `accion` (
  `idaccion` int(11) NOT NULL,
  `accion` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `accion`
--

INSERT INTO `accion` (`idaccion`, `accion`) VALUES
(1, 'Reparar'),
(2, 'Restaurar'),
(3, 'Comprar'),
(4, 'Vender'),
(5, 'Vendido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `Persona_idPersona` int(11) NOT NULL,
  `clave` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `Persona_idPersona`, `clave`) VALUES
(6, 35, '6as4d98qwe'),
(7, 36, 'admin123'),
(8, 37, 'admin321'),
(9, 38, '123dqqdwds');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deposito`
--

CREATE TABLE `deposito` (
  `idDeposito` int(11) NOT NULL,
  `empleado_idempleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deposito_has_vehiculo`
--

CREATE TABLE `deposito_has_vehiculo` (
  `Deposito_idDeposito` int(11) NOT NULL,
  `Vehiculo_Id_auto` int(11) NOT NULL,
  `estacionado` bit(1) DEFAULT NULL,
  `stock` float(6,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `Persona_idPersona` int(11) NOT NULL,
  `empleado_tipo_idempleado_tipo` int(11) NOT NULL,
  `sector` varchar(30) DEFAULT NULL,
  `horario_entrada` time DEFAULT NULL,
  `horario_salida` time DEFAULT NULL,
  `is_despedido` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `clave`, `Persona_idPersona`, `empleado_tipo_idempleado_tipo`, `sector`, `horario_entrada`, `horario_salida`, `is_despedido`) VALUES
(1, 'admin123', 36, 1, NULL, NULL, NULL, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado_tipo`
--

CREATE TABLE `empleado_tipo` (
  `idempleado_tipo` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado_tipo`
--

INSERT INTO `empleado_tipo` (`idempleado_tipo`, `Nombre`) VALUES
(1, 'Ventas'),
(2, 'Mecanico'),
(3, 'Encargado del deposito'),
(4, 'fabricante'),
(5, 'Administrador'),
(6, 'Encargado de taller');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `idestados` int(11) NOT NULL,
  `estado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`idestados`, `estado`) VALUES
(1, 'terminado'),
(2, 'en proceso'),
(3, 'suspendido'),
(4, 'en cola'),
(5, 'rechazado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricante`
--

CREATE TABLE `fabricante` (
  `idfabricante` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fabricante`
--

INSERT INTO `fabricante` (`idfabricante`, `nombre`) VALUES
(1, 'automerges');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  `Vehiculo_Id_auto` int(11) DEFAULT NULL,
  `Pieza_Numero_de_pieza` int(11) DEFAULT NULL,
  `Precio` float(30,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`idfactura`, `cliente_idcliente`, `Vehiculo_Id_auto`, `Pieza_Numero_de_pieza`, `Precio`, `cantidad`) VALUES
(1, 7, NULL, 1, 20000.00, 9000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe`
--

CREATE TABLE `informe` (
  `idinforme` int(11) NOT NULL,
  `asunto` varchar(45) DEFAULT NULL,
  `estados_idestados` int(11) NOT NULL,
  `Vehiculo_Id_auto` int(11) NOT NULL,
  `Hora_de_trabajo` float(4,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `informe`
--

INSERT INTO `informe` (`idinforme`, `asunto`, `estados_idestados`, `Vehiculo_Id_auto`, `Hora_de_trabajo`) VALUES
(1, 'restaurar auto', 4, 3, 0.00),
(2, 'restaurar auto', 4, 4, 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `idorden` int(11) NOT NULL,
  `nombrePieza` varchar(45) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `taller_idtaller` int(11) NOT NULL,
  `Importada` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `dni` float(10,0) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `altura` int(11) DEFAULT 0,
  `telefono` float(20,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `dni`, `nombre`, `apellido`, `direccion`, `altura`, `telefono`) VALUES
(33, 321654976, 'asdqwezxc', 'zxcasddqwe', 'asdqwe', 321, 321654976),
(34, 321654976, 'asdqwecx', 'asdqwcz', 'asdqwezc', 324, 654687936),
(35, 321654976, 'xzcasdqwe', 'zxcasdqwe', 'asdqwecx', 654, 654987328),
(36, 12345678, 'javier', 'perez', 'nep', 123, 12345678),
(37, 123456984, 'nombre', 'apellido', 'calle', 123, 123456792),
(38, 123456744, 'nombrea', 'apellidoa', 'avenida', 100, 123458848);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pieza`
--

CREATE TABLE `pieza` (
  `Numero_de_pieza` int(11) NOT NULL,
  `nombre_Pieza` varchar(60) DEFAULT NULL,
  `Pieza_precio` float(20,2) DEFAULT NULL,
  `Importada` bit(1) NOT NULL DEFAULT b'0',
  `fabricante_idfabricante` int(11) NOT NULL DEFAULT 0,
  `Estado_proceso` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pieza`
--

INSERT INTO `pieza` (`Numero_de_pieza`, `nombre_Pieza`, `Pieza_precio`, `Importada`, `fabricante_idfabricante`, `Estado_proceso`) VALUES
(1, 'un clavo oxidado', 20000.00, b'0', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pieza_has_deposito`
--

CREATE TABLE `pieza_has_deposito` (
  `Pieza_Numero_de_pieza` int(11) NOT NULL,
  `Deposito_idDeposito` int(11) NOT NULL,
  `stock` float(6,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `taller`
--

CREATE TABLE `taller` (
  `idtaller` int(11) NOT NULL,
  `Deposito_idDeposito` int(11) NOT NULL,
  `informe_idinforme` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `Id_auto` int(11) NOT NULL,
  `Patente` varchar(7) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `año` float(4,0) DEFAULT NULL,
  `accion_idaccion` int(11) NOT NULL,
  `cliente_idcliente` int(11) DEFAULT NULL,
  `Precio` float(30,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`Id_auto`, `Patente`, `marca`, `modelo`, `año`, `accion_idaccion`, `cliente_idcliente`, `Precio`) VALUES
(1, 'iro403', 'uala', 'live', 4000, 3, NULL, 400.00),
(2, 'pat123', 'marca', 'modelo', 3000, 3, NULL, 500.00),
(3, 'ior123', 'marca', 'modelo', 3000, 2, 7, 50.00),
(4, 'ayu123', 'modelol', 'cvudaa', 4000, 2, 7, 8000.00),
(6, 'poo123', 'modelo', '1234', 4000, 3, NULL, 2.55),
(10, 'mod123', 'MARC', 'modelo', 1233, 1, 8, 400.00),
(11, 'mod123', 'MARC', 'modelo', 1233, 1, 7, 400.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accion`
--
ALTER TABLE `accion`
  ADD PRIMARY KEY (`idaccion`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD KEY `fk_cliente_Persona1_idx` (`Persona_idPersona`);

--
-- Indices de la tabla `deposito`
--
ALTER TABLE `deposito`
  ADD PRIMARY KEY (`idDeposito`),
  ADD KEY `fk_Deposito_empleado1_idx` (`empleado_idempleado`);

--
-- Indices de la tabla `deposito_has_vehiculo`
--
ALTER TABLE `deposito_has_vehiculo`
  ADD PRIMARY KEY (`Deposito_idDeposito`,`Vehiculo_Id_auto`),
  ADD KEY `fk_Deposito_has_Vehiculo_Vehiculo1_idx` (`Vehiculo_Id_auto`),
  ADD KEY `fk_Deposito_has_Vehiculo_Deposito1_idx` (`Deposito_idDeposito`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idempleado`),
  ADD KEY `fk_empleado_Persona1_idx` (`Persona_idPersona`),
  ADD KEY `fk_empleado_empleado_tipo1_idx` (`empleado_tipo_idempleado_tipo`);

--
-- Indices de la tabla `empleado_tipo`
--
ALTER TABLE `empleado_tipo`
  ADD PRIMARY KEY (`idempleado_tipo`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`idestados`);

--
-- Indices de la tabla `fabricante`
--
ALTER TABLE `fabricante`
  ADD PRIMARY KEY (`idfabricante`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idfactura`),
  ADD KEY `fk_factura_Vehiculo1_idx` (`Vehiculo_Id_auto`),
  ADD KEY `fk_factura_Pieza1_idx` (`Pieza_Numero_de_pieza`),
  ADD KEY `fk_factura_cliente1_idx` (`cliente_idcliente`);

--
-- Indices de la tabla `informe`
--
ALTER TABLE `informe`
  ADD PRIMARY KEY (`idinforme`),
  ADD KEY `fk_informe_estados1_idx` (`estados_idestados`),
  ADD KEY `fk_informe_Vehiculo1_idx` (`Vehiculo_Id_auto`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`idorden`),
  ADD KEY `fk_orden_taller1_idx` (`taller_idtaller`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `pieza`
--
ALTER TABLE `pieza`
  ADD PRIMARY KEY (`Numero_de_pieza`),
  ADD KEY `fk_Pieza_fabricante_idx` (`fabricante_idfabricante`);

--
-- Indices de la tabla `pieza_has_deposito`
--
ALTER TABLE `pieza_has_deposito`
  ADD PRIMARY KEY (`Pieza_Numero_de_pieza`,`Deposito_idDeposito`),
  ADD KEY `fk_Pieza_has_Deposito_Deposito1_idx` (`Deposito_idDeposito`),
  ADD KEY `fk_Pieza_has_Deposito_Pieza1_idx` (`Pieza_Numero_de_pieza`);

--
-- Indices de la tabla `taller`
--
ALTER TABLE `taller`
  ADD PRIMARY KEY (`idtaller`),
  ADD KEY `fk_taller_Deposito1_idx` (`Deposito_idDeposito`),
  ADD KEY `fk_taller_informe1_idx` (`informe_idinforme`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`Id_auto`),
  ADD KEY `fk_Vehiculo_accion1_idx` (`accion_idaccion`),
  ADD KEY `fk_Vehiculo_cliente1_idx` (`cliente_idcliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accion`
--
ALTER TABLE `accion`
  MODIFY `idaccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `deposito`
--
ALTER TABLE `deposito`
  MODIFY `idDeposito` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idempleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `empleado_tipo`
--
ALTER TABLE `empleado_tipo`
  MODIFY `idempleado_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
  MODIFY `idestados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `fabricante`
--
ALTER TABLE `fabricante`
  MODIFY `idfabricante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `idfactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `informe`
--
ALTER TABLE `informe`
  MODIFY `idinforme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `idorden` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `pieza`
--
ALTER TABLE `pieza`
  MODIFY `Numero_de_pieza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `taller`
--
ALTER TABLE `taller`
  MODIFY `idtaller` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `Id_auto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `deposito`
--
ALTER TABLE `deposito`
  ADD CONSTRAINT `fk_Deposito_empleado1` FOREIGN KEY (`empleado_idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `deposito_has_vehiculo`
--
ALTER TABLE `deposito_has_vehiculo`
  ADD CONSTRAINT `fk_Deposito_has_Vehiculo_Deposito1` FOREIGN KEY (`Deposito_idDeposito`) REFERENCES `deposito` (`idDeposito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Deposito_has_Vehiculo_Vehiculo1` FOREIGN KEY (`Vehiculo_Id_auto`) REFERENCES `vehiculo` (`Id_auto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_empleado_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_empleado_empleado_tipo1` FOREIGN KEY (`empleado_tipo_idempleado_tipo`) REFERENCES `empleado_tipo` (`idempleado_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_factura_Pieza1` FOREIGN KEY (`Pieza_Numero_de_pieza`) REFERENCES `pieza` (`Numero_de_pieza`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_Vehiculo1` FOREIGN KEY (`Vehiculo_Id_auto`) REFERENCES `vehiculo` (`Id_auto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `informe`
--
ALTER TABLE `informe`
  ADD CONSTRAINT `fk_informe_Vehiculo1` FOREIGN KEY (`Vehiculo_Id_auto`) REFERENCES `vehiculo` (`Id_auto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_informe_estados1` FOREIGN KEY (`estados_idestados`) REFERENCES `estados` (`idestados`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `fk_orden_taller1` FOREIGN KEY (`taller_idtaller`) REFERENCES `taller` (`idtaller`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pieza`
--
ALTER TABLE `pieza`
  ADD CONSTRAINT `fk_Pieza_fabricante` FOREIGN KEY (`fabricante_idfabricante`) REFERENCES `fabricante` (`idfabricante`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pieza_has_deposito`
--
ALTER TABLE `pieza_has_deposito`
  ADD CONSTRAINT `fk_Pieza_has_Deposito_Deposito1` FOREIGN KEY (`Deposito_idDeposito`) REFERENCES `deposito` (`idDeposito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pieza_has_Deposito_Pieza1` FOREIGN KEY (`Pieza_Numero_de_pieza`) REFERENCES `pieza` (`Numero_de_pieza`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `taller`
--
ALTER TABLE `taller`
  ADD CONSTRAINT `fk_taller_Deposito1` FOREIGN KEY (`Deposito_idDeposito`) REFERENCES `deposito` (`idDeposito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_taller_informe1` FOREIGN KEY (`informe_idinforme`) REFERENCES `informe` (`idinforme`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `fk_Vehiculo_accion1` FOREIGN KEY (`accion_idaccion`) REFERENCES `accion` (`idaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vehiculo_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- MySQL Script generated by MySQL Workbench
-- Thu Jun  8 16:05:36 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Automerges
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Automerges` ;

-- -----------------------------------------------------
-- Schema Automerges
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Automerges` DEFAULT CHARACTER SET utf8mb4 ;
USE `Automerges` ;

-- -----------------------------------------------------
-- Table `Automerges`.`fabricante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`fabricante` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`fabricante` (
  `idfabricante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL,
  PRIMARY KEY (`idfabricante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Automerges`.`Pieza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`Pieza` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`Pieza` (
  `Numero_de_pieza` INT NOT NULL AUTO_INCREMENT,
  `nombre_Pieza` VARCHAR(60) NULL,
  `Pieza_precio` FLOAT(20,2) NULL,
  `Importada` BIT NOT NULL DEFAULT 0,
  `fabricante_idfabricante` INT NOT NULL DEFAULT 0,
  `Estado_proceso` VARCHAR(50) NULL,
  PRIMARY KEY (`Numero_de_pieza`),
  CONSTRAINT `fk_Pieza_fabricante`
    FOREIGN KEY (`fabricante_idfabricante`)
    REFERENCES `Automerges`.`fabricante` (`idfabricante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pieza_fabricante_idx` ON `Automerges`.`Pieza` (`fabricante_idfabricante` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`Persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`Persona` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `dni` FLOAT(10,0) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `altura` INT NULL DEFAULT 0,
  `telefono` FLOAT(20,0) NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Automerges`.`empleado_tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`empleado_tipo` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`empleado_tipo` (
  `idempleado_tipo` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idempleado_tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Automerges`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`empleado` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`empleado` (
  `idempleado` INT NOT NULL AUTO_INCREMENT,
  `clave` VARCHAR(45) NOT NULL,
  `Persona_idPersona` INT NOT NULL,
  `empleado_tipo_idempleado_tipo` INT NOT NULL,
  `sector` VARCHAR(30) NULL,
  `horario_entrada` TIME NULL,
  `horario_salida` TIME NULL,
  `is_despedido` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idempleado`),
  CONSTRAINT `fk_empleado_Persona1`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `Automerges`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_empleado_tipo1`
    FOREIGN KEY (`empleado_tipo_idempleado_tipo`)
    REFERENCES `Automerges`.`empleado_tipo` (`idempleado_tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_empleado_Persona1_idx` ON `Automerges`.`empleado` (`Persona_idPersona` ASC);

CREATE INDEX `fk_empleado_empleado_tipo1_idx` ON `Automerges`.`empleado` (`empleado_tipo_idempleado_tipo` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`Deposito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`Deposito` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`Deposito` (
  `idDeposito` INT NOT NULL AUTO_INCREMENT,
  `empleado_idempleado` INT NOT NULL,
  PRIMARY KEY (`idDeposito`),
  CONSTRAINT `fk_Deposito_empleado1`
    FOREIGN KEY (`empleado_idempleado`)
    REFERENCES `Automerges`.`empleado` (`idempleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Deposito_empleado1_idx` ON `Automerges`.`Deposito` (`empleado_idempleado` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`Pieza_has_Deposito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`Pieza_has_Deposito` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`Pieza_has_Deposito` (
  `Pieza_Numero_de_pieza` INT NOT NULL,
  `Deposito_idDeposito` INT NOT NULL,
  `stock` FLOAT(6,0) NULL,
  PRIMARY KEY (`Pieza_Numero_de_pieza`, `Deposito_idDeposito`),
  CONSTRAINT `fk_Pieza_has_Deposito_Pieza1`
    FOREIGN KEY (`Pieza_Numero_de_pieza`)
    REFERENCES `Automerges`.`Pieza` (`Numero_de_pieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pieza_has_Deposito_Deposito1`
    FOREIGN KEY (`Deposito_idDeposito`)
    REFERENCES `Automerges`.`Deposito` (`idDeposito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pieza_has_Deposito_Deposito1_idx` ON `Automerges`.`Pieza_has_Deposito` (`Deposito_idDeposito` ASC);

CREATE INDEX `fk_Pieza_has_Deposito_Pieza1_idx` ON `Automerges`.`Pieza_has_Deposito` (`Pieza_Numero_de_pieza` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`accion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`accion` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`accion` (
  `idaccion` INT NOT NULL AUTO_INCREMENT,
  `accion` VARCHAR(15) NULL,
  PRIMARY KEY (`idaccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Automerges`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`cliente` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `Persona_idPersona` INT NOT NULL,
  `clave` VARCHAR(45) NULL,
  PRIMARY KEY (`idcliente`),
  CONSTRAINT `fk_cliente_Persona1`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `Automerges`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cliente_Persona1_idx` ON `Automerges`.`cliente` (`Persona_idPersona` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`Vehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`Vehiculo` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`Vehiculo` (
  `Id_auto` INT NOT NULL AUTO_INCREMENT,
  `Patente` VARCHAR(7) NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `año` FLOAT(4,0) NULL,
  `accion_idaccion` INT NOT NULL,
  `cliente_idcliente` INT NULL,
  `Precio` FLOAT(30,2) NULL,
  PRIMARY KEY (`Id_auto`),
  CONSTRAINT `fk_Vehiculo_accion1`
    FOREIGN KEY (`accion_idaccion`)
    REFERENCES `Automerges`.`accion` (`idaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehiculo_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `Automerges`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Vehiculo_accion1_idx` ON `Automerges`.`Vehiculo` (`accion_idaccion` ASC);

CREATE INDEX `fk_Vehiculo_cliente1_idx` ON `Automerges`.`Vehiculo` (`cliente_idcliente` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`Deposito_has_Vehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`Deposito_has_Vehiculo` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`Deposito_has_Vehiculo` (
  `Deposito_idDeposito` INT NOT NULL,
  `Vehiculo_Id_auto` INT NOT NULL,
  `estacionado` BIT NULL,
  `stock` FLOAT(6,0) NULL,
  PRIMARY KEY (`Deposito_idDeposito`, `Vehiculo_Id_auto`),
  CONSTRAINT `fk_Deposito_has_Vehiculo_Deposito1`
    FOREIGN KEY (`Deposito_idDeposito`)
    REFERENCES `Automerges`.`Deposito` (`idDeposito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Deposito_has_Vehiculo_Vehiculo1`
    FOREIGN KEY (`Vehiculo_Id_auto`)
    REFERENCES `Automerges`.`Vehiculo` (`Id_auto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Deposito_has_Vehiculo_Vehiculo1_idx` ON `Automerges`.`Deposito_has_Vehiculo` (`Vehiculo_Id_auto` ASC);

CREATE INDEX `fk_Deposito_has_Vehiculo_Deposito1_idx` ON `Automerges`.`Deposito_has_Vehiculo` (`Deposito_idDeposito` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`estados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`estados` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`estados` (
  `idestados` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idestados`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Automerges`.`informe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`informe` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`informe` (
  `idinforme` INT NOT NULL AUTO_INCREMENT,
  `asunto` VARCHAR(45) NULL,
  `estados_idestados` INT NOT NULL,
  `Vehiculo_Id_auto` INT NOT NULL,
  `Hora_de_trabajo` FLOAT(4,2) NULL DEFAULT 0,
  PRIMARY KEY (`idinforme`),
  CONSTRAINT `fk_informe_estados1`
    FOREIGN KEY (`estados_idestados`)
    REFERENCES `Automerges`.`estados` (`idestados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_informe_Vehiculo1`
    FOREIGN KEY (`Vehiculo_Id_auto`)
    REFERENCES `Automerges`.`Vehiculo` (`Id_auto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_informe_estados1_idx` ON `Automerges`.`informe` (`estados_idestados` ASC);

CREATE INDEX `fk_informe_Vehiculo1_idx` ON `Automerges`.`informe` (`Vehiculo_Id_auto` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`taller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`taller` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`taller` (
  `idtaller` INT NOT NULL AUTO_INCREMENT,
  `Deposito_idDeposito` INT NOT NULL,
  `informe_idinforme` INT NOT NULL,
  PRIMARY KEY (`idtaller`),
  CONSTRAINT `fk_taller_Deposito1`
    FOREIGN KEY (`Deposito_idDeposito`)
    REFERENCES `Automerges`.`Deposito` (`idDeposito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_taller_informe1`
    FOREIGN KEY (`informe_idinforme`)
    REFERENCES `Automerges`.`informe` (`idinforme`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_taller_Deposito1_idx` ON `Automerges`.`taller` (`Deposito_idDeposito` ASC);

CREATE INDEX `fk_taller_informe1_idx` ON `Automerges`.`taller` (`informe_idinforme` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`orden`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`orden` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`orden` (
  `idorden` INT NOT NULL AUTO_INCREMENT,
  `nombrePieza` VARCHAR(45) NULL,
  `cantidad` VARCHAR(45) NULL,
  `taller_idtaller` INT NOT NULL,
  `Importada` BIT NULL,
  PRIMARY KEY (`idorden`),
  CONSTRAINT `fk_orden_taller1`
    FOREIGN KEY (`taller_idtaller`)
    REFERENCES `Automerges`.`taller` (`idtaller`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_orden_taller1_idx` ON `Automerges`.`orden` (`taller_idtaller` ASC);


-- -----------------------------------------------------
-- Table `Automerges`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Automerges`.`factura` ;

CREATE TABLE IF NOT EXISTS `Automerges`.`factura` (
  `idfactura` INT NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  `Vehiculo_Id_auto` INT NULL,
  `Pieza_Numero_de_pieza` INT NULL,
  `Precio` FLOAT(30,2) NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`idfactura`),
  CONSTRAINT `fk_factura_Vehiculo1`
    FOREIGN KEY (`Vehiculo_Id_auto`)
    REFERENCES `Automerges`.`Vehiculo` (`Id_auto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_Pieza1`
    FOREIGN KEY (`Pieza_Numero_de_pieza`)
    REFERENCES `Automerges`.`Pieza` (`Numero_de_pieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `Automerges`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_factura_Vehiculo1_idx` ON `Automerges`.`factura` (`Vehiculo_Id_auto` ASC);

CREATE INDEX `fk_factura_Pieza1_idx` ON `Automerges`.`factura` (`Pieza_Numero_de_pieza` ASC);

CREATE INDEX `fk_factura_cliente1_idx` ON `Automerges`.`factura` (`cliente_idcliente` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Automerges`.`fabricante`
-- -----------------------------------------------------
START TRANSACTION;
USE `Automerges`;
INSERT INTO `Automerges`.`fabricante` (`idfabricante`, `nombre`) VALUES (0, 'automerges');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Automerges`.`empleado_tipo`
-- -----------------------------------------------------
START TRANSACTION;
USE `Automerges`;
INSERT INTO `Automerges`.`empleado_tipo` (`idempleado_tipo`, `Nombre`) VALUES (1, 'Ventas');
INSERT INTO `Automerges`.`empleado_tipo` (`idempleado_tipo`, `Nombre`) VALUES (2, 'Mecanico');
INSERT INTO `Automerges`.`empleado_tipo` (`idempleado_tipo`, `Nombre`) VALUES (5, 'Administrador');
INSERT INTO `Automerges`.`empleado_tipo` (`idempleado_tipo`, `Nombre`) VALUES (3, 'Encargado del deposito');
INSERT INTO `Automerges`.`empleado_tipo` (`idempleado_tipo`, `Nombre`) VALUES (4, 'fabricante');
INSERT INTO `Automerges`.`empleado_tipo` (`idempleado_tipo`, `Nombre`) VALUES (6, 'Encargado de taller');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Automerges`.`accion`
-- -----------------------------------------------------
START TRANSACTION;
USE `Automerges`;
INSERT INTO `Automerges`.`accion` (`idaccion`, `accion`) VALUES (1, 'Reparar');
INSERT INTO `Automerges`.`accion` (`idaccion`, `accion`) VALUES (2, 'Restaurar');
INSERT INTO `Automerges`.`accion` (`idaccion`, `accion`) VALUES (3, 'Comprar');
INSERT INTO `Automerges`.`accion` (`idaccion`, `accion`) VALUES (4, 'Vender');
INSERT INTO `Automerges`.`accion` (`idaccion`, `accion`) VALUES (5, 'Vendido');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Automerges`.`estados`
-- -----------------------------------------------------
START TRANSACTION;
USE `Automerges`;
INSERT INTO `Automerges`.`estados` (`idestados`, `estado`) VALUES (1, 'terminado');
INSERT INTO `Automerges`.`estados` (`idestados`, `estado`) VALUES (2, 'en proceso');
INSERT INTO `Automerges`.`estados` (`idestados`, `estado`) VALUES (3, 'suspendido');
INSERT INTO `Automerges`.`estados` (`idestados`, `estado`) VALUES (4, 'en cola');
INSERT INTO `Automerges`.`estados` (`idestados`, `estado`) VALUES (5, 'rechazado');

COMMIT;


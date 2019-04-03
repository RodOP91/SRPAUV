/*
Navicat MySQL Data Transfer

Source Server         : MariaDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : srpauv_db

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-04-03 10:04:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `articulo`
-- ----------------------------
DROP TABLE IF EXISTS `articulo`;
CREATE TABLE `articulo` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estadoActual` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lgac` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `ca` int(11) NOT NULL,
  `autor_es` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_revista` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `editorial` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `volumen` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `issn` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `paginas` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `año` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `proposito` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of articulo
-- ----------------------------

-- ----------------------------
-- Table structure for `articulo_ind_arb`
-- ----------------------------
DROP TABLE IF EXISTS `articulo_ind_arb`;
CREATE TABLE `articulo_ind_arb` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lgac` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ca` int(11) NOT NULL,
  `autor_es` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `nombreRevista` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `editorial` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `volumen` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `isnn` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `rangoPaginas` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `año` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `direccionElectronica` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `proposito` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of articulo_ind_arb
-- ----------------------------

-- ----------------------------
-- Table structure for `capitulolibro`
-- ----------------------------
DROP TABLE IF EXISTS `capitulolibro`;
CREATE TABLE `capitulolibro` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lgac` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ca` int(11) NOT NULL,
  `autor_es` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `editorial` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `rangoPaginas` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `año` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `proposito` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `noEdiciones` int(11) NOT NULL,
  `totalEjemplares` int(11) NOT NULL,
  `isbn` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tituloibro` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of capitulolibro
-- ----------------------------

-- ----------------------------
-- Table structure for `colaborador`
-- ----------------------------
DROP TABLE IF EXISTS `colaborador`;
CREATE TABLE `colaborador` (
  `idColaborador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoP` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidoM` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cuerpoAcademico` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `institucion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idColaborador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of colaborador
-- ----------------------------

-- ----------------------------
-- Table structure for `cuerpoacademico`
-- ----------------------------
DROP TABLE IF EXISTS `cuerpoacademico`;
CREATE TABLE `cuerpoacademico` (
  `clave` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `area` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `disciplina` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `gradoConsolidacion` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `ies` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of cuerpoacademico
-- ----------------------------
INSERT INTO `cuerpoacademico` VALUES ('1234', 'Economico-Administrativo', 'Ingenieria de Software', 'En Consolidacion', 'Universidad Veracruzana', 'Ingenieria y Tecnologia de Software');

-- ----------------------------
-- Table structure for `datoslaborales`
-- ----------------------------
DROP TABLE IF EXISTS `datoslaborales`;
CREATE TABLE `datoslaborales` (
  `idIntegrante` int(11) NOT NULL,
  `contratoPTC` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaIngresoUV` date DEFAULT NULL,
  `des` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nivelSNI` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombramiento` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `programaEducativo` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `unidadAcademica` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idIntegrante`),
  CONSTRAINT `FK_idIntegrante` FOREIGN KEY (`idIntegrante`) REFERENCES `integrante` (`idIntegrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of datoslaborales
-- ----------------------------

-- ----------------------------
-- Table structure for `estudiosrealizados`
-- ----------------------------
DROP TABLE IF EXISTS `estudiosrealizados`;
CREATE TABLE `estudiosrealizados` (
  `idIntegrante` int(11) NOT NULL,
  `area` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `disciplina` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estudiosEn` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaInicioEstudios` date DEFAULT NULL,
  `fechaFinEstudios` date DEFAULT NULL,
  `fechaObtencionTitulo` date DEFAULT NULL,
  `grado` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `institucionOtorgante` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pais` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idIntegrante`),
  CONSTRAINT `FK_idInteg` FOREIGN KEY (`idIntegrante`) REFERENCES `integrante` (`idIntegrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of estudiosrealizados
-- ----------------------------

-- ----------------------------
-- Table structure for `integrante`
-- ----------------------------
DROP TABLE IF EXISTS `integrante`;
CREATE TABLE `integrante` (
  `idIntegrante` int(11) NOT NULL AUTO_INCREMENT,
  `apellidoM` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidoP` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `area` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correoAdicional` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correoUV` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `curp` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `disciplina` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estadoCivil` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nacionalidad` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `noPersonal` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rfc` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoCasa` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoTrabajo` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idIntegrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of integrante
-- ----------------------------

-- ----------------------------
-- Table structure for `libro`
-- ----------------------------
DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lgac` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ca` int(11) NOT NULL,
  `autor_es` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `aditorial` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `año` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `proposito` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `noEdiciones` int(11) NOT NULL,
  `totalEjemplares` int(11) NOT NULL,
  `isbn` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of libro
-- ----------------------------

-- ----------------------------
-- Table structure for `linea`
-- ----------------------------
DROP TABLE IF EXISTS `linea`;
CREATE TABLE `linea` (
  `idLinea` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `idCA` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idLinea`),
  KEY `FK_idCA` (`idCA`),
  CONSTRAINT `FK_idCA` FOREIGN KEY (`idCA`) REFERENCES `cuerpoacademico` (`clave`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of linea
-- ----------------------------
INSERT INTO `linea` VALUES ('1', 'Modelado y Desarrollo de Software', '1234');
INSERT INTO `linea` VALUES ('2', 'Gestion y Aspectos Humanos del Desarrollo de Software', '1234');
INSERT INTO `linea` VALUES ('3', 'Tecnologias de Software', '1234');

-- ----------------------------
-- Table structure for `memoriaextenso`
-- ----------------------------
DROP TABLE IF EXISTS `memoriaextenso`;
CREATE TABLE `memoriaextenso` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estadoActual` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lgac` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `ca` int(11) NOT NULL,
  `autor_es` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `paginas` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `año` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `proposito` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `nombreCongreso` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `ciudad` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of memoriaextenso
-- ----------------------------

-- ----------------------------
-- Table structure for `produccioninovadora`
-- ----------------------------
DROP TABLE IF EXISTS `produccioninovadora`;
CREATE TABLE `produccioninovadora` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estadoActual` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lgac` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ca` int(11) NOT NULL,
  `descripcion` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `proposito` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `clasifInterna` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fechaPublicacion` date NOT NULL,
  `numRegistro` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of produccioninovadora
-- ----------------------------

-- ----------------------------
-- Table structure for `prototipo`
-- ----------------------------
DROP TABLE IF EXISTS `prototipo`;
CREATE TABLE `prototipo` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `lgac` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `autor_es` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `año` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `proposito` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `objetivos` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `caracteristicas` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `institucion` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of prototipo
-- ----------------------------

-- ----------------------------
-- Table structure for `tesis`
-- ----------------------------
DROP TABLE IF EXISTS `tesis`;
CREATE TABLE `tesis` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `noAlumnos` int(11) NOT NULL,
  `lgac` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ca` int(11) NOT NULL,
  `tipo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `grado` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ----------------------------
-- Records of tesis
-- ----------------------------
INSERT INTO `tesis` VALUES ('1', 'tesis1', 'null', '2019-03-23', '2019-03-30', '1', 'Gestion y Aspectos Humanos del Desarrollo de Software', '0', 'tesis', 'lic');
INSERT INTO `tesis` VALUES ('2', 'Tesis1', 'null', '2019-04-10', '2019-04-26', '1', 'Gestion y Aspectos Humanos del Desarrollo de Software', '0', 'tesis', 'Licenciatura');

-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql10.freesqldatabase.com
-- Generation Time: Nov 12, 2023 at 04:47 AM
-- Server version: 5.5.62-0ubuntu0.14.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_projeto4`
--
DROP DATABASE IF EXISTS `db_projeto4`;
CREATE DATABASE IF NOT EXISTS `db_projeto4` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `db_projeto4`;

-- --------------------------------------------------------

--
-- Table structure for table `agendamentos`
--

DROP TABLE IF EXISTS `agendamentos`;
CREATE TABLE `agendamentos` (
  `id` int(11) NOT NULL,
  `data` varchar(10) NOT NULL,
  `horario` varchar(5) NOT NULL,
  `id_donatario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `agendamentos`
--

INSERT INTO `agendamentos` (`id`, `data`, `horario`, `id_donatario`) VALUES
(1, '2023-10-31', '04:50', 14),
(2, '2023-11-17', '20:20', 15),
(3, '2023-10-11', '23:39', 16);

-- --------------------------------------------------------

--
-- Table structure for table `doacoes`
--

DROP TABLE IF EXISTS `doacoes`;
CREATE TABLE `doacoes` (
  `id` int(11) NOT NULL,
  `id_doador` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL DEFAULT 1,
  `computador` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doacoes`
--

INSERT INTO `doacoes` (`id`, `id_doador`, `quantidade`, `computador`) VALUES
(1, 7, 10, 'HP'),
(2, 8, 5, 'Lenovo'),
(3, 9, 7, 'Acer'),
(4, 10, 3, 'Asus'),
(5, 10, 6, 'Dell'),
(6, 9, 10, 'Positivo');

-- --------------------------------------------------------

--
-- Table structure for table `doadores`
--

DROP TABLE IF EXISTS `doadores`;
CREATE TABLE `doadores` (
  `id` int(11) NOT NULL,
  `id_cadastro` int(11) NOT NULL,
  `computadores_doados` int(11) NOT NULL DEFAULT 0,
  `tipo` enum('FISICO','JURIDICO') NOT NULL DEFAULT 'FISICO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doadores`
--

INSERT INTO `doadores` (`id`, `id_cadastro`, `computadores_doados`, `tipo`) VALUES
(1, 7, 0, 'FISICO'),
(2, 8, 0, 'FISICO'),
(3, 9, 0, 'FISICO'),
(4, 10, 0, 'FISICO');

-- --------------------------------------------------------

--
-- Table structure for table `doadoresJuridicos`
--

DROP TABLE IF EXISTS `doadoresJuridicos`;
CREATE TABLE `doadoresJuridicos` (
  `id` int(11) NOT NULL,
  `id_doador` int(11) NOT NULL,
  `endereco` varchar(255) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `donatarios`
--

DROP TABLE IF EXISTS `donatarios`;
CREATE TABLE `donatarios` (
  `id` int(11) NOT NULL,
  `id_cadastro` int(11) NOT NULL,
  `escola` varchar(255) NOT NULL,
  `posicao` int(11),
  `serie` int(11) NOT NULL,
  `id_doacao` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donatarios`
--

INSERT INTO `donatarios` (`id`, `id_cadastro`, `escola`, `posicao`, `serie`, `id_doacao`) VALUES
(1, 1, 'alguma', NULL, 3, 1),
(2, 2, 'alguma', NULL, 1, 2),
(3, 3, 'alguma', NULL, 2, 3),
(4, 11, 'alguma', NULL, 3, 4),
(5, 12, 'alguma', NULL, 1, 5),
(6, 13, 'alguma', NULL, 2, 6),
(7, 14, 'do rock', 1, 3, NULL),
(8, 15, 'do rock', 2, 3, NULL),
(9, 16, 'do rock', 3, 3, NULL),
(10, 17, 'do rock', 4, 3, NULL),
(11, 18, 'do rock', 5, 3, NULL),
(12, 19, 'do rock', 6, 3, NULL),
(13, 20, 'do rock', 7, 3, NULL),
(14, 21, 'do rock', 8, 3, NULL),
(15, 22, 'do rock', 9, 3, NULL),
(16, 23, 'do rock', 10, 3, NULL),
(17, 24, 'do rock', 11, 3, NULL),
(18, 25, 'do rock', 12, 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `estagiarios`
--

DROP TABLE IF EXISTS `estagiarios`;
CREATE TABLE `estagiarios` (
  `id` int(11) NOT NULL,
  `id_cadastro` int(11) NOT NULL,
  `dataDeEntrada` varchar(10) NOT NULL,
  `dataDeSaida` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `estagiarios`
--

INSERT INTO `estagiarios` (`id`, `id_cadastro`, `dataDeEntrada`, `dataDeSaida`) VALUES
(1, 5, '21/1/1', '10/1/1'),
(2, 6, '21/1/1', '10/1/1');

-- --------------------------------------------------------

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
CREATE TABLE `estoque` (
  `id` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL DEFAULT 'Computador',
  `quantidade` int(11) NOT NULL DEFAULT 1,
  `status` enum('DISPONIVEL', 'DOADO') DEFAULT 'DISPONIVEL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `estoque`
--

INSERT INTO `estoque`(`id`, `tipo`, `quantidade`, `status`) VALUES (1, 'Ram', 3, 'DOADO'),
(2, 'HD', 4, 'DOADO'),
(3, 'Processador', 1, 'DISPONIVEL');

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL,
  `id_donatario` int(11) NOT NULL,
  `estrelas` int(1) NOT NULL,
  `descricao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks`(`id`, `id_donatario`, `estrelas`, `descricao`) VALUES 
(1, 1, 5, 'Amei é tudo, acho o auge!!!!!'),
(2, 2, 2, 'Guys vou ter hablar, vocês tão pedindo...'),
(3, 3, 1, 'veyr, que nojoooo. 🤢🤮 Lixo transfóbico'),
(4, 11, 3, 'Uma benção 🙌🙌 pena que internet é do capeta'),
(5, 12, 4, 'Ai, Ai! Ui, Ui!\nUm Arraso!!!'),
(6, 13, 0, 'MACHISTA!');

-- --------------------------------------------------------

--
-- Table structure for table `mantecao`
--

DROP TABLE IF EXISTS `mantecao`;
CREATE TABLE `mantecao` (
  `id` int(11) NOT NULL,
  `data` varchar(255) NOT NULL,
  `estado` enum('FUNCIONANDO', 'QUEBRADO', 'FALTANDO_PECA', 'DEFEITUOSO') NOT NULL,
  `id_donatario` int(11) NOT NULL,
  `id_arrumador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pecas`
--

DROP TABLE IF EXISTS `pecas`;
CREATE TABLE `pecas` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `status` enum('EM_FALTA', 'COMPRADO') NOT NULL DEFAULT 'EM_FALTA',
  `quantidade` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pecas`
--

INSERT INTO `pecas` (`id`, `nome`, `marca`, `status`, `quantidade`) VALUES
(1, 'Placa de Vídeo', 'Nvidia', 'EM_FALTA', 5),
(2, 'Memória RAM', 'Corsair', 'EM_FALTA',10),
(3, 'HD', 'Seagate', 'EM_FALTA',3),
(4, 'Processador', 'Intel', 'COMPRADO', 7),
(5, 'Placa-mãe', 'ASUS', 'COMPRADO',2),
(6, 'Ram', '123', 'COMPRADO', 123);

-- --------------------------------------------------------

--
-- Table structure for table `professores`
--

DROP TABLE IF EXISTS `professores`;
CREATE TABLE `professores` (
  `id` int(11) NOT NULL,
  `id_cadastro` int(11) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `professores`
--

INSERT INTO `professores` (`id`, `id_cadastro`, `departamento`) VALUES
(1, 4, 'decom');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `codigo` varchar(18) NOT NULL,
  `tipo_codigo` enum('CPF', 'CNPJ') DEFAULT 'CPF',
  `email` varchar(32) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `foto` varchar(255) NOT NULL DEFAULT 'https://storage.cloud.google.com/projeto4/fotos/avatar.png',
  `tipo` enum('DONATARIO','PROFESSOR','ESTAGIARIO','DOADOR') DEFAULT 'DONATARIO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `codigo`, `tipo_codigo`, `email`, `senha`, `foto`, `tipo`) VALUES
(1, 'Fulaninho', '1', 'CPF', 'fulaninho@gmail.com', '$2a$15$DU9jyb6Rkdie9.qtsChzSubRxQ7/Al1WXswx9G17D2ghVD8notG7.', 'https://storage.cloud.google.com/projeto4/fotos/1_1700684150839.png', 'DONATARIO'),
(2, 'Ciclaninho', '2', 'CPF', 'ciclaninho@gmail.com', '$2a$15$cDId8Cyx0LiRRpLIQK0wauaQALX9fXH8hplKJM8jl5U1sHL1636Ye', 'https://storage.cloud.google.com/projeto4/fotos/2_1700684240282.png', 'DONATARIO'),
(3, 'Beltraninho', '3', 'CPF', 'beltraninho@gmail.com', '$2a$15$IwWkfXDlTheX9MTcoRkioOAawdJjIOg4o12rldcczwSymgXPbuYmO', 'https://storage.cloud.google.com/projeto4/fotos/3_1700684283068.png', 'DONATARIO'),
(4, 'Cristiano Maffort', '123', 'CPF', 'maffort@gmail.com', '$2a$15$D/1xK/3M1g5s9DeHL4Vu0u5LM3Tv6d2YXleiLZm8HHYujST/qfbXu', 'https://storage.cloud.google.com/projeto4/fotos/123_1700684064448.png', 'PROFESSOR'),
(5, 'miguel', '12345678900', 'CPF', 'miguel@gmail.com', '$2a$15$BbKV0hC/5S5i9r3VImrKz.3rEEPgml/F9gH6sQiblKY0xu76rUMsC', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'ESTAGIARIO'),
(6, 'rafael', '21345678900', 'CPF', 'rafael@gmail.com', '$2a$15$hzn5fEFQvyBF0RIVovZfRO9545613IRvZGzqqs8yMwV1X/BzGwonS', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'ESTAGIARIO'),
(7, 'Ruan', '4', 'CPF', 'l@l.l', '$2a$15$NGY0hkJxSXh92z2jKapYp.EIkz9ME.C5JwbvYTiY9DSX8w1xva//e', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DOADOR'),
(8, 'lucas', '5', 'CPF', 'exotic@gmail.com', '$2a$15$hRYBB849pmWOMUojFE62POepw4QFEfWWlH5bb5nt.IXIcZocJaGLq', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DOADOR'),
(9, 'caio', '6', 'CPF', 'caio@gmail.com', '$2a$15$CvyeFCpyWZN64N73KMhYwuinGqPke4leme47oq/lm7o/LG//eXBsS', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DOADOR'),
(10, 'vitor', '123653', 'CPF', 'vitor@gmail.com', '$2a$15$vLA5W48V8PhFCmoFvnrGF.rCOTc3w83ztSuOlRevL5MUb4ZnsxATu', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DOADOR'),
(11, 'Fulanão', '19', 'CPF', 'fulanao@gmail.com', '$2a$15$W2oMWsdgXY4RUOveVTAVPOMbgm7zW5OhY60qn2DjrcKJw1FijoYlC', 'https://storage.cloud.google.com/projeto4/fotos/19_1700684397697.png', 'DONATARIO'),
(12, 'Beltranão', '20', 'CPF', 'beltranao@gmail.com', '$2a$15$UxD.oUrRFJsk9mbkSgLhC.offDE6LoDtz4xdLMC0gcsDSaM70zapW', 'https://storage.cloud.google.com/projeto4/fotos/20_1700684584375.png', 'DONATARIO'),
(13, 'Ciclanão', '21', 'CPF', 'ciclanao@gmail.com', '$2a$15$CE7c02f1M6Inw8qkbFWN4.P8KSqRzcpBGOuAtRzzOJEoiGUJU3Pwq', 'https://storage.cloud.google.com/projeto4/fotos/21_1700684448373.png', 'DONATARIO'),
(14, 'Mick Jagger', '7', 'CPF', 'mick@jagger.com', '$2a$15$40.4/DMCNOjetEYkWE11XuQZjCwblnK0/knq.Eiknx3iRnu3rnSB2', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(15, 'Jimmy Page', '8', 'CPF', 'jimmy@page.com', '$2a$15$K05zxb0YkvD3.S1j8QadIej8v159iIPYkOLNIvF61YKlWIIcxv1om', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(16, 'Freddy Mercury', '9', 'CPF', 'freddy@mercury.com', '$2a$15$bPMzlUIcAj740/ppA8smAeKUq5Yc1SNGAuZQBeQZuv.g5pITYSSDG', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(17, 'John Lennon', '10', 'CPF', 'john@lennon.com', '$2a$15$Y6uZtc.T/qy/gT3RO1xgRulCbtg09v6OriybLxb204cYnoGWrFH/S', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(18, 'Janis Joplin', '11', 'CPF', 'janis@joplin.com', '$2a$15$YXm/Vi6CT76347FuwdxoXeoMphQgb4BV0f7gW0Z.DPjQBOWybFdPa', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(19, 'David Bowie', '12', 'CPF', 'david@bowie.com', '$2a$15$BCKJMWPPUredncITM2ByNuUCaVgn2LF.EMgTH/MNR2t1bNee4rhBe', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(20, 'Mick Jagger', '13', 'CPF', 'm1ck@jagger.com', '$2a$15$qjbbScbxDLBIQzD42xMWQeto2k5CVXwhO419mAeTenxm5/NT/McXi', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(21, 'Jimmy Page', '14', 'CPF', 'j1mmy@page.com', '$2a$15$fMdqEZfRKxeuWOHLROX2L.gbzy/g4bFfadrWcpblcohMUcKMfr32G', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(22, 'Freddy Mercury', '15', 'CPF', 'fr3ddy@mercury.com', '$2a$15$MOL6P6SSG8GdxVrjIuV8PehqAwW6Kl1gf0bMBgPbUfGSf5RVMX5qy', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(23, 'John Lennon', '16', 'CPF', 'j0hn@lennon.com', '$2a$15$JCzTpK3Gr/RCIu2//rlDgOyKWbjTK4JF94H.pI2EGQpLntd.f/mDC', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(24, 'Janis Joplin', '17', 'CPF', 'j4nis@joplin.com', '$2a$15$kdaZVzeHqhh3MhB.7DA5nOevnMRrZNMzqDOAU7iChyUeECwNS04/.', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO'),
(25, 'David Bowie', '18', 'CPF', 'd4vid@bowie.com', '$2a$15$5r6N4nVlbID46xIbkQka5.whsAgcw2Hdnq1WNGnBsmmlqN8chzp/u', 'https://storage.cloud.google.com/projeto4/fotos/avatar.png', 'DONATARIO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fk_agendamentos_usuarios` (`id_donatario`);

--
-- Indexes for table `doacoes`
--
ALTER TABLE `doacoes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doadores`
--
ALTER TABLE `doadores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fk_doadores_usuarios` (`id_cadastro`);

--
-- Indexes for table `doadoresJuridicos`
--
ALTER TABLE `doadoresJuridicos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fk_juridicos_doadores` (`id_doador`);

--
-- Indexes for table `donatarios`
--
ALTER TABLE `donatarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fk_donatarios_usuarios` (`id_cadastro`),
  ADD UNIQUE KEY `fk_donatarios_doacoes` (`id_doacao`);

--
-- Indexes for table `estagiarios`
--
ALTER TABLE `estagiarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fk_estagiarios_usuarios` (`id_cadastro`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mantecao`
--
ALTER TABLE `mantecao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pecas`
--
ALTER TABLE `pecas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fk_professores_usuarios` (`id_cadastro`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agendamentos`
--
ALTER TABLE `agendamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `doacoes`
--
ALTER TABLE `doacoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `doadores`
--
ALTER TABLE `doadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `doadoresJuridicos`
--
ALTER TABLE `doadoresJuridicos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `donatarios`
--
ALTER TABLE `donatarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estagiarios`
--
ALTER TABLE `estagiarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `doadoresJuridicos`
--
ALTER TABLE `mantecao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pecas`
--
ALTER TABLE `pecas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `professores`
--
ALTER TABLE `professores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- FOREIGN KEY for dumped tables
--

--
-- FOREIGN KEY for table `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD CONSTRAINT `fk_agendamentos_usuarios`
  FOREIGN KEY (`id_donatario`)
  REFERENCES `usuarios`(`id`) ON DELETE CASCADE;
--
-- FOREIGN KEY for table `doacoes`
--
ALTER TABLE `doacoes`
  ADD CONSTRAINT `fk_doacoes_usuarios`
  FOREIGN KEY (`id_doador`)
  REFERENCES `usuarios`(`id`)  ON DELETE CASCADE;
--
-- FOREIGN KEY for `doadores`
--
ALTER TABLE `doadores`
  ADD CONSTRAINT `fk_doadores_usuarios`
  FOREIGN KEY (`id_cadastro`)
  REFERENCES `usuarios`(`id`)  ON DELETE CASCADE; 
--
-- FOREIGN KEY for `doadoresJuridicos`
--
ALTER TABLE `doadoresJuridicos`
  ADD CONSTRAINT `fk_juridicos_doadores`
  FOREIGN KEY (`id_doador`)
  REFERENCES `doadores`(`id`)  ON DELETE CASCADE; 
--
-- FOREIGN KEY for `donatarios`
--
ALTER TABLE `donatarios`
  ADD CONSTRAINT `fk_donatarios_usuarios`
  FOREIGN KEY (`id_cadastro`)
  REFERENCES `usuarios`(`id`)  ON DELETE CASCADE,
  ADD CONSTRAINT `fk_donatarios_doacoes`
  FOREIGN KEY (`id_doacao`)
  REFERENCES `doacoes`(`id`);
--
-- FOREIGN KEY for `estagiarios`
--
ALTER TABLE `estagiarios`
  ADD CONSTRAINT `fk_estagiarios_usuarios`
  FOREIGN KEY (`id_cadastro`)
  REFERENCES `usuarios`(`id`)  ON DELETE CASCADE;
--
-- FOREIGN KEY for `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD CONSTRAINT `fk_feedbacks_usuarios`
  FOREIGN KEY (`id_donatario`)
  REFERENCES `usuarios`(`id`)  ON DELETE CASCADE;
--
-- FOREIGN KEY for table `doacoes`
--
ALTER TABLE `mantecao`
  ADD CONSTRAINT `fk_mantecao_usuarios_1`
  FOREIGN KEY (`id_donatario`)
  REFERENCES `usuarios`(`id`)  ON DELETE CASCADE,
  ADD CONSTRAINT `fk_mantecao_usuarios_2`
  FOREIGN KEY (`id_arrumador`)
  REFERENCES `usuarios`(`id`)  ON DELETE CASCADE;
--
-- FOREIGN KEY for `donatarios`
--
ALTER TABLE `professores`
  ADD CONSTRAINT `fk_professores_usuarios`
  FOREIGN KEY (`id_cadastro`)
  REFERENCES `usuarios`(`id`) ON DELETE CASCADE;          

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
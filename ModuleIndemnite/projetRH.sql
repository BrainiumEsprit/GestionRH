-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 10, 2019 at 01:38 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetRH`
--

-- --------------------------------------------------------

--
-- Table structure for table `competence`
--

CREATE TABLE `competence` (
  `id` int(11) NOT NULL,
  `libelle` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `competence`
--

INSERT INTO `competence` (`id`, `libelle`) VALUES
(1, 'Competence1'),
(2, 'Competence2'),
(3, 'Competence3');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `matricule` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`matricule`, `nom`) VALUES
(1, 'Employee1'),
(2, 'Employee2'),
(3, 'Employee3'),
(4, 'Employee4');

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE `formation` (
  `id` int(11) NOT NULL,
  `libformation` varchar(255) NOT NULL,
  `dateformation` date NOT NULL,
  `nbjformation` int(11) NOT NULL,
  `nbpformation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id`, `libformation`, `dateformation`, `nbjformation`, `nbpformation`) VALUES
(2, 'Formation IOT', '2019-11-12', 5, 70),
(4, 'Formation DataScience', '2019-11-22', 2, 6),
(5, 'Formation Arctic', '2019-12-21', 14, 20);

-- --------------------------------------------------------

--
-- Table structure for table `indemnite`
--

CREATE TABLE `indemnite` (
  `id_indem` int(11) NOT NULL,
  `code_indem` varchar(255) NOT NULL,
  `lib_indem` varchar(255) NOT NULL,
  `soumis_impot` int(11) NOT NULL,
  `compte` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `indemnite`
--

INSERT INTO `indemnite` (`id_indem`, `code_indem`, `lib_indem`, `soumis_impot`, `compte`) VALUES
(1, 'test548', 'LADHARI', 2026, '255411'),
(5, '555555', 'AZIIIIZZZ', 55555, '54545454');

-- --------------------------------------------------------

--
-- Table structure for table `matrice`
--

CREATE TABLE `matrice` (
  `id` int(11) NOT NULL,
  `compid` varchar(20) NOT NULL,
  `ne1` int(11) NOT NULL,
  `ne2` int(11) NOT NULL,
  `ne3` int(11) NOT NULL,
  `ne4` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matrice`
--

INSERT INTO `matrice` (`id`, `compid`, `ne1`, `ne2`, `ne3`, `ne4`) VALUES
(1, 'Competence1', 1, 2, 3, 1),
(2, 'Competence2', 2, 3, 2, 2),
(3, 'Competence3', 3, 1, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(1, 'user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER'),
(2, 'admin', '$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`matricule`);

--
-- Indexes for table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `indemnite`
--
ALTER TABLE `indemnite`
  ADD PRIMARY KEY (`id_indem`);

--
-- Indexes for table `matrice`
--
ALTER TABLE `matrice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `formation`
--
ALTER TABLE `formation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `indemnite`
--
ALTER TABLE `indemnite`
  MODIFY `id_indem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `matrice`
--
ALTER TABLE `matrice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

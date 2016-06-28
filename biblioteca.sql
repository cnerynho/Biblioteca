-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27-Jun-2016 às 22:54
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimos`
--

CREATE TABLE `emprestimos` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `data_inicio` date NOT NULL,
  `data_devolucao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens`
--

CREATE TABLE `itens` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `id_Setor` int(10) NOT NULL,
  `Disponivel` tinyint(1) NOT NULL,
  `tipo_item` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `itens`
--

INSERT INTO `itens` (`ID`, `Nome`, `id_Setor`, `Disponivel`, `tipo_item`) VALUES
(46, 'asda', 22, 1, 1),
(47, 'asda', 22, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livros`
--

CREATE TABLE `livros` (
  `id` int(11) NOT NULL,
  `editora` varchar(100) NOT NULL,
  `edicao` int(11) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `autor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `livros`
--

INSERT INTO `livros` (`id`, `editora`, `edicao`, `genero`, `autor`) VALUES
(1, 'asd', 1, '', ''),
(27, 'asd', 1, '', ''),
(29, 'asd', 1, '', ''),
(31, 'asd', 1, '', ''),
(33, 'asd', 1, '', ''),
(35, 'asd', 1, '', ''),
(37, 'asd', 1, '', ''),
(40, 'asd', 1, '', ''),
(43, 'asd', 1, '', ''),
(46, '', 1, '', ''),
(47, '', 1, '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `revistas`
--

CREATE TABLE `revistas` (
  `ID` int(11) NOT NULL,
  `ano` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `revistas`
--

INSERT INTO `revistas` (`ID`, `ano`, `numero`) VALUES
(38, 1, 1),
(41, 1, 1),
(44, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `setores`
--

CREATE TABLE `setores` (
  `id` int(11) NOT NULL,
  `localizacao` varchar(100) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `setores`
--

INSERT INTO `setores` (`id`, `localizacao`, `descricao`) VALUES
(22, 'dasdsa', 'asdasd');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tcc`
--

CREATE TABLE `tcc` (
  `ID` int(11) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `instituto` varchar(50) NOT NULL,
  `curso` varchar(50) NOT NULL,
  `orientador` varchar(50) NOT NULL,
  `campoDeEstudo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `Endereco` varchar(200) NOT NULL,
  `tipo_usuario` int(11) NOT NULL,
  `tipo_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `cpf`, `senha`, `Endereco`, `tipo_usuario`, `tipo_cliente`) VALUES
(1, 'carlos', '09581844457', '123456', 'asfasfasfasf', 1, 1),
(2, 'asdasd', '12345678945', 'asdasd', '', 1, 1),
(3, 'asdasd', '12345678925', 'asdasd', '', 2, 2),
(4, 'asdasd', '12345672925', 'asdasd', '', 3, 3),
(5, 'dassf', '00000000000', 'fsdfsdf', '', 1, 1),
(6, 'dassf', '00010000000', 'fsdfsdf', '', 1, 1),
(7, 'tytyi', '45454585454', 'ASFASF', 'asfgsdgsd', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `emprestimos`
--
ALTER TABLE `emprestimos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `itens`
--
ALTER TABLE `itens`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `id_Setor` (`id_Setor`),
  ADD KEY `id_Setor_2` (`id_Setor`);

--
-- Indexes for table `livros`
--
ALTER TABLE `livros`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `revistas`
--
ALTER TABLE `revistas`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `setores`
--
ALTER TABLE `setores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tcc`
--
ALTER TABLE `tcc`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emprestimos`
--
ALTER TABLE `emprestimos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `itens`
--
ALTER TABLE `itens`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `setores`
--
ALTER TABLE `setores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

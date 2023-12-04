CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `cpf` bigint NOT NULL,
  `email` varchar(200) NOT NULL,
  `senha` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
CREATE TABLE `enderecos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) NOT NULL,
  `cep` int NOT NULL,
  `logradouro` varchar(200) NOT NULL,
  `numero` int DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `cidade` varchar(100) NOT NULL,
  `uf` char(2) NOT NULL,
  PRIMARY KEY (`id`)
)
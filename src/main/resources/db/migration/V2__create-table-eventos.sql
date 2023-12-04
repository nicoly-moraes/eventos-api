CREATE TABLE `eventos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `endereco_id` int NOT NULL,
  `nome` varchar(200) NOT NULL,
  `data` datetime NOT NULL,
  `img` varchar(200) NOT NULL,
  `capa` varchar(200) NOT NULL,
  `sobre` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_eventos_enderecos_idx` (`endereco_id`),
  CONSTRAINT `fk_eventos_enderecos` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id`)
)
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `ingresso_id` int NOT NULL,
  `data` datetime NOT NULL,
  `status` int NOT NULL,
  `tipo_pagamento` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedidos_usuarios1_idx` (`usuario_id`),
  KEY `fk_pedidos_ingressos1_idx` (`ingresso_id`),
  CONSTRAINT `fk_pedidos_ingressos1` FOREIGN KEY (`ingresso_id`) REFERENCES `ingressos` (`id`),
  CONSTRAINT `fk_pedidos_usuarios1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB;
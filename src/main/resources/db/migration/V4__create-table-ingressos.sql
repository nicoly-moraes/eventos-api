CREATE TABLE IF NOT EXISTS `ingressos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `setor_id` INT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `qtd_limite` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ingressos_setores1_idx` (`setor_id` ASC) VISIBLE,
  CONSTRAINT `fk_ingressos_setores1`
    FOREIGN KEY (`setor_id`)
    REFERENCES `eventos`.`setores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `setores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `evento_id` INT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_setores_eventos1_idx` (`evento_id` ASC) VISIBLE,
  CONSTRAINT `fk_setores_eventos1`
    FOREIGN KEY (`evento_id`)
    REFERENCES `eventos`.`eventos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
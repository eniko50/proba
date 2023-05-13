SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vp02_ambulanta` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `vp02_ambulanta` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vp02_ambulanta`.`Pas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ime_psa` VARCHAR(45) NOT NULL,
  `ime_vlasnika` VARCHAR(45) NULL,
  `prezime_vlasnika` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tip_intervencije`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vp02_ambulanta`.`Tip_intervencije` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Intervencija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vp02_ambulanta`.`Intervencija` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `datum` DATETIME NULL,
  `Pas_id` INT NOT NULL,
  `Tip_intervencije_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Intervencija_Pas_idx` (`Pas_id` ASC),
  INDEX `fk_Intervencija_Tip_intervencije1_idx` (`Tip_intervencije_id` ASC),
  CONSTRAINT `fk_Intervencija_Pas`
    FOREIGN KEY (`Pas_id`)
    REFERENCES `vp02_ambulanta`.`Pas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Intervencija_Tip_intervencije1`
    FOREIGN KEY (`Tip_intervencije_id`)
    REFERENCES `vp02_ambulanta`.`Tip_intervencije` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into pas(ime_psa, ime_vlasnika, prezime_vlasnika) values ('Papi', 'Marko', 'Markovic');
insert into pas(ime_psa, ime_vlasnika, prezime_vlasnika) values ('Riki', 'Petar', 'Petrovic');
insert into pas(ime_psa, ime_vlasnika, prezime_vlasnika) values ('Alf', 'Zoran', 'Zoranovic');
insert into pas(ime_psa, ime_vlasnika, prezime_vlasnika) values ('Ava', 'Petar', 'Petrovic');

insert into Tip_intervencije (naziv) values ('Vakcinacija');
insert into Tip_intervencije (naziv) values ('Analiza krvi');
insert into Tip_intervencije (naziv) values ('Operacija');

insert into Intervencija (datum, Pas_id, Tip_intervencije_id) values ('2017-06-25', 1, 1);
insert into Intervencija (datum, Pas_id, Tip_intervencije_id) values ('2017-11-7', 1, 3);
insert into Intervencija (datum, Pas_id, Tip_intervencije_id) values ('2016-06-10', 1, 1);
insert into Intervencija (datum, Pas_id, Tip_intervencije_id) values ('2017-11-15', 2, 3);
insert into Intervencija (datum, Pas_id, Tip_intervencije_id) values ('2017-04-17', 3, 1);
insert into Intervencija (datum, Pas_id, Tip_intervencije_id) values ('2017-12-19', 3, 3);
insert into Intervencija (datum, Pas_id, Tip_intervencije_id) values ('2017-11-20', 4, 2);


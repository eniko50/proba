-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TipPostupka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TipPostupka` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SudskiPredmet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SudskiPredmet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brojPredmeta` VARCHAR(45) NOT NULL,
  `TipPostupka_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_SudskiPredmet_TipPostupka1_idx` (`TipPostupka_id` ASC),
  CONSTRAINT `fk_SudskiPredmet_TipPostupka1`
    FOREIGN KEY (`TipPostupka_id`)
    REFERENCES `mydb`.`TipPostupka` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Optuzeni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Optuzeni` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NULL,
  `SudskiPredmet_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Optuzeni_SudskiPredmet_idx` (`SudskiPredmet_id` ASC),
  CONSTRAINT `fk_Optuzeni_SudskiPredmet`
    FOREIGN KEY (`SudskiPredmet_id`)
    REFERENCES `mydb`.`SudskiPredmet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into tipPostupka (naziv) values ('Parnicni');
insert into tipPostupka (naziv) values ('Krivicni');

insert into sudskipredmet (brojPredmeta, tipPostupka_id) values ('1/2018', 1);
insert into sudskipredmet (brojPredmeta, tipPostupka_id) values ('2/2018', 1);
insert into sudskipredmet (brojPredmeta, tipPostupka_id) values ('3/2018', 2);
insert into sudskipredmet (brojPredmeta, tipPostupka_id) values ('4/2018', 1);
insert into sudskipredmet (brojPredmeta, tipPostupka_id) values ('5/2018', 2);

insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Petar', 'Petrovic', 1);
insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Marko', 'Petrovic', 1);
insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Dejan', 'Krstic', 2);
insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Ana', 'Tomic', 3);
insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Nenad', 'Matic', 4);
insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Zoran', 'Ivic', 5);
insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Nemanja', 'Tosic', 5);
insert into optuzeni(ime, prezime, SudskiPredmet_id) values ('Sanja', 'Stanic', 5);



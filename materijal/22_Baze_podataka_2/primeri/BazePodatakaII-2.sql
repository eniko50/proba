drop table Person;

CREATE TABLE Person(
	 `id` INTEGER  NOT NULL AUTO_INCREMENT,
     `first_name` VARCHAR(255),
     `last_name` VARCHAR(255),
     PRIMARY KEY (`id`),
     INDEX `first_name_FI_1` (`first_name`) #postavljanje indeksa prilikom kreiranja tabele
);

ALTER TABLE Person ADD INDEX `last_name_FI_1` (`last_name`); #postavljanje indeksa nakon kreiranja tabele

ALTER TABLE Person DROP INDEX `first_name_FI_1`; #uknlanjanje indeksa

SHOW INDEX FROM Person; #prikaz svih indeksa za tabelu

DROP TABLE Account;

CREATE TABLE Account(
	 `id` INTEGER  NOT NULL AUTO_INCREMENT,
     `amount` int,
     PRIMARY KEY (`id`)
);

INSERT INTO `Account` (`amount`) VALUES ('500');
INSERT INTO `Account` (`amount`) VALUES ('500');

START TRANSACTION;
	UPDATE `Account` SET `amount`=400 WHERE `id`=1;
	UPDATE `Account` SET `amount`=600 WHERE `id`=2;
COMMIT;

DROP PROCEDURE transfer;

DELIMITER //
CREATE PROCEDURE transfer(IN srcAccountId INT, IN dstAccountId INT, IN transferAmount INT)
 BEGIN
  START TRANSACTION;
	SELECT @srcAmount := `amount` FROM `Account` WHERE `id`=srcAccountId;
	SELECT @dstAmount := `amount` FROM `Account` WHERE `id`=dstAccountId;
    UPDATE `Account` SET `amount`=@srcAmount-transferAmount WHERE `id`=srcAccountId;
	UPDATE `Account` SET `amount`=@dstAmount+transferAmount WHERE `id`=dstAccountId;
  COMMIT;
 END //
DELIMITER ;

CALL transfer(1,2,100);

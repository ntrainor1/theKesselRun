-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema swdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `swdb` ;

-- -----------------------------------------------------
-- Schema swdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `swdb` DEFAULT CHARACTER SET utf8 ;
USE `swdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NULL,
  `password` VARCHAR(20) NULL,
  `admin` TINYINT NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `profile` ;

CREATE TABLE IF NOT EXISTS `profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image_url` VARCHAR(10000) NOT NULL DEFAULT 'http://icons.iconarchive.com/icons/sensibleworld/starwars/1024/Stormtrooper-icon.png',
  `name` VARCHAR(100) NOT NULL,
  `credits` INT NULL,
  `species` VARCHAR(50) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_profile`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_profile_idx` ON `profile` (`user_id` ASC);

CREATE UNIQUE INDEX `user_id_UNIQUE` ON `profile` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `crew`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crew` ;

CREATE TABLE IF NOT EXISTS `crew` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_profile_crew`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_profile_crew_idx` ON `crew` (`profile_id` ASC);


-- -----------------------------------------------------
-- Table `crew_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crew_role` ;

CREATE TABLE IF NOT EXISTS `crew_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crewmember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crewmember` ;

CREATE TABLE IF NOT EXISTS `crewmember` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `crew_id` INT NULL,
  `crew_role_id` INT NOT NULL,
  `cost` INT NOT NULL,
  `image_url` VARCHAR(10000) NOT NULL DEFAULT 'https://www.shareicon.net/download/2015/08/26/90992_robot_512x512.png',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_crew_crewmember`
    FOREIGN KEY (`crew_id`)
    REFERENCES `crew` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_crew_role_crewmember`
    FOREIGN KEY (`crew_role_id`)
    REFERENCES `crew_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_crew_crewmember_idx` ON `crewmember` (`crew_id` ASC);

CREATE INDEX `fk_crew_role_crewmember_idx` ON `crewmember` (`crew_role_id` ASC);


-- -----------------------------------------------------
-- Table `cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart` ;

CREATE TABLE IF NOT EXISTS `cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_profile_cart`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_profile_cart_idx` ON `cart` (`profile_id` ASC);


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item` ;

CREATE TABLE IF NOT EXISTS `item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` TEXT NOT NULL,
  `image_url` VARCHAR(10000) NOT NULL DEFAULT 'https://cdn.icon-icons.com/icons2/318/PNG/512/Death-Star-icon_34500.png',
  `price` INT UNSIGNED NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_category_item`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_category_item_idx` ON `item` (`category_id` ASC);


-- -----------------------------------------------------
-- Table `cart_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart_item` ;

CREATE TABLE IF NOT EXISTS `cart_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cart_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cart_cart_item`
    FOREIGN KEY (`cart_id`)
    REFERENCES `cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_cart_item`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cart_cart_item_idx` ON `cart_item` (`cart_id` ASC);

CREATE INDEX `fk_item_cart_item_idx` ON `cart_item` (`item_id` ASC);


-- -----------------------------------------------------
-- Table `inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory` ;

CREATE TABLE IF NOT EXISTS `inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_profile_inventory`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_inventory`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_profile_inventory_idx` ON `inventory` (`profile_id` ASC);

CREATE INDEX `fk_item_inventory` ON `inventory` (`item_id` ASC);

SET SQL_MODE = '';
GRANT USAGE ON *.* TO solo;
 DROP USER solo;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'solo' IDENTIFIED BY 'parsec';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'solo';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `user` (`id`, `username`, `password`, `admin`, `active`) VALUES (1, 'solo4ever', 'parsec', 0, 1);
INSERT INTO `user` (`id`, `username`, `password`, `admin`, `active`) VALUES (2, 'alecGuiness', 'onlyhope', 1, 1);
INSERT INTO `user` (`id`, `username`, `password`, `admin`, `active`) VALUES (3, 'slave_girl_leia', 'fisher', 0, 1);
INSERT INTO `user` (`id`, `username`, `password`, `admin`, `active`) VALUES (4, 'alderaan', 'imdead', 0, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `profile` (`id`, `image_url`, `name`, `credits`, `species`, `user_id`) VALUES (1, DEFAULT, 'Han Solo', 25000, 'Human', 1);
INSERT INTO `profile` (`id`, `image_url`, `name`, `credits`, `species`, `user_id`) VALUES (2, DEFAULT, 'Obi-Wan Kenobi', 100, 'Human', 2);
INSERT INTO `profile` (`id`, `image_url`, `name`, `credits`, `species`, `user_id`) VALUES (3, DEFAULT, 'Princess Leia', 2500, 'Human', 3);
INSERT INTO `profile` (`id`, `image_url`, `name`, `credits`, `species`, `user_id`) VALUES (4, DEFAULT, 'Leia\'s Dad', 0, 'Skeleton', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `crew`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `crew` (`id`, `profile_id`) VALUES (1, 1);
INSERT INTO `crew` (`id`, `profile_id`) VALUES (2, 2);
INSERT INTO `crew` (`id`, `profile_id`) VALUES (3, 3);
INSERT INTO `crew` (`id`, `profile_id`) VALUES (4, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `crew_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `crew_role` (`id`, `name`, `description`) VALUES (1, 'Bounty Hunter', 'Fierce warriors for hire.');
INSERT INTO `crew_role` (`id`, `name`, `description`) VALUES (2, 'Jedi', 'Noble soldiers from a bygone age.');
INSERT INTO `crew_role` (`id`, `name`, `description`) VALUES (3, 'Mechanic', 'Everyone needs a handyman.');
INSERT INTO `crew_role` (`id`, `name`, `description`) VALUES (4, 'Navigator', 'A skilled guide across the stars.');
INSERT INTO `crew_role` (`id`, `name`, `description`) VALUES (5, 'Gunner', 'Packing the heat!');

COMMIT;


-- -----------------------------------------------------
-- Data for table `crewmember`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `crewmember` (`id`, `name`, `crew_id`, `crew_role_id`, `cost`, `image_url`) VALUES (1, 'Boba Fett', NULL, 1, 400, DEFAULT);
INSERT INTO `crewmember` (`id`, `name`, `crew_id`, `crew_role_id`, `cost`, `image_url`) VALUES (2, 'Chewbacca', NULL, 4, 500, DEFAULT);
INSERT INTO `crewmember` (`id`, `name`, `crew_id`, `crew_role_id`, `cost`, `image_url`) VALUES (3, 'Yoda', NULL, 2, 750, DEFAULT);
INSERT INTO `crewmember` (`id`, `name`, `crew_id`, `crew_role_id`, `cost`, `image_url`) VALUES (4, 'Greedo', NULL, 1, 150, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cart`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `cart` (`id`, `profile_id`) VALUES (1, 1);
INSERT INTO `cart` (`id`, `profile_id`) VALUES (2, 2);
INSERT INTO `cart` (`id`, `profile_id`) VALUES (3, 3);
INSERT INTO `cart` (`id`, `profile_id`) VALUES (4, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `category` (`id`, `name`) VALUES (1, 'Weapon');
INSERT INTO `category` (`id`, `name`) VALUES (2, 'Decoration');
INSERT INTO `category` (`id`, `name`) VALUES (3, 'Tool');
INSERT INTO `category` (`id`, `name`) VALUES (4, 'Food');
INSERT INTO `category` (`id`, `name`) VALUES (5, 'Ship');
INSERT INTO `category` (`id`, `name`) VALUES (6, 'Miscellaneous');

COMMIT;


-- -----------------------------------------------------
-- Data for table `item`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (1, 'Blue Lightsaber', 'This elegant weapon glows blue.', DEFAULT, 10000, 1);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (2, 'Death Sticks', 'Ya wanna buy some death sticks?', DEFAULT, 50, 6);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (3, 'Millenium Falcon', 'What a piece of junk!', DEFAULT, 7500, 5);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (4, 'Blue Milk', 'What is this stuff?', DEFAULT, 150, 4);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (5, 'SZ-07 Blaster', 'Nothing beats a good blaster, kid.', DEFAULT, 450, 1);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (6, 'Kashyyyk Bowcaster', 'The preferred weapon of the Wookies of Kashyyyk.', DEFAULT, 1500, 1);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (7, 'Alderaan Lampshade', 'This lampshade foreshadows many things.', DEFAULT, 1000, 2);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (8, 'Socket Wrench', 'Helpful in loosening ion engine hoods.', DEFAULT, 750, 3);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (9, 'Slave I', 'The legendary ship of bounty hunter Boba Fett.', DEFAULT, 15000, 5);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`) VALUES (10, 'Jedi Robe', 'Relic of the now lost and forgotten Jedi Order.', DEFAULT, 6000, 2);

COMMIT;

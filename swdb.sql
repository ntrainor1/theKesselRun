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
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(1000) NULL,
  `role` VARCHAR(50) NULL DEFAULT 'standard',
  `enabled` TINYINT NULL,
  `image_url` VARCHAR(10000) NOT NULL DEFAULT 'http://icons.iconarchive.com/icons/sensibleworld/starwars/1024/Stormtrooper-icon.png',
  `credits` INT NULL,
  `species` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `username_UNIQUE` ON `user` (`username` ASC);


-- -----------------------------------------------------
-- Table `crew`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crew` ;

CREATE TABLE IF NOT EXISTS `crew` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_crew`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_crew_idx` ON `crew` (`user_id` ASC);


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
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_cart`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_cart_idx` ON `cart` (`user_id` ASC);


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
  `itemcol` VARCHAR(45) NULL,
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
  `user_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_item_inventory`
    FOREIGN KEY (`item_id`)
    REFERENCES `item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_inventory`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_item_inventory` ON `inventory` (`item_id` ASC);

CREATE INDEX `fk_user_inventory_idx` ON `inventory` (`user_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `user` (`id`, `username`, `password`, `role`, `enabled`, `image_url`, `credits`, `species`) VALUES (1, 'solo4ever', 'parsec', 'standard', 1, DEFAULT, 25000, 'Human');
INSERT INTO `user` (`id`, `username`, `password`, `role`, `enabled`, `image_url`, `credits`, `species`) VALUES (2, 'alecGuiness', 'onlyhope', 'admin', 1, DEFAULT, 100, 'Human');
INSERT INTO `user` (`id`, `username`, `password`, `role`, `enabled`, `image_url`, `credits`, `species`) VALUES (3, 'slave_girl_leia', 'goldsuit', 'standard', 1, DEFAULT, 2500, 'Human');
INSERT INTO `user` (`id`, `username`, `password`, `role`, `enabled`, `image_url`, `credits`, `species`) VALUES (4, 'alderaan', 'imdead', 'standard', 0, DEFAULT, 0, 'Skeleton');

COMMIT;


-- -----------------------------------------------------
-- Data for table `crew`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `crew` (`id`, `user_id`) VALUES (1, 1);
INSERT INTO `crew` (`id`, `user_id`) VALUES (2, 2);
INSERT INTO `crew` (`id`, `user_id`) VALUES (3, 3);
INSERT INTO `crew` (`id`, `user_id`) VALUES (4, 4);

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
INSERT INTO `cart` (`id`, `user_id`) VALUES (1, 1);
INSERT INTO `cart` (`id`, `user_id`) VALUES (2, 2);
INSERT INTO `cart` (`id`, `user_id`) VALUES (3, 3);
INSERT INTO `cart` (`id`, `user_id`) VALUES (4, 4);

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
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (1, 'Blue Lightsaber', 'This elegant weapon glows blue.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Lightsaber_blue.svg/2000px-Lightsaber_blue.svg.png', 10000, 1, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (2, 'Death Sticks', 'Ya wanna buy some death sticks?', 'http://3.bp.blogspot.com/_cYhz4d7ECdI/TGlNGVGeUaI/AAAAAAAABhM/o3WH4de-uXQ/s1600/star+wars+birthday+010.JPG', 50, 6, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (3, 'Millenium Falcon', 'What a piece of junk!', 'http://starwars.wikia.com/wiki/File:MillenniumFalconTFA-Fathead.png', 7500, 5, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (4, 'Blue Milk', 'What is this stuff?', 'http://www.magicalrecipes.net/wp-content/uploads/2015/05/star-wars-blue-milk.jpg', 150, 4, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (5, 'SZ-07 Blaster', 'Nothing beats a good blaster, kid.', 'https://vignette.wikia.nocookie.net/starwars/images/7/7b/Dl-44.jpg/revision/latest?cb=20080626152911', 450, 1, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (6, 'Kashyyyk Bowcaster', 'The preferred weapon of the Wookies of Kashyyyk.', 'https://vignette.wikia.nocookie.net/starwars/images/0/01/Bowcaster_negwt.jpg/revision/latest?cb=20060725172520', 1500, 1, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (7, 'Alderaan Lampshade', 'This lampshade foreshadows many things.', 'https://images-na.ssl-images-amazon.com/images/I/61RzCcxVBIL._AC_UL320_SR300,320_.jpg', 1000, 2, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (8, 'Socket Wrench', 'Helpful in loosening ion engine hoods.', 'https://c.shld.net/rpx/i/s/i/spin/10000595/prod_16529905912?hei=333&wid=333&op_sharpen=1', 750, 3, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (9, 'Slave I', 'The legendary ship of bounty hunter Boba Fett.', 'https://vignette.wikia.nocookie.net/starwars/images/a/a2/Ship-stub.png/revision/latest?cb=20151115024839', 15000, 5, NULL);
INSERT INTO `item` (`id`, `name`, `description`, `image_url`, `price`, `category_id`, `itemcol`) VALUES (10, 'Jedi Robe', 'Relic of the now lost and forgotten Jedi Order.', 'https://www.thinkgeek.com/images/products/zoom/af1b_deluxe_jedi_robe.jpg', 6000, 2, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory`
-- -----------------------------------------------------
START TRANSACTION;
USE `swdb`;
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (1, 1, 1);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (2, 2, 2);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (3, 2, 3);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (4, 2, 4);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (5, 3, 5);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (6, 3, 6);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (7, 3, 7);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (8, 1, 8);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (9, 2, 9);
INSERT INTO `inventory` (`id`, `user_id`, `item_id`) VALUES (10, 3, 10);

COMMIT;

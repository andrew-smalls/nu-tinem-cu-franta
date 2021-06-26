CREATE DATABASE plai_dev;

CREATE USER 'plai_dev_user'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'plai_dev_user'@'%' IDENTIFIED BY 'password';



GRANT SELECT ON plai_dev.* to 'plai_dev_user'@'localhost';
GRANT INSERT ON plai_dev.* to 'plai_dev_user'@'localhost';
GRANT DELETE ON plai_dev.* to 'plai_dev_user'@'localhost';
GRANT UPDATE ON plai_dev.* to 'plai_dev_user'@'localhost';
GRANT SELECT ON plai_dev.* to 'plai_dev_user'@'%';
GRANT INSERT ON plai_dev.* to 'plai_dev_user'@'%';
GRANT DELETE ON plai_dev.* to 'plai_dev_user'@'%';
GRANT UPDATE ON plai_dev.* to 'plai_dev_user'@'%';
GRANT ALTER ON plai_dev.* to 'plai_dev_user'@'localhost';
GRANT ALTER ON plai_dev.* to 'plai_dev_user'@'%';

-- creare tabel user
CREATE TABLE `plai_dev`.`users` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `first_name` VARCHAR(50) NOT NULL ,
     `last_name` VARCHAR(50) NOT NULL ,
      `email` VARCHAR(100) NOT NULL ,
    `password` VARCHAR(260) NOT NULL ,
     `role` VARCHAR(50) NOT NULL ,
      PRIMARY KEY (`id`),
       UNIQUE `password` (`password`),
        UNIQUE `email` (`email`)) ENGINE = InnoDB;

-- creare tabel organizatii
CREATE TABLE `plai_dev`.`organizations` (
    `id` INT NOT NULL ,
     `name` VARCHAR(100) NOT NULL ,
    `address` VARCHAR(100) NOT NULL ,
     `phone_number` VARCHAR(10) NOT NULL ,
      `representative_first_name` VARCHAR(50) NOT NULL ,
       `representative_last_name` VARCHAR(50) NOT NULL ,
        `description` TEXT , `webpage_link` TEXT ,
         `facebook_link` TEXT ,
          `type` VARCHAR(50) ) ENGINE = InnoDB;

-- creare tabel fotografii
CREATE TABLE `plai_dev`.`photos` (
    `id` INT NOT NULL AUTO_INCREMENT ,
 `user_id` INT NOT NULL ,
  `image` LONGBLOB NOT NULL ,
   `image_type` VARCHAR(30) NOT NULL ,
    `profile` BOOLEAN NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
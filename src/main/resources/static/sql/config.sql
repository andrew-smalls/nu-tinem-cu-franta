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

--create project table
CREATE TABLE `plai_dev`.`projects` ( `id` INT NOT NULL AUTO_INCREMENT , `project_name` VARCHAR(255) NOT NULL , `organization_name` VARCHAR(255) NOT NULL , `project_coordinator` VARCHAR(100) NOT NULL , `project_status` VARCHAR(50) NOT NULL ,  PRIMARY KEY (`id`), UNIQUE `project_name` (`project_name`)) ENGINE = InnoDB;

-- do VolunteerStatus, Volunteer, Task
CREATE TABLE `plai_dev`.`volunteer_status` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `organizationId` INT NOT NULL  ,
    `volunteerId` INT NOT NULL ,
    `projectId` INT NOT NULL ,
    `currentStatus` VARCHAR(50) ,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB;

    CREATE TABLE `plai_dev`.`volunteers` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `volunteerName` VARCHAR(50) NOT NULL ,
    `roles` VARCHAR(500) ,
    `badges` VARCHAR(500) ,
    `organizations` VARCHAR(500) ,
    `currentStatus` VARCHAR(50) ,
    `profilePictureId` INT ,
    `description` VARCHAR(500) NOT NULL ,
    `interests` VARCHAR(500) ,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB;

     CREATE TABLE `plai_dev`.`tasks` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `projectId` INT NOT NULL ,
    `taskName` VARCHAR(100) NOT NULL,
    `taskGiver` VARCHAR(50) NOT NULL,
    `taskStatus` VARCHAR(50) ,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB;

    CREATE TABLE `plai_dev`.`task_assignees` (
        `id` INT NOT NULL AUTO_INCREMENT ,
        `taskId` INT NOT NULL  ,
        `volunteerId` INT NOT NULL ,
        PRIMARY KEY (`id`)
        ) ENGINE = InnoDB;
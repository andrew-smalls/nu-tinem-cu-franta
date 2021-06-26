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
CREATE TABLE `plai_dev`.`users` ( `id` INT NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(50) NOT NULL , `last_name` VARCHAR(50) NOT NULL , `email` VARCHAR(100) NOT NULL , `password` VARCHAR(260) NOT NULL , `role` VARCHAR(50) NOT NULL , PRIMARY KEY (`id`), UNIQUE `password` (`password`), UNIQUE `email` (`email`)) ENGINE = InnoDB;
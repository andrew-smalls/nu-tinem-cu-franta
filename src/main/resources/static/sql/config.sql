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
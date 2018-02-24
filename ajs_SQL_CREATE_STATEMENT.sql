CREATE DATABASE ajs;

USE ajs;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uuid` varchar(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM user;
CREATE SCHEMA IF NOT EXISTS `buildings`;
USE `buildings`;

CREATE TABLE IF NOT EXISTS meeting (
  roomid int(11) NOT NULL AUTO_INCREMENT,
  id bigint(20),
  name varchar(100),
  day int(11),
  people int(11),
  phone int(11),
) ;

CREATE TABLE IF NOT EXISTS users(
  username VARCHAR(64) NOT NULL primary key,
  password VARCHAR(128) NOT NULL
);
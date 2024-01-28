DROP DATABASE IF EXISTS leagueManagerTest;

create database leagueManagerTest;
use leagueManagerTest;

-- Table structure for team

CREATE TABLE team (
  tid int NOT NULL AUTO_INCREMENT,
  tName varchar(255) DEFAULT NULL,
  state varchar(255) DEFAULT NULL,
  wins integer(82) DEFAULT NULL,
  losses integer(82) DEFAULT NULL,
  payroll DECIMAL(19,4) DEFAULT NULL,
  PRIMARY KEY (tid)
);

-- Table structure for player

CREATE TABLE player (
  pid int NOT NULL AUTO_INCREMENT,
  fName varchar(255) DEFAULT NULL,
  lName varchar(255) DEFAULT NULL,
  ppg FLOAT DEFAULT NULL,
  rpg FLOAT DEFAULT NULL,
  apg FLOAT DEFAULT NULL,
  psalary DECIMAL(19,4) DEFAULT NULL,
  tid int NOT NULL,
  PRIMARY KEY (pid),
  FOREIGN KEY (tid) REFERENCES team(tid)
);


-- Table structure for Coaches

CREATE TABLE coach (
  cid int NOT NULL AUTO_INCREMENT,
  coachfName varchar(255) DEFAULT NULL,
  coachlname varchar(255) DEFAULT NULL,
  csalary DECIMAL(19,4) DEFAULT NULL,
  tid int NOT NULL,
  PRIMARY KEY (cid),
  FOREIGN KEY (tid) REFERENCES team(tid)
);


-- adding in data for team
INSERT INTO `team` VALUES (1,'celtics','Massachusetts',32,9,183480482.0000);



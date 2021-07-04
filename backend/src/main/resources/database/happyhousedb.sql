SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happyhouse` ;


-- -----------------------------------------------------
-- Table `happyhouse`.`baseaddress`
-- -----------------------------------------------------
drop table if exists baseaddress ;
CREATE TABLE IF NOT EXISTS `baseaddress` (
  `num` int NOT NULL AUTO_INCREMENT,
  `city` varchar(30) NOT NULL,
  `code` varchar(30) unique not null,
  `dongcode` varchar(30) not NULL,
  `gugun` varchar(30) DEFAULT NULL,
  `dong` varchar(30) unique default NULL,
  `lat` varchar(20) DEFAULT NULL,
  `lng` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`num`),
  INDEX baseaddress_idx(dong)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

show variables like "secure_file_priv";

load data infile 'C://ProgramData/MySQL/MySQL Server 8.0/Uploads/baseaddress.csv'
into table baseaddress fields terminated by ',' LINES TERMINATED BY '\n';

-- -----------------------------------------------------
-- Table `happyhouse`.`dongcode`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `dongcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dongcode` (
  `dongcode` varchar(30),
  `city` varchar(30),
  `gugun` varchar(30),
  `dong` varchar(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- -----------------------------------------------------
-- Table `happyhouse`.`guguncode`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `guguncode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guguncode` (
  `gugun_code` varchar(10) NOT NULL,
  `gugun_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`gugun_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- -----------------------------------------------------
-- Table `happyhouse`.`sidocode`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `sidocode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sidocode` (
  `sido_code` varchar(10) NOT NULL,
  `sido_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sido_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- -----------------------------------------------------
-- Table `happyhouse`.`houseinfo`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `houseinfo`;
CREATE TABLE IF NOT EXISTS `houseinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) NOT NULL,
  `AptName` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `buildYear` varchar(30) DEFAULT NULL,
  `jibun` varchar(30) DEFAULT NULL,
  `lat` varchar(30) DEFAULT NULL,
  `lng` varchar(30) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
   PRIMARY KEY (no),
   foreign key(dong) references baseaddress(dong),
   INDEX idx(dong,AptName)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

show variables like "secure_file_priv";

load data infile 'C://ProgramData/MySQL/MySQL Server 8.0/Uploads/houseinfo.csv'
into table houseinfo fields terminated by ',' LINES TERMINATED BY '\n';

-- -----------------------------------------------------
-- Table `happyhouse`.`housedeal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `housedeal`;
CREATE TABLE IF NOT EXISTS `housedeal` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) NOT NULL,
  `AptName` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `dealAmount` varchar(50) NOT NULL,
  `buildYear` varchar(30) DEFAULT NULL,
  `dealYear` varchar(30) DEFAULT NULL,
  `dealMonth` varchar(30) DEFAULT NULL,
  `dealDay` varchar(30) DEFAULT NULL,
  `area` varchar(30) DEFAULT NULL,
  `floor` varchar(30) DEFAULT NULL,
  `jibun` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `rentMoney` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`no`),
  FOREIGN KEY (`dong`,`AptName`) REFERENCES houseinfo(`dong`,`AptName`) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

show variables like "secure_file_priv";

load data infile 'C://ProgramData/MySQL/MySQL Server 8.0/Uploads/housedeal.csv'
into table housedeal fields terminated by ',' LINES TERMINATED BY '\n';


ALTER TABLE `happyhouse`.`baseaddress` ADD INDEX `cityindex` (city);
ALTER TABLE `happyhouse`.`baseaddress` ADD INDEX `gugunindex` (gugun);

drop table if exists environment;
CREATE TABLE IF NOT EXISTS `happyhouse`.`environment` (
  `no` VARCHAR(30) NOT NULL,
  `city` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NOT NULL,
  `companyname` VARCHAR(45) NOT NULL,
  `industrycode` VARCHAR(30) NOT NULL,
  `industryname` VARCHAR(45) NULL DEFAULT NULL,
  `checkdate` VARCHAR(30) NOT NULL,
  `checkdetail` VARCHAR(100) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `environment_city_fk_idx` (`city` ASC) VISIBLE,
  INDEX `environment_gugun_fk_idx` (`gugun` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- show variables like " file";

load data infile 'C://ProgramData/MySQL/MySQL Server 8.0/Uploads/environment_data.csv'
into table environment character set utf8mb4 fields terminated by ',' LINES TERMINATED BY '\n';

-- -----------------------------------------------------
-- Table `happyhouse`.`commercial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`commercial` ;
CREATE TABLE IF NOT EXISTS `happyhouse`.`commercial` (
  `commercialNum` VARCHAR(30) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `sectorCode` VARCHAR(10) NOT NULL,
  `sectorName` VARCHAR(30) NOT NULL,
  `guCode` VARCHAR(10) NOT NULL,
  `guName` VARCHAR(30) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `roadCode` VARCHAR(30) NOT NULL,
  `roadName` VARCHAR(100) NOT NULL,
  `roadAddress` VARCHAR(100) NOT NULL,
  
  PRIMARY KEY (`commercialNum`))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- show variables like "commercial file";

load data infile 'C://ProgramData/MySQL/MySQL Server 8.0/Uploads/commercial16985.csv'
into table commercial fields terminated by ',' LINES TERMINATED BY '\n';

-- -----------------------------------------------------
-- Table `happyhouse`.`hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`hospital` ;
CREATE TABLE IF NOT EXISTS `happyhouse`.`hospital` (
  `basedate` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NULL DEFAULT NULL,
  `hospitalname` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(100) NOT NULL,
  `type` VARCHAR(2) NULL DEFAULT NULL,
  `contact` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`address`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Import data
-- 아래 코드를 주석해제하면 csv 파일 한번에 import됩니다. 

show variables like "secure_file_priv";

load data infile 'C://ProgramData/MySQL/MySQL Server 8.0/Uploads/hospitaldata.csv'
into table hospital fields terminated by ',' LINES TERMINATED BY '\n';

-- -----------------------------------------------------
-- Table `happyhouse`.`corona_clinic`
-- -----------------------------------------------------

drop table if exists corona_clinic;
CREATE TABLE if not exists corona_clinic (
    basedate varchar(30),
    bloodyes varchar(30),
    area varchar(20),
    dong VARCHAR(20),
    clinicname varchar(100),
    address varchar(300),
    dailytime varchar(100),
    saturdaytime VARCHAR(100),
    sundaytime VARCHAR(100),
    phonenumber varchar(100),
    primary key (address)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- show variables like "secure_file_priv";

load data infile 'C://ProgramData/MySQL/MySQL Server 8.0/Uploads/clinic.csv'
into table corona_clinic fields terminated by ',' LINES TERMINATED BY '\n';

-- -----------------------------------------------------
-- Table `ssafyweb`.`ssafy_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`ssafy_member` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`ssafy_member` (
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `userpwd` VARCHAR(16) NOT NULL,
  `email` VARCHAR(50) NULL,
  `address` VARCHAR(100) NULL,
  `joindate` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;

INSERT INTO ssafy_member (userid, username, userpwd, email, address)
VALUES('admin', '관리자', 'admin', 'admin@ssafy.com','서울시 역삼동');

INSERT INTO ssafy_member (userid, username, userpwd, email, address)
VALUES('ssafy', '김싸피', 'ssafy', 'ssafy@ssafy.com','대전시 덕명동');


-- -----------------------------------------------------
-- Table `happyhouse`.`article`
-- -----------------------------------------------------

drop table if exists article;
CREATE TABLE IF NOT EXISTS `happyhouse`.`article` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NOT NULL,
  `subject` VARCHAR(100) NOT NULL,
  `content` VARCHAR(2000) NOT NULL,
  `regtime` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX `article_userid_FK_idx` (`userid` ASC) VISIBLE,
  PRIMARY KEY (`articleno`),
  CONSTRAINT `article_userid_FK`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`ssafy_member` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

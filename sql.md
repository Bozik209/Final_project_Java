## javaProject
```
create database javaProject;

use javaProject;
```
## Person
```

CREATE TABLE `javaproject`.`Person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `idNumber` VARCHAR(9) NULL,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Role` INT NOT NULL,
  PRIMARY KEY (`id`));

```
## Committee
```

CREATE TABLE `javaproject`.`Committee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Personid` INT NOT NULL ,
  `Seniority` INT NULL,
  FOREIGN KEY (Personid) REFERENCES Person(id),
  PRIMARY KEY (`id`));

```
## Tenant
```

CREATE TABLE `javaproject`.`Tenant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Personid` INT NOT NULL ,
  `apartmentNumber` INT NULL,
  `Jan` INT NULL,
  `Feb` INT NULL,
  `Mar` INT NULL,
  `Apr` INT NULL,
  `May` INT NULL,
  `Jun` INT NULL,
  `Jul` INT NULL,
  `Aug` INT NULL,
  `Sep` INT NULL,
  `Oct` INT NULL,
  `Nov` INT NULL,
  `Dec` INT NULL,
  FOREIGN KEY (Personid) REFERENCES Person(id),
  PRIMARY KEY (`id`));


```

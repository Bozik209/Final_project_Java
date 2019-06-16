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
  FOREIGN KEY (Personid) REFERENCES Person(id),
  PRIMARY KEY (`id`));

```
## payments
```
CREATE TABLE `payments` (
  `paymentId` int(11) NOT NULL,
  `paymentSum` decimal(10,0) DEFAULT NULL,
  `idTenants` int(11) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `fk_tenant_payment_idx` (`idTenants`),
  CONSTRAINT `fk_tenant_payment` FOREIGN KEY (`idTenants`) REFERENCES `Tenant` (`Personid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

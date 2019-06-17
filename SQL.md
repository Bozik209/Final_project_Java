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

## query
```
-- ------------------------------------------------------------------------------------------------------------
```
### 2.שאילתה לקבלת החודשים ששילם הדייר.
```
-- all  month
select paymentSum,paymentDate
from payments;

-- by date
select paymentSum,paymentDate
from payments
where MONTH(paymentDate)=06;

-- ------------------------------------------------------------------------------------------------------------

-- 3.שאילתה של כל הדיירים עם מספר דירה וכל החודשים ששולמו.
select person.FirstName,person.LastName, payments.paymentSum ,payments.paymentDate ,tenant.apartmentNumber
from person
INNER JOIN payments ON person.id=payments.paymentId
LEFT JOIN tenant on person.id=tenant.id;

-- ------------------------------------------------------------------------------------------------------------

-- 4.עדכון של תשלום של דייר מאת ועד הבית.
-- מספר דירה,חודש,
UPDATE payments
SET paymentSum=250
WHERE 1=payments.paymentId;   -- the tenant number toy want update

select * from payments;

-- ------------------------------------------------------------------------------------------------------------
-- 5.הצגת הכנסה חודשית לפי חודשים לבניין.(כמה שילמו באותו חודש.)
SELECT paymentDate,SUM(paymentSum)
FROM payments
GROUP BY MONTH(paymentDate);

select * from payments;

-- ------------------------------------------------------------------------------------------------------------
-- 6.שאילתה שתיתן לדייר לצפות כמה תשלומים שילם בכל חודש.

select person.id,person.FirstName,payments.paymentSum, MONTH(payments.paymentDate)
from payments 
INNER JOIN person ON person.id=1
GROUP BY MONTH(paymentDate);

-- ------------------------------------------------------------------------------------------------------------
-- 7.בדיקת סיסמא.
SELECT username,Password 
FROM person 
WHERE username = '?' AND password = ?;
-- WHERE username = 'israel' AND password = 123456;
-- ------------------------------------------------------------------------------------------------------------
```

DROP TABLE IF EXISTS `ast_SalesData_T`;

CREATE TABLE `ast_SalesData_T` ( `autoid` INT(10) NOT NULL AUTO_INCREMENT, `channelId` VARCHAR(64) NOT NULL, `reatilercode` VARCHAR(64) NOT NULL, `retailername` VARCHAR(64) NOT NULL, `salesdate` DATE NOT NULL, `salesmonth` INT(10) NOT NULL, `salesyear` INT(10) NOT NULL, `salesinvoicenbr` VARCHAR(64) NOT NULL, `materialdesc` VARCHAR(64) NOT NULL, `branddesc` VARCHAR(64) NOT NULL, `salesqty` DOUBLE(10,2) NOT NULL, `netsalesamt` DOUBLE(10,2) NOT NULL, `grosssalesamt` DOUBLE(10,2) NOT NULL, `materialcode` VARCHAR(64) NOT NULL, `brandcode` VARCHAR(64) NOT NULL, `category` VARCHAR(64) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`autoid`));
